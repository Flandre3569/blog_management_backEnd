package com.example.bms.controller;


import com.example.bms.aop.LogAnnotation;
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
    @LogAnnotation(module="用户",operator="获取所有用户")
    public List<User> findAll() {
        return userMapper.findAllUser();
    }

    @GetMapping("/countUser")
    public Integer countUser() {
        return userMapper.countUser();
    }
}
