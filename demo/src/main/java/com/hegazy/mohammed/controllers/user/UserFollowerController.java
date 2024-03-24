package com.hegazy.mohammed.controllers.user;

import com.hegazy.mohammed.dto.userFollower.AllFollowersDtoResponse;
import com.hegazy.mohammed.dto.userFollower.CreateFollowerDtoRequest;
import com.hegazy.mohammed.dto.userFollower.UpdateFollowerDtoRequest;
import com.hegazy.mohammed.service.iservices.UserFollowerResponse;
import com.hegazy.mohammed.service.iservices.UserFollowerServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/userfollower/")
public class UserFollowerController implements BasicController<AllFollowersDtoResponse, UpdateFollowerDtoRequest, CreateFollowerDtoRequest,
        UserFollowerResponse>{
    private final UserFollowerServiceimpl userFollowerServiceimpl;
    @Autowired
    public UserFollowerController(UserFollowerServiceimpl userFollowerServiceimpl) {
        this.userFollowerServiceimpl = userFollowerServiceimpl;
    }

    @GetMapping("{sourceId}")
    public ResponseEntity<List<AllFollowersDtoResponse>> findAll(@PathVariable int sourceId) {
        return ResponseEntity.status(HttpStatus.OK).body( userFollowerServiceimpl.findAll(sourceId));
    }

    @Override
    public ResponseEntity<?> delete(int source) {
        return null;
    }

    @Override
    public ResponseEntity<UpdateFollowerDtoRequest> update(int sourceId, UpdateFollowerDtoRequest dto) {
        return null;
    }

    @Override
    public ResponseEntity save(CreateFollowerDtoRequest dto) {
        return null;
    }

    @Override
    public ResponseEntity<UserFollowerResponse> findById(int source, int targetId) {
        return null;
    }
}
