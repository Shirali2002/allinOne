package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.entity.User;
import com.all.in.one.allinOne.error.exception.UserNotFoundException;
import com.all.in.one.allinOne.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (Objects.isNull(user) || !user.isEnabled()) {
            throw new UsernameNotFoundException("user not found");
        }

        return user;
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    public User getByVerificationCode(String code) {
        return userRepository.findByVerificationCode(code);
    }

    @Transactional
    public void enableResetPassword(User user) {
        if (Objects.isNull(user)) {
            return;
        }

        user.setResetPasswordToken(null);
        user.setResetEnabled(Boolean.TRUE);
        userRepository.save(user);
    }

    @Transactional
    public void updateForgottenPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("user not found");
        }

        if (!Boolean.TRUE.equals(user.getResetEnabled())) {
            throw new UnsupportedOperationException();
        }

        String encodedPassword = bCryptPasswordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        user.setResetPasswordToken(null);
        user.setResetEnabled(false);
        userRepository.save(user);
    }

    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    @Transactional
    public void updateResetPasswordToken(String token, String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new UserNotFoundException("Could not find any user with the email " + email);
        }
    }

}
