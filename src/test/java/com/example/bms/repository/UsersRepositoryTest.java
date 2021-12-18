package com.example.bms.repository;

import com.example.bms.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;
    @Test
    void findAll() {
        System.out.println(usersRepository.findAll());
    }

    @Test
    void save() {
        Users users = new Users();
        users.setName("xiaoning");
        users.setPassword("asd123");
        Users users1 = usersRepository.save(users);
        System.out.println(users1);
    }
}