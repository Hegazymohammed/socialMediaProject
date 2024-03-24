package com.hegazy.mohammed.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserDtoRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

}
