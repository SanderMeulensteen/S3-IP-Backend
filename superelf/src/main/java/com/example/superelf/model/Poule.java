package com.example.superelf.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "poules")
public class Poule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pouleName;

    @ManyToOne
    @JoinColumn(name = "competitionId", referencedColumnName = "id", nullable = false)
    private Competition competition;

    @ManyToMany(mappedBy="pouleTeam")
    Set<Team> teamPoule;

    public Poule() {
    }

    public Poule(Integer id, Competition competition, String pouleName) {
        this.id = id;
        this.competition = competition;
        this.pouleName = pouleName;
    }

    public Poule(Competition competitionId, String pouleName) {
        this.competition = competitionId;
        this.pouleName = pouleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
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
                ", competition=" + competition +
                ", pouleName='" + pouleName + '\'' +
                '}';
    }
}
