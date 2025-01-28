package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_playerStats")
public class PlayerStats {
    @Id
    @SequenceGenerator(
            name = "playerStats_sequence",
            sequenceName = "playerStats_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "playerStats_sequence"
    )

    private int statId;

    @Column(name = "stat_appearances",nullable = false)
    private int statAppearances;
    @Column(name = "stat_goal",nullable = false)
    private int statGoals;
    @Column(name = "stat_assists",nullable = false)
    private int statAssists;
    @Column(name = "stat_yellows",nullable = false)
    private int statYellows;
    @Column(name = "stat_reds",nullable = false)
    private int statReds;

    @Column(name = "stat_saves",nullable = false)
    private int saves;

    @OneToOne
    @JoinColumn(
            name = "player_id",
            referencedColumnName = "player_id"
    )
    private Player player;
    public PlayerStats(int playerId,int statAppearances, int statGoals, int statAssists, int statYellows, int statReds, int saves) {
        this.player = new Player();
        this.player.setPlayerId(playerId);
        this.statAppearances = statAppearances;
        this.statGoals = statGoals;
        this.statAssists = statAssists;
        this.statYellows = statYellows;
        this.statReds = statReds;
        this.saves = saves;
    }

    public PlayerStats() {
    }

    public int getStatAppearances() {
        return statAppearances;
    }

    public void setStatAppearances(int statAppearances) {
        this.statAppearances = statAppearances;
    }

    public int getStatGoals() {
        return statGoals;
    }

    public void setStatGoals(int statGoals) {
        this.statGoals = statGoals;
    }

    public int getStatAssists() {
        return statAssists;
    }

    public void setStatAssists(int statAssists) {
        this.statAssists = statAssists;
    }

    public int getStatId() {
        return statId;
    }

    public void setStatId(int statId) {
        this.statId = statId;
    }

    public int getStatYellows() {
        return statYellows;
    }

    public void setStatYellows(int statYellows) {
        this.statYellows = statYellows;
    }

    public int getStatReds() {
        return statReds;
    }

    public void setStatReds(int statReds) {
        this.statReds = statReds;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }
}
