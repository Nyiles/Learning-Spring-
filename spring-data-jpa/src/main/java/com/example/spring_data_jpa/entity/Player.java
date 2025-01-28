package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity // marks as a table
@Data // lombok which allows you to generate common methods
@Builder
@Table(name = "tbl_player") // lets you name the table
public class Player {
    @Id
    @SequenceGenerator(name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"

    )
    @Column(name = "player_id")
    int playerId;
    @Column(name = "player_fName", nullable = false)
    private String playerFName;
    @Column(name = "player_lName", nullable = false)
    private String playerLName;
    @ManyToOne
    @JoinColumn(
            name = "nation_id",
            referencedColumnName = "nation_id"
    )
    private Nationality nationality;
    @Column(name = "player_dob", nullable = false)
    private String playerDob;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
            (
               name = "team_id",
               referencedColumnName = "team_id"
                    )
    private Team team;

    public Player( String playerFName, String playerLName, int nationalityId, String playerDob, int teamId) {
        this.playerFName = playerFName;
        this.playerLName = playerLName;
        this.nationality = new Nationality();
        this.nationality.setNationId(nationalityId);
        this.playerDob = playerDob;
        this.team = new Team();
        this.team.setTeamId(teamId);
    }

    public Player() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerFName() {
        return playerFName;
    }

    public void setPlayerFName(String playerFName) {
        this.playerFName = playerFName;
    }

    public String getPlayerLName() {
        return playerLName;
    }

    public void setPlayerLName(String playerLName) {
        this.playerLName = playerLName;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String getPlayerDob() {
        return playerDob;
    }

    public void setPlayerDob(String playerDob) {
        this.playerDob = playerDob;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
