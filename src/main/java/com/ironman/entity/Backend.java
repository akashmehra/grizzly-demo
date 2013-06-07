package com.ironman.entity;

import java.util.List;

import com.ironman.exceptions.BackendConnectionException;

public interface Backend<T> {
    
    public void connect() throws BackendConnectionException; 
    public void save(T entity);
    public void batchSave(List<T> entities);
    
    
}
