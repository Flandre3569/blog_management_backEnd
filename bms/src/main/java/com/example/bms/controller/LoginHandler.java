package com.example.bms.controller;

import com.example.bms.entity.Manager;
import com.example.bms.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/login")
public class LoginHandler {
    @Autowired
    private ManagerRepository managerRepository;

    @PostMapping("/manage")
    public Manager addUser(@RequestBody Manager manager) {
        List<Manager> manageList = managerRepository.findAll();
        Manager manager1 = new Manager();
        for (Manager ma: manageList) {
            if(ma.getName().equals(manager.getName()) && ma.getPassword().equals(manager.getPassword())) {
                manager1 = ma;
            }
        }
        return manager1;
    }

}
