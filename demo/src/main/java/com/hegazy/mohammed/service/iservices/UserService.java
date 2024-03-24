package com.hegazy.mohammed.service.iservices;

import com.hegazy.mohammed.dto.user.UpdateUserDto;
import com.hegazy.mohammed.dto.user.AddUserDtoRequest;
import com.hegazy.mohammed.dto.user.AllUserDtoResponse;
import com.hegazy.mohammed.dto.user.UserDtoResponse;

import java.util.List;

public  interface UserService {
    void addUser( AddUserDtoRequest userDto);
    UserDtoResponse findUserById(int id);
    List<AllUserDtoResponse> findAll();
    UserDtoResponse updateUser(UpdateUserDto userDto);
    void deleteUser(int id);
}
