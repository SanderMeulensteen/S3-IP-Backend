package com.example.superelf.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "competitions")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String competitionName;
    @OneToMany(mappedBy = "competition")
    public Set<Club> club;
    @OneToMany(mappedBy = "competition")
    public Set<Poule> poule;

    public Competition() {
    }

    public Competition(Integer id, String competitionName) {
        this.id = id;
        this.competitionName = competitionName;
    }

    public Competition(String competitionName) {
        this.competitionName = competitionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", competitionName='" + competitionName + '\'' +
                '}';
    }
}
