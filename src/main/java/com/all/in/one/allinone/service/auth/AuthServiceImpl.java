package com.all.in.one.allinone.service.auth;

import com.all.in.one.allinone.mapper.modelMapper.UserModelMapper;
import com.all.in.one.allinone.model.dto.request.LoginRequest;
import com.all.in.one.allinone.model.dto.request.RegisterRequest;
import com.all.in.one.allinone.model.dto.response.AuthenticationResponse;
import com.all.in.one.allinone.model.error.exception.DuplicateUsernameException;
import com.all.in.one.allinone.model.error.exception.PasswordsNotMatchedException;
import com.all.in.one.allinone.model.mybatis.User;
import com.all.in.one.allinone.security.JwtProvider;
import com.all.in.one.allinone.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final UserModelMapper userModelMapper;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<AuthenticationResponse> register(RegisterRequest request) {
        if (userService.getByUsername(request.getEmail()).isPresent()) {
            throw new DuplicateUsernameException("duplicate username");
        }

        if (!request.isPasswordsMatched()) {
            throw new PasswordsNotMatchedException("passwords not matched");
        }

        User user = userModelMapper.toUser(request);

        userService.save(user);

        String jwtToken = jwtProvider.generateToken(user);

        return ResponseEntity.ok(AuthenticationResponse.of(jwtToken));
    }

    @Override
    public ResponseEntity<AuthenticationResponse> login(LoginRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        authenticationManager.authenticate(authenticationToken);
        User user = userService.getByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("user not found."));
        String jwtToken = jwtProvider.generateToken(user);

        return ResponseEntity.ok(AuthenticationResponse.of(jwtToken));
    }

}