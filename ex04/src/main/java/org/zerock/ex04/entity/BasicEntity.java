package org.zerock.ex04.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass //테이블 미생성(부모클래스로만 사용)
@Getter
@EntityListeners(value = {AuditingEntityListener.class}) //메인에 @EnableJpaAuditing필수
abstract class BasicEntity {
    @CreatedDate    //객체 생성시간
    @Column(name="regdate",updatable = false)
    private LocalDateTime regDate;
    @LastModifiedDate //마지막 수정시간
    @Column(name = "moddate")
    private LocalDateTime modDate;
}
