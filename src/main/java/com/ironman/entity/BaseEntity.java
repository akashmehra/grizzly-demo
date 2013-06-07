package com.ironman.entity;

public interface BaseEntity<E> {
    
    public void save();
    public E read();

}
