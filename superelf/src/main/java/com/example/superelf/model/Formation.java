package com.example.superelf.model;

import javax.persistence.*;

@Entity
@Table(name = "formations")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String formationName;
    private Integer defenders;
    private Integer midfielders;
    private Integer forwards;

    public Formation() {
    }

    public Formation(Integer id, String formationName, Integer defenders, Integer midfielders, Integer forwards) {
        this.id = id;
        this.formationName = formationName;
        this.defenders = defenders;
        this.midfielders = midfielders;
        this.forwards = forwards;
    }

    public Formation(String formationName, Integer defenders, Integer midfielders, Integer forwards) {
        this.formationName = formationName;
        this.defenders = defenders;
        this.midfielders = midfielders;
        this.forwards = forwards;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFormationName() {
        return formationName;
    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    public Integer getDefenders() {
        return defenders;
    }

    public void setDefenders(Integer defenders) {
        this.defenders = defenders;
    }

    public Integer getMidfielders() {
        return midfielders;
    }

    public void setMidfielders(Integer midfielders) {
        this.midfielders = midfielders;
    }

    public Integer getForwards() {
        return forwards;
    }

    public void setForwards(Integer forwards) {
        this.forwards = forwards;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "id=" + id +
                ", formationName='" + formationName + '\'' +
                ", defenders=" + defenders +
                ", midfielders=" + midfielders +
                ", forwards=" + forwards +
                '}';
    }
}
