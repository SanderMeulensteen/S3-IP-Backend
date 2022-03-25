package com.example.superelf.model;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer formationId;
    private Integer teamPoints;

    public Team() {
    }

    public Team(Integer id, Integer userId, Integer formationId, Integer teamPoints) {
        this.id = id;
        this.userId = userId;
        this.formationId = formationId;
        this.teamPoints = teamPoints;
    }

    public Team(Integer userId, Integer formationId, Integer teamPoints) {
        this.userId = userId;
        this.formationId = formationId;
        this.teamPoints = teamPoints;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFormationId() {
        return formationId;
    }

    public void setFormationId(Integer formationId) {
        this.formationId = formationId;
    }

    public Integer getTeamPoints() {
        return teamPoints;
    }

    public void setTeamPoints(Integer teamPoints) {
        this.teamPoints = teamPoints;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", userId=" + userId +
                ", formationId=" + formationId +
                ", teamPoints=" + teamPoints +
                '}';
    }
}
