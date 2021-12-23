package com.example.bms.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelMapper {
    @Select("select count(*) from `label`")
    Integer countLabel();
}
