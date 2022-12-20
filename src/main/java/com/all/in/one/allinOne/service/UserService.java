package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.domain.User;
import com.all.in.one.allinOne.dto.request.LoginRequest;
import com.all.in.one.allinOne.dto.request.RegisterUserRequest;
import com.all.in.one.allinOne.error.ErrorCodes;
import com.all.in.one.allinOne.error.common.ServiceException;
import com.all.in.one.allinOne.mapper.UserMapper;
import com.all.in.one.allinOne.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User findById(String id) {
        User user = userRepository.findById(Integer.parseInt(id)).orElse(null);
        if (user != null) {
            log.info("user fetched from database, id: " + id);
        } else {
            log.info("there is no user, id: " + id);
        }
        return user;
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(
                () -> ServiceException.of(ErrorCodes.USER_NOT_FOUND, "user not found"));

        if (user.getPassword().equals(request.getPassword())) {
            log.info("user logged in, username: " + request.getUsername());
            return "tokennnnn";//TODO: token qaytarilmalidii
        } else {
            throw ServiceException.of(ErrorCodes.USER_NOT_FOUND, "user not found");
        }
    }

    public void register(RegisterUserRequest request) {
//        User user = userMapper.toUser(request);
        User user = new User();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.addUser(user);
        log.info("User registered successfully, username: " + request.getUsername());
    }

}
