package com.kwak.remote.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Manager {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;
    @Column(length = 20,nullable = false)
    private String part;
    @Column(length = 20,nullable = false)
    private String name;
    @Column(length = 30)
    private String tel;
}
