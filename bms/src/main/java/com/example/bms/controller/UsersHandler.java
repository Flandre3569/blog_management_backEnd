package com.example.bms.controller;

import com.example.bms.entity.Users;
import com.example.bms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping("/addUser")
    public String addUser(@RequestBody Users user) {
        Users result = usersRepository.save(user);
        if(result != null) {
            return "success";
        } else {
            return "false";
        }
    }
    @GetMapping("/select/{id}")
    public Optional<Users> find(@PathVariable("id") Integer id) {
        return usersRepository.findById(id);
    }

    @PatchMapping("/update")
    public String updateUser(@RequestBody Users user) {
        Users result = usersRepository.save(user);
        if(result != null) {
            return "success";
        } else {
            return "false";
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        usersRepository.deleteById(id);
    }
}