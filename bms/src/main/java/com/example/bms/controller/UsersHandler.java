package com.example.bms.controller;

import com.example.bms.aop.LogAnnotation;
import com.example.bms.entity.Users;
import com.example.bms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersHandler {
    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/selectAll/{page}/{size}")
    @LogAnnotation(module="用户",operator="获取用户列表")
    public Page<Users> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
       return usersRepository.findAll(pageable);
    }

    @PostMapping("/addUser")
    @LogAnnotation(module="用户",operator="添加用户")
    public String addUser(@RequestBody Users user) {
        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Password);
        Users result = usersRepository.save(user);
        if(result != null) {
            return "success";
        } else {
            return "false";
        }
    }
    @GetMapping("/select/{id}")
    @LogAnnotation(module="用户",operator="通过id查找用户")
    public Optional<Users> find(@PathVariable("id") Integer id) {
        return usersRepository.findById(id);
    }

    @PatchMapping("/update")
    @LogAnnotation(module="用户",operator="更新用户")
    public String updateUser(@RequestBody Users user) {
        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Password);
        Users result = usersRepository.save(user);
        if(result != null) {
            return "success";
        } else {
            return "false";
        }
    }

    @DeleteMapping("/delete/{id}")
    @LogAnnotation(module="用户",operator="通过id删除用户")
    public void deleteUser(@PathVariable("id") Integer id) {
        usersRepository.deleteById(id);
    }
}
