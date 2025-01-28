package com.example.spring_data_jpa.repository.player;

import com.example.spring_data_jpa.entity.PlayerValues;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerValueRepository extends JpaRepository<PlayerValues, Integer> {
}
