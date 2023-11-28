package mit.quiz.Day1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Day1 {
    @Id
    @Column(length = 10)
    private String id;
    @Column(length = 20,nullable = false)
    private String pw;
    @Column(length = 255)
    private String memo;
}
