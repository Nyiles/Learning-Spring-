package com.example.spring_data_jpa.layers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerStatsController {
    private final PlayerStatsService playerStatsService;

    public PlayerStatsController(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    @GetMapping("/player/stats/upload")
    public void uploadPlayerStats(){
        try {
            playerStatsService.savePlayersFromCSV();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
