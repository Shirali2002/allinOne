package com.all.in.one.allinone.config;

import com.all.in.one.allinone.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final String[] WHITE_LIST = new String[]{
            // AuthController
            "/auth/**",
            "/auth/user/**",
//            "/login/**",
//            "/sign-in/**",

            // AdsController
            "/ads/**",

            // UtilityController
            "/util/**",

//            "/util/fill/**",
//            "/util/fill/model/**",
//            "/util/fill/brand/**",
//            "/util/fill/ads/**",
//            "/util/dashboard/fields/**",
//            "/util/dashboard/models/**",

//            "/token/refresh/**",
//            "/register/**",
//            "/verify/**",
//            "/check/reset-password/**",
//            "/process/reset-password/**",
//            "/reset-password/**",

            // others
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/v2/api-docs/**",
            "/swagger-resources/**",
    };

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(WHITE_LIST)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

}
