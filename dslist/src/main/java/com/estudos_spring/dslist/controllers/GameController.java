package com.estudos_spring.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos_spring.dslist.dto.GameDTO;
import com.estudos_spring.dslist.dto.GameMinDTO;
import com.estudos_spring.dslist.services.GameService;

// O controlador que implementa API
@RestController
@RequestMapping(value = "/games")
public class GameController {
    
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO gameById(@PathVariable Long id){
        return gameService.gameFindByID(id);
    }

    @GetMapping
    public List<GameMinDTO> findAllGames() {
        return gameService.findAll();
    }

}
