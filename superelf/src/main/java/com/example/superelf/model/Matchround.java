package com.example.superelf.model;

import javax.persistence.*;

@Entity
@Table(name = "matchrounds")
public class Matchround {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
