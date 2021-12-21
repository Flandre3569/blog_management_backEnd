package com.example.bms.controller;

import com.example.bms.entity.Blog;
import com.example.bms.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogHandler {
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/selectAll/{page}/{size}")
    public Page<Blog> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        return blogRepository.findAll(pageable);
    }

    @PostMapping("/addBlog")
    public String addUser(@RequestBody Blog blog) {
        Blog result = blogRepository.save(blog);
        if(result != null) {
            return "success";
        } else {
            return "false";
        }
    }

    @GetMapping("/select/{id}")
    public Optional<Blog> find(@PathVariable("id") Integer id) {
        return blogRepository.findById(id);
    }

    @PatchMapping("/update")
    public String updateBlog(@RequestBody Blog blog) {
        Blog result = blogRepository.save(blog);
        if(result != null) {
            return "success";
        } else {
            return "false";
        }
    }

    @DeleteMapping("/delete/{id}")
    public void updateBlog(@PathVariable("id") Integer id) {
        blogRepository.deleteById(id);
    }
}
