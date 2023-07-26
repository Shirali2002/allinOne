package com.all.in.one.allinone.mapper.modelMapper;

import com.all.in.one.allinone.model.dto.request.RegisterRequest;
import com.all.in.one.allinone.model.mybatis.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = PasswordEncoder.class)
public abstract class UserModelMapper {

    public static final UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    private PasswordEncoder passwordEncoder;

    @Mapping(target = "enableddd", constant = "true")
    @Mapping(target = "password", source = "password", qualifiedByName = "encodePassword")
    public abstract User toUser(RegisterRequest request);

    @Named("encodePassword")
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Autowired
    protected void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

}
