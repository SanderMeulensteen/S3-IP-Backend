package com.example.superelf.model;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer teamPoints;
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="formationId", referencedColumnName = "id", nullable = false)
    private Formation formation;

    public Team() {
    }

    public Team(Integer id, User user, Formation formation, Integer teamPoints) {
        this.id = id;
        this.user = user;
        this.formation = formation;
        this.teamPoints = teamPoints;
    }

    public Team(User user, Formation formationId, Integer teamPoints) {
        this.user = user;
        this.formation = formationId;
        this.teamPoints = teamPoints;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
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
                ", user=" + user +
                ", formation=" + formation +
                ", teamPoints=" + teamPoints +
                '}';
    }
}
