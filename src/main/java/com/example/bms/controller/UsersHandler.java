package com.example.bms.controller;

import com.example.bms.entity.Users;
import com.example.bms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersHandler {
    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/selectAll/{page}/{size}")
    public Page<Users> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
       return usersRepository.findAll(pageable);
    }

    @PostMapping("/users/add")
    public String addUser(@RequestBody Users user) {
        Users result = usersRepository.save(user);
        if(result != null) {
            return "success";
        } else {
            return "false";
        }
    }
}
