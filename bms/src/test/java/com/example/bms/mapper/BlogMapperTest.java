package com.example.bms.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogMapperTest {
    @Autowired
    private BlogMapper blogMapper;
    @Test
    public void findAll() {
        System.out.println(blogMapper.findAll());
    }
}