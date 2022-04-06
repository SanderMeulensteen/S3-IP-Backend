package com.example.superelf.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer competitionId;
    private String clubName;
    @OneToMany(mappedBy = "club")
    private Set<Player> player;


    public Club() {
    }

    public Club(Integer id, Integer competitionId, String clubName) {
        this.id = id;
        this.competitionId = competitionId;
        this.clubName = clubName;
    }

    public Club(Integer competitionId, String clubName) {
        this.competitionId = competitionId;
        this.clubName = clubName;
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

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", competitionId=" + competitionId +
                ", clubName='" + clubName + '\'' +
                '}';
    }
}
