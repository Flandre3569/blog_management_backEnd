package com.example.bms.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

}
