package com.all.in.one.allinOne.security.filter;

import com.all.in.one.allinOne.entity.User;
import com.all.in.one.allinOne.error.exception.UserNotEnabledException;
import com.all.in.one.allinOne.service.UserService;
import com.all.in.one.allinOne.util.SecurityUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response
    ) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("{} logged in.", username);

        try {
            userService.loadUserByUsername(username);
        } catch (UserNotEnabledException ex) {
            response.setHeader("error", ex.getMessage());
            response.setStatus(NOT_ACCEPTABLE.value());

            final Map<String, String> error = Map.of("error_message", ex.getMessage());
            response.setContentType(APPLICATION_JSON_VALUE);

            writeValue(response, error);
        } catch (Exception exception) {
            response.setHeader("error", exception.getMessage());
            response.setStatus(FORBIDDEN.value());

            final Map<String, String> error = Map.of("error_message", exception.getMessage());
            response.setContentType(APPLICATION_JSON_VALUE);

            writeValue(response, error);
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication
    ) throws IOException {
        User user = (User) authentication.getPrincipal();
        String requestUrl = request.getRequestURL().toString();
        String accessToken = SecurityUtil.getAccessToken(user, requestUrl);
        String refreshToken = SecurityUtil.getRefreshToken(user, requestUrl);
        final Map<String, String> tokens = SecurityUtil.getTokenMap(accessToken, refreshToken);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }

    private void writeValue(HttpServletResponse response, Map<String, String> error) {
        try {
            new ObjectMapper().writeValue(response.getOutputStream(), error);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
