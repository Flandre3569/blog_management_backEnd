package com.example.bms.mapper;

import com.example.bms.entity.Blog_Add;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface AddMapper {
    @Insert("insert into blog(name,content,author_id,label_id) values(#{name},#{content},#{author_id},#{label_id})")
    Integer addBlog(Blog_Add blog_add);
}
