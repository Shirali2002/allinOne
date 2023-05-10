package com.all.in.one.allinOne.mapper;

import com.all.in.one.allinOne.dto.request.LoginRequest;
import com.all.in.one.allinOne.dto.request.RegisterRequest;
import com.all.in.one.allinOne.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Random;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
//
//    @Mapping(target = "email", source = "email")
//    @Mapping(target = "name", source = "name")
//    @Mapping(target = "surname", source = "surname")
//    @Mapping(target = "password", source = "password")
//    User toUserForRegister(RegisterRequest registerRequest);
//
//    @Mapping(target = "email", source = "email")
//    @Mapping(target = "password", source = "password")
//    User toUserForLogin(LoginRequest loginRequest);
//
//    @AfterMapping
//    default void generateOtp(@MappingTarget User user) {
//        Random random = new Random();
//        int otp = 1000 + random.nextInt(9000);
//        user.setOtpCode(otp);
//        user.setEnabled(Boolean.FALSE);
//    }
////
////    @Named("generateOtp")
////    default int generateOtp(Integer otpCode) {
////        Random random = new Random();
////        return 1000 + random.nextInt(9000);
////    }

}
