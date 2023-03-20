package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.config.properties.SecurityConstants;
import com.all.in.one.allinOne.dto.request.RegisterRequest;
import com.all.in.one.allinOne.dto.request.ResetPasswordRequest;
import com.all.in.one.allinOne.entity.User;
import com.all.in.one.allinOne.error.exception.DuplicateUsernameException;
import com.all.in.one.allinOne.error.exception.EmailProviderException;
import com.all.in.one.allinOne.error.exception.PasswordsNotMatchedException;
import com.all.in.one.allinOne.error.exception.UserNotFoundException;
import com.all.in.one.allinOne.util.EmailProvider;
import com.all.in.one.allinOne.util.HtmlUtil;
import com.all.in.one.allinOne.util.SecurityUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EmailProvider emailProvider;

    @Transactional
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bearerToken = request.getHeader(AUTHORIZATION);
        if (bearerToken != null && bearerToken.startsWith(SecurityConstants.BEARER_PREFIX)) {
            try {
                String username = SecurityUtil.getSubjectFromBearerToken(bearerToken);
                UserDetails user = userService.loadUserByUsername(username);

                String requestUrl = request.getRequestURL().toString();
                String accessToken = SecurityUtil.getAccessToken(user, requestUrl);
                String newRefreshToken = SecurityUtil.getRefreshToken(user, requestUrl);

                final Map<String, String> tokenMap = SecurityUtil.getTokenMap(accessToken, newRefreshToken);
                new ObjectMapper().writeValue(response.getOutputStream(), tokenMap);

            } catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());

                final Map<String, String> error = Map.of("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);

                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

    @Transactional
    public void register(RegisterRequest request) {
        if (Objects.nonNull(userService.getByUsername(request.getEmail()))) {
            throw new DuplicateUsernameException("duplicate username");
        }

        User user = new User();

        if (request.isPasswordsMatched()) {
            String password = request.getPassword();
            String encodedPassword = bCryptPasswordEncoder.encode(password);
            user.setPassword(encodedPassword);
        } else {
            throw new PasswordsNotMatchedException("passwords not matched");
        }

        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());

        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);

        try {
            emailProvider.sendRegistrationEmail(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmailProviderException("error occurred in email sending process.");
        }

        userService.save(user);
    }

    @Transactional
    public String verify(String verificationCode) {
        User user = userService.getByVerificationCode(verificationCode);
        if (Objects.isNull(user) || user.isEnabled()) {
            return HtmlUtil.somethingIsWrong;
        } else {
            user.setVerificationCode(null);
            user.setEnabled(true);
            userService.save(user);
            return HtmlUtil.operationIsSuccessful;
        }
    }

    @Transactional
    public String verifyResetPassword(String token) {
        User user = userService.getByResetPasswordToken(token);
        if (user == null) {
            return HtmlUtil.somethingIsWrong;
        }
        userService.enableResetPassword(user);
        return HtmlUtil.operationIsSuccessful;
    }

    @Transactional
    public void processResetPassword(String email) {
        User user = userService.getByUsername(email);

        if (user == null) {
            throw new UserNotFoundException("user not found");
        }

        String token = RandomString.make(64);
        userService.updateResetPasswordToken(token, email);
        try {
            emailProvider.sendResetPasswordEmail(user);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void resetPassword(ResetPasswordRequest request) {
        if (request == null || !request.isPasswordMatched()) {
            throw new PasswordsNotMatchedException("password not matched");
        }

        userService.updateForgottenPassword(request.getEmail(), request.getPassword());
    }

}
