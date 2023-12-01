package org.zerock.ex05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex05.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
}
