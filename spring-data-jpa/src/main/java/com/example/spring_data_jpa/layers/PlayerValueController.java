package com.example.spring_data_jpa.layers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerValueController {
    PlayerValueService playerValueService;

    public PlayerValueController(PlayerValueService playerValueService) {
        this.playerValueService = playerValueService;
    }
    // upload team and nation and then player first (key restrictions)
    @GetMapping("player/values/upload")
    public String uploadPlayerValues(){
        try {
            playerValueService.savePlayerValuesFromCSV();
            return "player values upload successful";

        }catch (Exception e){
            e.printStackTrace();
            return "player values upload failed";
        }

    }
}
