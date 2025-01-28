package com.example.spring_data_jpa.repository.player;

import com.example.spring_data_jpa.entity.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest // actually impacts our database
//@DataJpaTest used for unit testing
class playerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;
   @Test
    public void saveStudent(){
        Player player = new Player();
                player.setPlayerFName("John");
                player.setPlayerLName("Doe");

                player.setPlayerDob("cs");

        playerRepository.save(player);

    }
    }
//    @Test
//    public void printAllPlayers(){
//        List<Player> playerList= playerRepository.findAll();
//        System.out.println(playerList);
//    }
//    @Test
//    public void printPlayerByFirstName(){
//        List<Player> playerList = playerRepository.findByPlayerFName("john");
//        System.out.println("players = " +playerList);
//    }
//    @Test
//    public void printPlayerByFirstNameContaining(){
//        List<Player> playerList = playerRepository.findByPlayerFNameContaining("j");
//        System.out.println("players = " +playerList);
//    }
