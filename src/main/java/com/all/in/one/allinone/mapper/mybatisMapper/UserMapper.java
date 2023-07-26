package com.all.in.one.allinone.mapper.mybatisMapper;


import com.all.in.one.allinone.model.mybatis.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMapper {

    Optional<User> findUserByEmail(@Param("email") String email);

    void insert(User user);

    void update(User user);

}
