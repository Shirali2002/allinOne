package com.all.in.one.allinOne.security.filter;

import com.all.in.one.allinOne.config.properties.SecurityConstants;
import com.all.in.one.allinOne.util.SecurityUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    private final List<String> NO_AUTH = List.of("/login",
            "/sign-in",
            "/util/fill",
            "/util/fill/model",
            "/util/fill/ads",
            "/util/fill/brand",
            "/util/dashboard/fields",
            "/util/dashboard/models",
            "/token/refresh",
            "/register",
            "/process/reset-password",
            "/check/reset-password",
            "/reset-password",
            "/verify");

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain
    ) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if (NO_AUTH.contains(servletPath)) {
            filterChain.doFilter(request, response);
        } else {
            String bearerToken = request.getHeader(AUTHORIZATION);
            if (bearerToken != null && bearerToken.startsWith(SecurityConstants.BEARER_PREFIX)) {
                try {
                    DecodedJWT decodedJWT = SecurityUtil.getDecodedJwtFromBearerToken(bearerToken);
                    String username = decodedJWT.getSubject();
                    String[] roles = decodedJWT.getClaim("roles").asArray(String.class);

                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    Arrays.stream(roles)
                            .forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(username, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                    filterChain.doFilter(request, response);
                } catch (Exception exception) {
                    log.error("Error logging in: {} ", exception.getMessage());
                    response.setHeader("error", exception.getMessage());
                    response.setStatus(FORBIDDEN.value());
                    Map<String, String> error = Map.of("error_message", exception.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), error);
                }
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
}
