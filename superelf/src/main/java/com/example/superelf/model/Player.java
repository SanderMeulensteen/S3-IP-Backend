package com.example.superelf.model;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name="positionId", referencedColumnName = "id", nullable = false)
    private Position position;
    @ManyToOne
    @JoinColumn(name="clubId", referencedColumnName = "id", nullable = false)
    private Club club;

    public Player() {
    }

    public Player(Integer id, String name, Club club, Position position) {
        this.id = id;
        this.name = name;
        this.club = club;
        this.position = position;
    }

    public Player(String name, Club club, Position position) {
        this.name = name;
        this.club = club;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", club='" + club + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}


