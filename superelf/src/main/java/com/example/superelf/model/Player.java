package com.example.superelf.model;

public class Player {
    private Long id;
    private String name;
    private String clubname;
    private String position;

    public Player() {
    }

    public Player(Long id, String name, String clubname, String position) {
        this.id = id;
        this.name = name;
        this.clubname = clubname;
        this.position = position;
    }

    public Player(String name, String clubname, String position) {
        this.name = name;
        this.clubname = clubname;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clubName='" + clubname + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}


