package com.kwak.remote.repository;

import com.kwak.remote.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
