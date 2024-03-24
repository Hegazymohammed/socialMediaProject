package com.hegazy.mohammed.repositories.user;

import com.hegazy.mohammed.dto.user.AllUserDtoResponse;
import com.hegazy.mohammed.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends  JpaRepository<User,Integer>{
        @Query("""
                SELECT NEW com.hegazy.mohammed.dto.user.AllUserDtoResponse
                (u.id,u.firstName,u.username) from User u
                """)
      List<AllUserDtoResponse> findAllUser();

}
