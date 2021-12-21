package com.example.bms.repository;

import com.example.bms.entity.Blog;
import com.example.bms.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BlogRepositoryTest {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void findAll() {
        List<Blog> blogList = blogRepository.findAll();

        for(Blog blog:blogList) {
            Optional<Users> users = usersRepository.findById(blog.getId());
            System.out.println(users);
        }
    }
}