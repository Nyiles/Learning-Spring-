package com.example.spring_data_jpa.layers;

import com.example.spring_data_jpa.entity.PlayerValues;
import com.example.spring_data_jpa.entity.Team;
import com.example.spring_data_jpa.repository.player.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public void savePlayersFromCSV() {
        List<Team> teams = new ArrayList<>();
        String[] data ={""};

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/nicny/OneDrive/Documents/Homework/Team.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                teams.add(new Team(data[0]));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        teamRepository.saveAll(teams);
    }
}
