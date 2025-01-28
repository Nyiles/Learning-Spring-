package com.example.spring_data_jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_nation")
public class Nationality {
    @Id
    @SequenceGenerator(
            name = "nationality_sequence",
            sequenceName = "nationality_sequence",
            allocationSize = 1
    )
    @Column(name = "nation_id")
    private int nationId;
    @Column(name = "nation_name")
    private String nationName;

    public Nationality(String nationName) {
        this.nationName = nationName;
    }

    public int getNationId() {
        return nationId;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public Nationality() {
    }
}
