package com.example.superelf.model;

import javax.persistence.*;

@Entity
@Table(name = "poules")
public class Poule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer competitionId;
    private String pouleName;

    public Poule() {
    }

    public Poule(Integer id, Integer competitionId, String pouleName) {
        this.id = id;
        this.competitionId = competitionId;
        this.pouleName = pouleName;
    }

    public Poule(Integer competitionId, String pouleName) {
        this.competitionId = competitionId;
        this.pouleName = pouleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public String getPouleName() {
        return pouleName;
    }

    public void setPouleName(String pouleName) {
        this.pouleName = pouleName;
    }

    @Override
    public String toString() {
        return "Poule{" +
                "id=" + id +
                ", competitionId=" + competitionId +
                ", pouleName='" + pouleName + '\'' +
                '}';
    }
}
