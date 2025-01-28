package com.example.spring_data_jpa.layers;

import com.example.spring_data_jpa.entity.PlayerValues;
import com.example.spring_data_jpa.entity.Team;
import com.example.spring_data_jpa.repository.player.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public void saveTeamsFromCSV() {
        // list to get teams for saving in team repo
        List<Team> teams = new ArrayList<>();
        // empty array to capture data from csv
        String[] data ={""};
        // change to csv in this project
        try  {
            BufferedReader br;
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("csvs/players.csv");
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                teams.add(new Team(data[0]));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        // save all info to repository
        teamRepository.saveAll(teams);
    }
}
