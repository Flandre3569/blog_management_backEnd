package com.example.bms.controller;

import com.example.bms.aop.LogAnnotation;
import com.example.bms.entity.Check;
import com.example.bms.mapper.CheckMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckHandler {
    @Autowired
    private CheckMapper checkMapper;

    @GetMapping("/selectAll")
    @LogAnnotation(module="审核",operator="获取博客审核列表")
    public List<Check> findAll() {
        return checkMapper.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @LogAnnotation(module="删除",operator="删除博客")
    public String deleteCheck(@PathVariable("id") int id) {
        Integer i = checkMapper.deleteCheck(id);
        if(i!=0) {
            return "success";
        }else {
            return "failure";
        }
    }

    @GetMapping("/countCheck")
    public Integer countCheck() {
        return checkMapper.countCheck();
    }
}
