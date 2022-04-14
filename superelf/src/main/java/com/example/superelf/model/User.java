package com.example.superelf.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(unique = true, nullable = false)
    public String emailAddress;
    public String userName;
    public String firstName;
    public String lastName;
    @Column(nullable = false)
    public String password;
    public Boolean isAdmin;
    public Boolean isModerator;
    @OneToMany(mappedBy = "user")
    private Set<Team> team;

    public User() {
    }

    public User(Integer id, String emailAddress, String userName, String firstName, String lastName, String password, Boolean isAdmin, Boolean isModerator) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isModerator = isModerator;
    }

    public User(String emailAddress, String userName, String firstName, String lastName, String password, Boolean isAdmin, Boolean isModerator) {
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isModerator = isModerator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getModerator() {
        return isModerator;
    }

    public void setModerator(Boolean moderator) {
        isModerator = moderator;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailAddress='" + emailAddress + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", isModerator=" + isModerator +
                '}';
    }
}