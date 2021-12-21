package com.example.bms.controller;


import com.example.bms.entity.Label;
import com.example.bms.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/label")
public class LabelHandler {
    @Autowired
    private LabelRepository labelRepository;
    @GetMapping("/selectAll")
    public List<Label> findAll() {
        return labelRepository.findAll();
    }

    @PostMapping("/addLabel")
    public Label addLabel(@RequestBody Label label) {
        Label result = labelRepository.save(label);
        return result;
    }
    @GetMapping("/select/{id}")
    public Optional<Label> find(@PathVariable("id") Integer id) {
        return labelRepository.findById(id);
    }

    @PatchMapping("/update")
    public String updateLabel(@RequestBody Label label) {
        Label result = labelRepository.save(label);
        if(result != null) {
            return "success";
        } else {
            return "false";
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        labelRepository.deleteById(id);
    }
}
