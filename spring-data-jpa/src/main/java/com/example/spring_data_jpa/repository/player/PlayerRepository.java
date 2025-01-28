package com.example.spring_data_jpa.repository.player;

import com.example.spring_data_jpa.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
    public List<Player> findByPlayerFName(String playerFName);
    public List<Player> findByPlayerFNameContaining(String playerFName);
}


