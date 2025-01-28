package com.example.spring_data_jpa.layers;

import com.example.spring_data_jpa.entity.Player;
import com.example.spring_data_jpa.repository.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerService {
    @Autowired

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public void savePlayersFromCSV() {
        List<Player> players = new ArrayList<>();
        String[] data ={""};

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/nicny/OneDrive/Documents/Homework/players.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                players.add(new Player(data[0], data[1],Integer.parseInt(data[2]),data[3],Integer.parseInt(data[4])));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        playerRepository.saveAll(players);
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
    public void deleteAll(){
         playerRepository.deleteAll();
    }

//    public void addTestPlayer() {
//        Player player = new Player("John", "Doe", 25, "Forward", "USA", 10, 5, "TeamX");
//        playerRepository.save(player);
//        System.out.println("Test player added!");
//    }

}

