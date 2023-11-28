package com.example.ex02.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User {

    @Id
    @Column(length = 20)
    private String id;

    @Column(length = 200)
    private String pw;
}
