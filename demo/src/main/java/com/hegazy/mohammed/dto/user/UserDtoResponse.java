package com.hegazy.mohammed.dto.user;

public record UserDtoResponse(
          int id ,

          String firstName ,
          String middleName ,
          String lastName ,
          String mobile ,
          String email ,
          String username
) {
}
