package com.all.in.one.allinone.service.user;

import com.all.in.one.allinone.mapper.mybatisMapper.UserMapper;
import com.all.in.one.allinone.model.mybatis.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    @Transactional
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userMapper.findUserByEmail(username);
    }

}
