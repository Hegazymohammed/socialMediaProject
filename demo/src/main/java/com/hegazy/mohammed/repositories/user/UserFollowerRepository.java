package com.hegazy.mohammed.repositories.user;

import com.hegazy.mohammed.dto.user.AllUserDtoResponse;
import com.hegazy.mohammed.dto.userFollower.AllFollowersDtoResponse;
import com.hegazy.mohammed.entities.user.UserFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserFollowerRepository extends  JpaRepository<UserFollower,Integer>{
    @Query("""
                SELECT new com.hegazy.mohammed.dto.userFollower.AllFollowersDtoResponse(uf.targetId.id,uf.targetId.firstName,uf.targetId.lastName
                ,uf.targetId.middleName,uf. targetId.username,uf.type) 
                from UserFollower uf where uf.sourceId.id=:id
        """)
    List<AllFollowersDtoResponse> findAllUserFollower(int id);
}
