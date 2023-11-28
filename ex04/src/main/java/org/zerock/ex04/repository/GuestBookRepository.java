package org.zerock.ex04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.ex04.entity.GuestBook;

public interface GuestBookRepository extends JpaRepository<GuestBook,Long>, QuerydslPredicateExecutor<GuestBook> {
}
