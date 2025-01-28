package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;

@Entity
public class PlayerValues {
    @SequenceGenerator(
            name = "playerValues_sequence",
            sequenceName = "playerValues_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "playerStats_sequence"
    )
    @Id
    int playerValueId;
    String position;
    String preferredFoot;
    double value;
    double morale;
    double speed;
    double agility;
    double dribbling;
    double flair;
    double passing;
    double vision;
    double shooting;
    double composure;
    double defending;
    double diving;
    double reflexes;
    @OneToOne
    @JoinColumn(
            name = "player_id",
            referencedColumnName = "player_id"
    )
    private Player player;
//playerID,position,foot,value,morale,speed ,agility,dribbling,flair,passing,vision,shooting,composure,defending,diving,reflexes
    public PlayerValues(int playerId, String position, String preferredFoot, double value, double morale, double speed, double agility,double dribbling, double flair, double passing, double vision, double shooting, double composure, double defending, double diving, double reflexes) {
        this.player = new Player();
        player.setPlayerId(playerId);
        this.position = position;
        this.preferredFoot = preferredFoot;
        this.value = value;
        this.morale = morale;
        this.speed = speed;
        this.agility = agility;
        this.dribbling = dribbling;
        this.flair = flair;
        this.passing = passing;
        this.vision = vision;
        this.shooting = shooting;
        this.composure = composure;
        this.defending = defending;
        this.diving = diving;
        this.reflexes = reflexes;
    }
}
