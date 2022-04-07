package com.example.superelf.model;

import javax.persistence.*;

@Entity
@Table(name = "matchrounds")
public class Matchround {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer points;
    private Integer weekNumber;
    private Integer season;
    @ManyToOne
    @JoinColumn(name="playerId", referencedColumnName = "id", nullable = false)
    private Player player;

    public Matchround() {
    }

    public Matchround(Integer id, Player player, Integer points, Integer weekNumber, Integer season) {
        this.id = id;
        this.player = player;
        this.points = points;
        this.weekNumber = weekNumber;
        this.season = season;
    }

    public Matchround(Player player, Integer points, Integer weekNumber, Integer season) {
        this.player = player;
        this.points = points;
        this.weekNumber = weekNumber;
        this.season = season;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Matchround{" +
                "id=" + id +
                ", player=" + player +
                ", points=" + points +
                ", weekNumber=" + weekNumber +
                ", season=" + season +
                '}';
    }
}
