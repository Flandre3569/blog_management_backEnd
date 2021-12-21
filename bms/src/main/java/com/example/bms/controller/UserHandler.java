package com.example.bms.controller;


import com.example.bms.entity.User;
import com.example.bms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/selectAll")
    public List<User> findAll() {
        return userMapper.findAllUser();
    }

}
