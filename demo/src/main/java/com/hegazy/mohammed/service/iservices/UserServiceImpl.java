package com.hegazy.mohammed.service.iservices;

import com.hegazy.mohammed.dto.user.UpdateUserDto;
import com.hegazy.mohammed.dto.user.AddUserDtoRequest;
import com.hegazy.mohammed.dto.user.AllUserDtoResponse;
import com.hegazy.mohammed.dto.user.UserDtoResponse;
import com.hegazy.mohammed.entities.user.User;
import com.hegazy.mohammed.exceptions.UserNotFoundException;
import com.hegazy.mohammed.mapper.UserMapper;
import com.hegazy.mohammed.repositories.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public void addUser(AddUserDtoRequest userDto) {
            User usermapper =mapper.map(userDto,User.class);
            //first i need to hash password
            usermapper.setPasswordHash(this.hashPassword(userDto.getPassword()));
            usermapper.setRegisteredAt(LocalDateTime.now());

            User savedUser=userRepository.save(usermapper);
            
    }

    @Override
    public UserDtoResponse findUserById(int id) {
        Optional<User>user=userRepository.findById(id);
        if(user.isEmpty())
                throw new UserNotFoundException("This user doesn't exist");
        return user.map(UserMapper::dtoResponse).get();
    }

    @Override
    public List<AllUserDtoResponse> findAll() {
        return userRepository.findAllUser();
    }

    @Override
    public UserDtoResponse updateUser(UpdateUserDto userDto) {

         User updatedUser=UserMapper.user(userDto);
         updatedUser.setPasswordHash(hashPassword(userDto.password()));
         User user=userRepository.save(updatedUser);
         return UserMapper.dtoResponse(user);
    }

    @Override
    public void deleteUser(int id) {
            User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User  doesn't Exist"));
            userRepository.delete(user);
    }

    private String hashPassword(String input){
         StringBuilder result=new StringBuilder();
         try{
             MessageDigest messageDigest=MessageDigest.getInstance("SHA-512");
             byte[]digested=messageDigest.digest(input.getBytes());
             for (int i = 0; i < digested.length; i++) {
                    result.append(Integer.toHexString(digested[i]&0xf));
             }
             return result.toString();
         }
         catch (NoSuchAlgorithmException ex){
             ex.printStackTrace();
         }
        return null;
    }
}
