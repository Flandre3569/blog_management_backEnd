package com.example.bms.mapper;

import com.example.bms.entity.Check;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckMapper {
    @Select("SELECT td.id,td.name,td.createAt,td.content,te.name author,tf.name label FROM `check` td LEFT JOIN `users` te ON td.author_id = te.id LEFT JOIN `label` tf ON td.label_id = tf.id;")
    List<Check> findAll();
}
