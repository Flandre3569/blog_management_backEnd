package com.example.bms.entity;

import lombok.Data;

@Data
public class Blog_Add {
    private String name;
    private String content;
    private int author_id;
    private int label_id;

}
