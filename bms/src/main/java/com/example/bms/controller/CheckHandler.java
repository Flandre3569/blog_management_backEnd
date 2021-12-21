package com.example.bms.controller;

import com.example.bms.entity.Check;
import com.example.bms.mapper.CheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
