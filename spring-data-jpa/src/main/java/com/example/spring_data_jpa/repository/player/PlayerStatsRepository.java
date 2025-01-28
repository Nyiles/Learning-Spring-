package com.example.spring_data_jpa.repository.player;

import com.example.spring_data_jpa.entity.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats,Integer> {

}
