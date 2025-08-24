package com.estudos_spring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudos_spring.dslist.dto.GameListDTO;
import com.estudos_spring.dslist.entities.GameList;
import com.estudos_spring.dslist.projections.GameMinProjection;
import com.estudos_spring.dslist.repository.GameListRepository;
import com.estudos_spring.dslist.repository.GameRepository;

@Service
public class GameListService {
    
    @Autowired
    GameListRepository gameListRepository;

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> lists = gameListRepository.findAll();
        return lists.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> gamesByList = gameRepository.searchByList(listId);

        GameMinProjection gameMinProjection = gamesByList.get(sourceIndex);
        gamesByList.remove(gameMinProjection);
        gamesByList.add(destinationIndex, gameMinProjection);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for(int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, gamesByList.get(i).getId(), i);
        }
        
    }
}
