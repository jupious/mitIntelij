package org.zerock.ex05.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private String email;
    private String password;
    private String name;
}
