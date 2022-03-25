package com.example.superelf.model;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer clubId;
    private String name;
    private Integer position;

    public Player() {
    }

    public Player(Integer id, String name, Integer clubId, Integer position) {
        this.id = id;
        this.name = name;
        this.clubId = clubId;
        this.position = position;
    }

    public Player(String name, Integer clubId, Integer position) {
        this.name = name;
        this.clubId = clubId;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clubId='" + clubId + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}


