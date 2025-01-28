package com.example.spring_data_jpa.layers;

import com.example.spring_data_jpa.entity.Nationality;
import com.example.spring_data_jpa.entity.PlayerValues;
import com.example.spring_data_jpa.repository.player.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class NationService {
    @Autowired
    NationRepository nationRepository;

    public void savePlayersFromCSV() {
        List<Nationality> nationalities = new ArrayList<>();
        String[] data ={""};

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/nicny/OneDrive/Documents/Homework/nation.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                nationalities.add(new Nationality(data[0]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        nationRepository.saveAll(nationalities);
    }
}
