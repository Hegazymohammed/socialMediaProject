package com.hegazy.mohammed.mapper;

import com.hegazy.mohammed.dto.user.UpdateUserDto;
import com.hegazy.mohammed.dto.user.UserDtoResponse;
import com.hegazy.mohammed.entities.user.User;

import java.time.LocalDateTime;

public class UserMapper {

    public static UserDtoResponse dtoResponse(User user){

        return new UserDtoResponse(user.getId(),user.getFirstName(),user.getMiddleName(),user.getLastName(),user.getMobile(),
                user.getEmail(),user.getUsername());
    }

    public static User user(UpdateUserDto dto){
        User user= User.builder()
                .firstName(dto.firstName())

                .lastName(dto.lastName())
                .middleName(dto.middleName())
                .email(dto.email())
                .profile(dto.profile())
                .mobile(dto.mobile())
                .username(dto.username())

                .build();
        user.setId(dto.id());
        user.setRegisteredAt(LocalDateTime.now());
        return user;
    }
}
