package com.all.in.one.allinOne.mapper;

import com.all.in.one.allinOne.domain.User;
import com.all.in.one.allinOne.dto.request.RegisterUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping(target = "name", source = "request.name")
//    User toUser(RegisterUserRequest request);

}
