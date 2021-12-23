package com.example.bms.mapper;

import com.example.bms.entity.Blog;
import com.example.bms.entity.Blog_Check;
import com.example.bms.entity.Check;
import com.example.bms.entity.Classify;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {
    @Select("SELECT td.id,td.name,td.createAt,td.updateAt,td.content,te.name author,tf.name label FROM `blog` td LEFT JOIN `users` te ON td.author_id = te.id LEFT JOIN `label` tf ON td.label_id = tf.id")
    List<Blog_Check> findAll();

    @Delete("delete from `blog` where id = #{id}")
    Integer deleteBlog(@Param("id") int id);

    @Select("Select count(*) from `blog`")
    Integer countBlog();

//    @Select("select * from `blog`")
//    List<Blog_Check> find();
    @Select("select count(*) value,la.name name from `blog` bl LEFT JOIN `label` la ON bl.label_id = la.id group by label_id")
    List<Classify> classifyBlog();
}
