package com.example.spring_data_jpa.layers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerValueController {
    PlayerValueService playerValueService;

    public PlayerValueController(PlayerValueService playerValueService) {
        this.playerValueService = playerValueService;
    }
    @GetMapping("player/values/upload")
    public String uploadPlayerValues(){
        try {
            playerValueService.savePlayersFromCSV();
            return "yay";

        }catch (Exception e){
            e.printStackTrace();
            return "not working";
        }

    }
}
