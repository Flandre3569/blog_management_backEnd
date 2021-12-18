package com.example.bms.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerRepositoryTest {
    @Autowired
    private ManagerRepository managerRepository;
    @Test
    void findById() {
        System.out.println(managerRepository.findById(1));
    }
}