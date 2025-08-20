package com.estudos_spring.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudos_spring.dslist.entities.Game;
                                                 // classe , tipo do id
public interface GameRepository extends JpaRepository<Game, Long>{

} 