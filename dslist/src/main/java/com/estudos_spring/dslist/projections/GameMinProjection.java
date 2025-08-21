package com.estudos_spring.dslist.projections;

public interface GameMinProjection {
    
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgURL();
    String getShortDescription();
    Integer getPosition();
}
