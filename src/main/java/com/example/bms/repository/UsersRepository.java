package com.example.bms.repository;

import com.example.bms.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}
