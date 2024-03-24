package com.hegazy.mohammed.entities.audit;

import jakarta.persistence.*;
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

public abstract class Audoting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @CreatedDate
    protected LocalDateTime registeredAt;
    @LastModifiedDate
    protected LocalDateTime lastLogin;
}
