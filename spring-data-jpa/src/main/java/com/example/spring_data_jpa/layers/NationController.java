package com.example.spring_data_jpa.layers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NationController {
    private NationService nationService;

    public NationController(NationService nationService) {
        this.nationService = nationService;
    }

    // upload this or team first
    @GetMapping("nations/upload")
    public String uploadNations(){
        try {
            nationService.saveNationsFromCSV();
            return "nations upload is working ";
        }catch (Exception e){
            e.printStackTrace();
            return "nations upload is not working";
        }
    }
}
