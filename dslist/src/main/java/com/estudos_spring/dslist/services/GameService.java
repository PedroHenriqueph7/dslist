package com.estudos_spring.dslist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos_spring.dslist.dto.GameMinDTO;
import com.estudos_spring.dslist.entities.Game;
import com.estudos_spring.dslist.repository.GameRepository;

import jakarta.transaction.Transactional;
@Service   // Ou @Component
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public GameMinDTO gameFindByID(Long id){
        Game entity = gameRepository.findById(id).get();
        GameMinDTO gameMinDTO = new GameMinDTO(entity);
        return gameMinDTO;
    }

    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
