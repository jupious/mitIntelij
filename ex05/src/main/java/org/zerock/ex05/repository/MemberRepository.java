package org.zerock.ex05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex05.entity.Member;

public interface MemberRepository extends JpaRepository<Member,String> {
}
