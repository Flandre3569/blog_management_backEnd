package com.example.bms.mapper;

import com.example.bms.entity.Check;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CheckMapperTest {
    @Autowired
    private CheckMapper checkMapper;
    @Test
    public void findAll() {
        System.out.println(checkMapper.findAll());
    }
}