package com.example.superelf.model;

import javax.persistence.*;

@Entity
@Table(name = "poules")
public class Poule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
