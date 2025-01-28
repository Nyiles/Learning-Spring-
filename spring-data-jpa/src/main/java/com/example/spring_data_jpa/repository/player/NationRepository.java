package com.example.spring_data_jpa.repository.player;

import com.example.spring_data_jpa.entity.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationRepository extends JpaRepository<Nationality,Integer> {
}
