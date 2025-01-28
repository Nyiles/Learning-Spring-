package com.example.spring_data_jpa.layers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NationController {
    private NationService nationService;

    public NationController(NationService nationService) {
        this.nationService = nationService;
    }

    @GetMapping("nations/upload")
    public String uploadNations(){
        try {
            nationService.savePlayersFromCSV();
            return "yay";
        }catch (Exception e){
            e.printStackTrace();
            return "not working";
        }
    }
}
