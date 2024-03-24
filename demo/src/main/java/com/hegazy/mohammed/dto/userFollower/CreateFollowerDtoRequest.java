package com.hegazy.mohammed.dto.userFollower;

import lombok.Getter;
import lombok.Setter;


public record CreateFollowerDtoRequest (
        int targetId,
        int type
){

}
