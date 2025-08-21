package com.estudos_spring.dslist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudos_spring.dslist.dto.GameDTO;
import com.estudos_spring.dslist.dto.GameMinDTO;
import com.estudos_spring.dslist.entities.Game;
import com.estudos_spring.dslist.repository.GameRepository;


@Service   // Ou @Component
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Somente leitura, aumentando a velocidade para a consulta
    public GameDTO gameFindByID(Long id){
        // o FindById do repository retorna naturalmente um tipo Optional, necessitando do get para retorna um objeto e trazer os dados
        Game entity = gameRepository.findById(id).get();
        GameDTO gameDTO = new GameDTO(entity);
        return gameDTO;
    } 

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
