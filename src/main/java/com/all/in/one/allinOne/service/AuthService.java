package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.config.properties.SecurityConstants;
import com.all.in.one.allinOne.dto.request.RegisterRequest;
import com.all.in.one.allinOne.dto.request.ResetPasswordRequest;
import com.all.in.one.allinOne.dto.request.VerifyResetPasswordRequest;
import com.all.in.one.allinOne.dto.request.VerifyUserRequest;
import com.all.in.one.allinOne.entity.User;
import com.all.in.one.allinOne.error.exception.DuplicateUsernameException;
import com.all.in.one.allinOne.error.exception.EmailProviderException;
import com.all.in.one.allinOne.error.exception.PasswordsNotMatchedException;
import com.all.in.one.allinOne.error.exception.UserNotFoundException;
import com.all.in.one.allinOne.error.exception.VerificationFailedException;
import com.all.in.one.allinOne.util.EmailProvider;
import com.all.in.one.allinOne.util.SecurityUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

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

        if (!request.isPasswordsMatched()) {
            throw new PasswordsNotMatchedException("passwords not matched");
        }

        User user = new User();

        String password = request.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(encodedPassword);

        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());

//        user.setOtpCode(generateOtp()); //TODO: mapper
        user.setEnabled(true);

//        try {
//            emailProvider.sendRegistrationOtp(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new EmailProviderException("error occurred in email sending process.");
//        }

        userService.save(user);
    }

    @Transactional
    public void verifyRegisterUser(VerifyUserRequest request) {
        User user = userService.getByUsername(request.getEmail());

        if (Objects.isNull(user)) {
            throw new UserNotFoundException("user not found");
        }

        if (!Objects.equals(user.getOtpCode(), request.getOtpCode())) {
            throw new VerificationFailedException("otp code is not matched");
        }

        user.setOtpCode(null);
        user.setEnabled(true);
        userService.update(user);

    }

    @Transactional
    public Boolean checkResetPasswordOtp(VerifyResetPasswordRequest request) {
        User user = userService.getByUsername(request.getEmail());

        if (Objects.isNull(user)) {
            throw new UserNotFoundException("user not found");
        }

        return Objects.equals(user.getOtpCode(), request.getOtp());
    }

    @Transactional
    public void processResetPassword(String email) {
        User user = userService.getByUsername(email);

        if (user == null) {
            throw new UserNotFoundException("user not found");
        }

        Integer otpCode = generateOtp();
        user.setOtpCode(otpCode);

        try {
            emailProvider.sendResetPasswordOtp(user);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new EmailProviderException("error occurred in email sending process.");
        }

        userService.update(user);

    }

    @Transactional
    public void resetPassword(ResetPasswordRequest request) {
        if (request == null || !request.isPasswordMatched()) {
            throw new PasswordsNotMatchedException("password not matched");
        }

        User user = userService.getByUsername(request.getEmail());

        if (Objects.isNull(user)) {
            throw new UserNotFoundException("user not found");
        }

        if (!Objects.equals(user.getOtpCode(), request.getOtpCode())) {
            throw new VerificationFailedException("otp is not ok");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());

        user.setOtpCode(null);
        user.setPassword(encodedPassword);

        userService.update(user);
    }

    private int generateOtp() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }

}
