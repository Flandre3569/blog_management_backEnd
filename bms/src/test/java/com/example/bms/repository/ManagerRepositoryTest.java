package com.example.bms.repository;

import com.example.bms.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerRepositoryTest {
    @Autowired
    private ManagerRepository managerRepository;
    @Test
    void findById() {
        System.out.println(managerRepository.findById(1));
    }

    @Test
    public void addUser() {
        List<Manager> manageList = managerRepository.findAll();
        String loginStatus = "";
        for (Manager ma: manageList) {
            if(ma.getName().equals("test")&&ma.getPassword().equals("test")) {
                System.out.println("success");
                return;
            }else {
                System.out.println("failure");
            }
        }
    }
}