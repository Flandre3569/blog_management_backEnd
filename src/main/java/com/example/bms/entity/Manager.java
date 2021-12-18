package com.example.bms.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Manager {
    @Id
    private int id;
    private String name;
    private String password;
}
