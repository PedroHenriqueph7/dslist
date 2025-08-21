package com.estudos_spring.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos_spring.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}
