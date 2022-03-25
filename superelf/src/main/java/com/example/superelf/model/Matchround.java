package com.example.superelf.model;

import javax.persistence.*;

@Entity
@Table(name = "matchrounds")
public class Matchround {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer playerId;
    private Integer points;
    private Integer weekNumber;
    private Integer season;

    public Matchround() {
    }

    public Matchround(Integer id, Integer playerId, Integer points, Integer weekNumber, Integer season) {
        this.id = id;
        this.playerId = playerId;
        this.points = points;
        this.weekNumber = weekNumber;
        this.season = season;
    }

    public Matchround(Integer playerId, Integer points, Integer weekNumber, Integer season) {
        this.playerId = playerId;
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

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
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
                ", playerId=" + playerId +
                ", points=" + points +
                ", weekNumber=" + weekNumber +
                ", season=" + season +
                '}';
    }
}
