package com.example.bms.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface EmailMapper {

    @Insert("insert into email values(#{address},#{subject},#{body})")
    int addEmail(Map<String,String> param);
}
