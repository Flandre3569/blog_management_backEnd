package com.example.bms.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;

    @JoinColumn(name="author_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Users author;
    @JoinColumn(name="label_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Label label;
}
