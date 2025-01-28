package com.example.spring_data_jpa.layers;

import com.example.spring_data_jpa.entity.Player;
import com.example.spring_data_jpa.repository.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        // empty list which will be saved to player repo
        List<Player> players = new ArrayList<>();
        // capture the csv data by row
        String[] data ={""};
        // same as nation CSV
        try  {
            BufferedReader br;
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("csvs/players.csv");
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            // first line is title again
            br.readLine();
            while ((line = br.readLine()) != null) {
                // split the data based on comma in CSV
                data = line.split(",");
                players.add(new Player(data[0], data[1],Integer.parseInt(data[2]),data[3],Integer.parseInt(data[4])));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        // save to playerRepository
        playerRepository.saveAll(players);
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
    // earlier testing
    public void deleteAll(){
         playerRepository.deleteAll();
    }

}

