package com.example.spring_data_jpa.layers;

import com.example.spring_data_jpa.entity.Nationality;
import com.example.spring_data_jpa.entity.PlayerValues;
import com.example.spring_data_jpa.repository.player.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class NationService {
    @Autowired
    NationRepository nationRepository;

    public void saveNationsFromCSV() {
        // future data that will be uploaded to repository
        List<Nationality> nationalities = new ArrayList<>();
        // will be used to capture each row's data
        String[] data ={""};
        // read the intended file - probably need to change it to the upload CV and probably pass this as an argument
        try  {
            BufferedReader br;
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("csvs/nation.csv");
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            // read the title line, since we are not using it for actual data
            br.readLine();
            while ((line = br.readLine()) != null) {
                // splits the data into seperate index's in the array based on the comma in the CSV
                data = line.split(",");
                nationalities.add(new Nationality(data[0]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // save it to the nation repository
        nationRepository.saveAll(nationalities);
    }
}
