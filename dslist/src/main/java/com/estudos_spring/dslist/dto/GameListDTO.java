package com.estudos_spring.dslist.dto;

import com.estudos_spring.dslist.entities.GameList;

public class GameListDTO {
    
    private Long id;
    private String name;

    public GameListDTO(){
    }

    public GameListDTO(GameList entityList) {
        this.id = entityList.getId();
        this.name = entityList.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    } 
}
