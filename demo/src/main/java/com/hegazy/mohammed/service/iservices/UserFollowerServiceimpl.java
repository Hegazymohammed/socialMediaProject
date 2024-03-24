package com.hegazy.mohammed.service.iservices;

import com.hegazy.mohammed.dto.userFollower.AllFollowersDtoResponse;
import com.hegazy.mohammed.dto.userFollower.CreateFollowerDtoRequest;
import com.hegazy.mohammed.dto.userFollower.UpdateFollowerDtoRequest;
import com.hegazy.mohammed.entities.user.User;
import com.hegazy.mohammed.entities.user.UserFollower;
import com.hegazy.mohammed.exceptions.UserNotFoundException;
import com.hegazy.mohammed.repositories.user.UserFollowerRepository;
import com.hegazy.mohammed.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class UserFollowerServiceimpl implements CrudOperation <AllFollowersDtoResponse,CreateFollowerDtoRequest,

        UpdateFollowerDtoRequest,UserFollowerResponse>{

    private final UserRepository userRepository;
    private final UserFollowerRepository userFollowerRepository;
    @Autowired
    public UserFollowerServiceimpl(UserRepository userRepository, UserFollowerRepository userFollower) {
        this.userRepository = userRepository;
        this.userFollowerRepository = userFollower;
    }


    @Override
    public void add(int sourceId, CreateFollowerDtoRequest addUserFollowerDto) {
           User source=userRepository.findById(sourceId).orElseThrow(()->new UserNotFoundException("User Doesn't Exist"));
           User target=userRepository.findById(addUserFollowerDto.targetId()).orElseThrow(()->new UserNotFoundException("User Doesn't Exist"));
           UserFollower  follower=new UserFollower();
           follower.setSourceId(source);
           follower.setTargetId(target);
        LocalDateTime localDateTime=LocalDateTime.now();
        follower.setCreatedAt(localDateTime);
        follower.setUpdatedAt(localDateTime);
        follower.setType(addUserFollowerDto.type());
        userFollowerRepository.save(follower);
    }

    @Override
    public List<AllFollowersDtoResponse > findAll(int sourceId) {
        return userFollowerRepository.findAllUserFollower(sourceId);
    }

    @Override
    public UserFollowerResponse update(int sourceId,UpdateFollowerDtoRequest entity) {
        return null;
    }

    @Override
    public void delete(int first, int second) {

    }
}
