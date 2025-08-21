package com.estudos_spring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudos_spring.dslist.dto.GameListDTO;
import com.estudos_spring.dslist.entities.GameList;
import com.estudos_spring.dslist.repository.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> lists = gameListRepository.findAll();
        return lists.stream().map(x -> new GameListDTO(x)).toList();
    }
}
