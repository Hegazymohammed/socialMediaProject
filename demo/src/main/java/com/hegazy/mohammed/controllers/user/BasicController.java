package com.hegazy.mohammed.controllers.user;

import org.springframework.http.ResponseEntity;

import java.util.List;

public  interface BasicController<AllFollowersDtoResponse, UpdateFollowerDtoRequest, CreateFollowerDtoRequest,
        UserFollowerResponse> {

    ResponseEntity<List<AllFollowersDtoResponse>>findAll(int sourceId);
    ResponseEntity<?>delete(int source);
    ResponseEntity<UpdateFollowerDtoRequest>update(int sourceId, UpdateFollowerDtoRequest dto);
    ResponseEntity save(CreateFollowerDtoRequest dto);
    ResponseEntity<UserFollowerResponse> findById(int source,int targetId);

}
