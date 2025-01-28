package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tbl_team")
public class Team {
    @Id
    @SequenceGenerator(
            name = "team_sequence",
            sequenceName = "team_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "team_sequence"
    )
    @Column(name = "team_id")
    private int teamId;
    @Column(name = "team_name")
    private String teamName;
    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team() {
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}


