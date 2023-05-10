package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.entity.User;
import com.all.in.one.allinOne.error.exception.UserNotEnabledException;
import com.all.in.one.allinOne.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        if (!user.isEnabled()) {
            throw new UserNotEnabledException("user not enabled");
        }

        return user;
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(User user) {
        userRepository.update(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByEmail(username).orElse(null);
    }

}
