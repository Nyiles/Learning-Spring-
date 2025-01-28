package com.example.spring_data_jpa.layers;

import com.example.spring_data_jpa.entity.Player;
import com.example.spring_data_jpa.entity.PlayerStats;
import com.example.spring_data_jpa.repository.player.PlayerStatsRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerStatsService {
    private final PlayerStatsRepository playerStatsRepository;
    public PlayerStatsService(PlayerStatsRepository playerStatsRepository){
        this.playerStatsRepository = playerStatsRepository;
    }
    public void savePlayersFromCSV() {
        List<PlayerStats> playersStats = new ArrayList<>();
        String[] data ={""};

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/nicny/OneDrive/Documents/Homework/PlayerStats.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                playersStats.add(new PlayerStats(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6])));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        playerStatsRepository.saveAll(playersStats);
    }
}
