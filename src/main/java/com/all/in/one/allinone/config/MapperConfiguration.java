package com.all.in.one.allinone.config;

import com.all.in.one.allinone.mapper.modelMapper.UserModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    public UserModelMapper userModelMapper() {
        return UserModelMapper.INSTANCE;
    }

}