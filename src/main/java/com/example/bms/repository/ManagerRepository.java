package com.example.bms.repository;

import com.example.bms.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
