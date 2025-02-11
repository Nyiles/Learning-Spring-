package com.example.spring_data_jpa.layers;

import com.example.spring_data_jpa.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//"C:\Users\nicny\AppData\Local\Temp\MicrosoftEdgeDownloads\af4d24cc-8991-4c5a-87ca-1ddd7451e78e\kali-linux-2024.4-installer-amd64.iso"
@RestController
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }
//    @GetMapping
//    public void uploadPlayers(){
//        playerService.savePlayersFromCSV();
//    }

    // upload nations and teams first (key restrictions)
@GetMapping("/upload/player")
    public String uploadPlayer() {
        try {
            playerService.savePlayersFromCSV();
            return "players have been succesfully uploaded";
        }
        catch (Exception e){
            e.printStackTrace();
            return "failed to upload players";
        }

    }
    // this cross-origin was to test connection to my html using this REST API and Javascript
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/all")
    public List<Player> getPlayers(){
        return playerService.getAllPlayers();
    }

}


