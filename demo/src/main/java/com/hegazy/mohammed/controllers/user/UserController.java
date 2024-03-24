package com.hegazy.mohammed.controllers.user;

import com.hegazy.mohammed.dto.user.UpdateUserDto;
import com.hegazy.mohammed.dto.user.AddUserDtoRequest;
import com.hegazy.mohammed.dto.user.AllUserDtoResponse;
import com.hegazy.mohammed.dto.user.UserDtoResponse;
import com.hegazy.mohammed.service.iservices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 @RequestMapping(path = "/user/")
public class UserController {
     private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("all")
    public ResponseEntity<List<AllUserDtoResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDtoResponse> findUserById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(id));
    }
    @PostMapping("")
    public ResponseEntity addUser(@RequestBody AddUserDtoRequest addUserDtoRequest){
        userService.addUser(addUserDtoRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping
    public ResponseEntity<UserDtoResponse> updateUser(@RequestBody UpdateUserDto dto){
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(dto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
                userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
