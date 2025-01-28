package com.example.spring_data_jpa.layers;

import com.example.spring_data_jpa.entity.PlayerStats;
import com.example.spring_data_jpa.entity.PlayerValues;
import com.example.spring_data_jpa.repository.player.PlayerValueRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerValueService {
    private final PlayerValueRepository playerValueRepository;

    public PlayerValueService(PlayerValueRepository playerValueRepository) {
        this.playerValueRepository = playerValueRepository;
    }

    public void savePlayerValuesFromCSV() {
        List<PlayerValues> playerValues = new ArrayList<>();
        String[] data ={""};

        try {
            BufferedReader br;
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("csvs/playersValues.csv");
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                playerValues.add(new PlayerValues(Integer.parseInt(data[0]),data[1],data[2],Double.parseDouble(data[3]),Double.parseDouble(data[4]),Double.parseDouble(data[5]),Double.parseDouble(data[6]),Double.parseDouble(data[7]),Double.parseDouble(data[8]),Double.parseDouble(data[9]),Double.parseDouble(data[10]),Double.parseDouble(data[11]),Double.parseDouble(data[12]),Double.parseDouble(data[13]),Double.parseDouble(data[14]),Double.parseDouble(data[15])));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        playerValueRepository.saveAll(playerValues);
    }
}

