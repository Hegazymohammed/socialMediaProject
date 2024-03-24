package com.hegazy.mohammed.dto.user;

import jakarta.persistence.Column;

public record UpdateUserDto(

       int    id,
        String firstName ,
        String middleName ,
        String lastName ,
        String mobile ,
        String email ,
        String username,
        String password,
        String profile
) {
}
