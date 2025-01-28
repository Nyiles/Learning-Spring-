package com.example.spring_data_jpa.layers;

import com.example.spring_data_jpa.entity.Team;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("teams/upload")
    public String uploadTeam(){
        try {
            teamService.savePlayersFromCSV();
            return "yur";
        }catch (Exception e){
            e.printStackTrace();
            return "not working";
        }

    }
}
