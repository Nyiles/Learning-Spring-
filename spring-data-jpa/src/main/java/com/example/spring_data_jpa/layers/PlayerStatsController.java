package com.example.spring_data_jpa.layers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerStatsController {
    private final PlayerStatsService playerStatsService;

    public PlayerStatsController(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    // upload nation, team and then player first (key restirictions)
    @GetMapping("/player/stats/upload")
    public String uploadPlayerStats(){
        try {
            playerStatsService.savePlayerStatsFromCSV();
            return "upload player stats successful";
        }catch (Exception e){
            e.printStackTrace();
            return "upload player stats not successful";
        }

    }
}
