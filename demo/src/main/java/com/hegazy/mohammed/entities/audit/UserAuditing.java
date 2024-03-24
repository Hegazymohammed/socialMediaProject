package com.hegazy.mohammed.entities.audit;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor

public  abstract class UserAuditing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @CreatedDate
    protected  LocalDateTime createdAt;
    @LastModifiedDate
    protected  LocalDateTime updatedAt;
}
