package com.example.bms.controller;

import com.example.bms.entity.Blog;
import com.example.bms.entity.Check;
import com.example.bms.entity.Label;
import com.example.bms.entity.Users;
import com.example.bms.mapper.CheckMapper;
import com.example.bms.repository.BlogRepository;
import com.example.bms.repository.LabelRepository;
import com.example.bms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckHandler {
    @Autowired
    private CheckMapper checkMapper;

    @GetMapping("/selectAll")
    public List<Check> findAll() {
        return checkMapper.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCheck(@PathVariable("id") int id) {
        Integer i = checkMapper.deleteCheck(id);
        if(i!=0) {
            return "success";
        }else {
            return "failure";
        }
    }
}
