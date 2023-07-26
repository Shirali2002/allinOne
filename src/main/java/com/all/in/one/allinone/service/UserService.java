package com.all.in.one.allinone.service;


import com.all.in.one.allinone.model.mybatis.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserService {


    @Transactional
    void save(User user);

    @Transactional
    void update(User user);

    Optional<User> getByUsername(String username);
}
