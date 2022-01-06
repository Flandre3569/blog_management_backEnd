package com.example.bms.controller;

import com.example.bms.aop.LogAnnotation;
import com.example.bms.entity.*;
import com.example.bms.mapper.AddMapper;
import com.example.bms.mapper.BlogMapper;
import com.example.bms.mapper.CheckMapper;
import com.example.bms.repository.BlogRepository;
import com.example.bms.repository.LabelRepository;
import com.example.bms.repository.UsersRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogHandler {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private AddMapper addMapper;
    @Autowired
    private CheckMapper checkMapper;
//    jpa分页查询全部
//    @GetMapping("/selectAll/{page}/{size}")
//    public Page<Blog> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
//        Pageable pageable = PageRequest.of(page-1,size);
//        return blogRepository.findAll(pageable);
//    }

    @GetMapping("/selectBlog/{page}/{size}")
//    对此接口进行记录日志
    @LogAnnotation(module="博客",operator="获取博客列表")
    public PageInfo<Blog_Check> queryAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size) {
        PageHelper.startPage(page,size);
        List<Blog_Check> blog_checks = blogMapper.findAll();
        PageInfo<Blog_Check> pageInfo = new PageInfo<>(blog_checks);
        return pageInfo;
    }

//    blog添加
    @PostMapping("/addBlog")
    public String add(@RequestBody Blog_Check blog) {
//        把实体在blog里添加上
    Blog_Add blog_add = new Blog_Add();
    List<Users> users = usersRepository.findAll();
    blog_add.setContent(blog.getContent());
    blog_add.setName(blog.getName());
    for(Users users1:users) {
        if(users1.getName().equals(blog.getAuthor())){
            blog_add.setAuthor_id(users1.getId());
        }
    }
    List<Label> labels = labelRepository.findAll();
    for(Label label:labels) {
        if(label.getName().equals(blog.getLabel())){
            blog_add.setLabel_id(label.getId());
        }
    }

    int i = addMapper.addCheck(blog_add);
    if(i!=0){
        return "success";
    }else{
        return "failure";
    }
}

//    jpa查询方法
    @GetMapping("/select/{id}")
    public Optional<Blog> find(@PathVariable("id") Integer id) {
        return blogRepository.findById(id);
    }

//    jpa更新方法
    @PatchMapping("/update")
    public String updateBlog(@RequestBody Blog blog) {
        Blog result = blogRepository.save(blog);
        if(result != null) {
            return "success";
        } else {
            return "false";
        }
    }

//    jpa方法
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        blogRepository.deleteById(id);
    }

    // 删除接口
    @DeleteMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable("id") Integer id) {
        int i = blogMapper.deleteBlog(id);
        if(i!=0) {
            return "success";
        }else {
            return "failure";
        }
    }

//    审核通过
    @PostMapping("/checkAccess")
    public String addBlog(@RequestBody Blog_Check blog) {
//        把这条实体在check里删除掉
        int m = checkMapper.deleteCheck(blog.getId());
//        把实体在blog里添加上
        Blog_Add blog_add = new Blog_Add();
        List<Users> users = usersRepository.findAll();
        blog_add.setContent(blog.getContent());
        blog_add.setName(blog.getName());
        for(Users users1:users) {
            if(users1.getName().equals(blog.getAuthor())){
                blog_add.setAuthor_id(users1.getId());
            }
        }
        List<Label> labels = labelRepository.findAll();
        for(Label label:labels) {
            if(label.getName().equals(blog.getLabel())){
                blog_add.setLabel_id(label.getId());
            }
        }

        int i = addMapper.addBlog(blog_add);
        if(i!=0&&m!=0){
            return "success";
        }else{
            return "failure";
        }
    }

//    统计博客数量
    @GetMapping("/countBlog")
    public Integer countBlog(){
        return blogMapper.countBlog();
    }

//    博客分类
    @GetMapping("/classify")
    public List<Classify> classify() {
        return blogMapper.classifyBlog();
    }
}
