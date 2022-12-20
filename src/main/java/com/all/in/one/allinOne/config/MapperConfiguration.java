package com.all.in.one.allinOne.config;

import com.all.in.one.allinOne.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    public UserMapper userMapper() {
        return UserMapper.INSTANCE;
    }

}