package com.example.bms.controller;


import com.example.bms.aop.LogAnnotation;
import com.example.bms.entity.Label;
import com.example.bms.mapper.LabelMapper;
import com.example.bms.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/label")
public class LabelHandler {
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private LabelMapper labelMapper;
    @GetMapping("/selectAll")
    @LogAnnotation(module="标签",operator="获取所有标签")
    public List<Label> findAll() {
        return labelRepository.findAll();
    }

    @PostMapping("/addLabel")
    @LogAnnotation(module="标签",operator="添加标签")
    public Label addLabel(@RequestBody Label label) {
        Label result = labelRepository.save(label);
        return result;
    }
    @GetMapping("/select/{id}")
    @LogAnnotation(module="标签",operator="通过id寻找标签")
    public Optional<Label> find(@PathVariable("id") Integer id) {
        return labelRepository.findById(id);
    }

    @PatchMapping("/update")
    @LogAnnotation(module="标签",operator="更新标签")
    public String updateLabel(@RequestBody Label label) {
        Label result = labelRepository.save(label);
        if(result != null) {
            return "success";
        } else {
            return "false";
        }
    }

    @DeleteMapping("/delete/{id}")
    @LogAnnotation(module="标签",operator="删除标签")
    public void delete(@PathVariable("id") Integer id) {
        labelRepository.deleteById(id);
    }

    @GetMapping("/countLabel")
    public Integer countLabel() {
        return labelMapper.countLabel();
    }

}
