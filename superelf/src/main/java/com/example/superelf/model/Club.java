package com.example.superelf.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String clubName;
    @ManyToOne
    @JoinColumn(name = "competitionId", referencedColumnName = "id", nullable = false)
    private Competition competition;
    @OneToMany(mappedBy = "club")
    private Set<Player> player;


    public Club() {
    }

    public Club(Integer id, Competition competition, String clubName) {
        this.id = id;
        this.competition = competition;
        this.clubName = clubName;
    }

    public Club(Competition competition, String clubName) {
        this.competition = competition;
        this.clubName = clubName;
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
                ", competition=" + competition +
                ", clubName='" + clubName + '\'' +
                '}';
    }
}
