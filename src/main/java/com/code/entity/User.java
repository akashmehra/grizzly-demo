package com.code.entity;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class User {

    private String name;
    private String address;
    
    @SuppressWarnings("unused")
    private User() {
        
    }
    
    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public static User buildObjectFromJson(String json) throws IOException {
        return new ObjectMapper().readValue(json, User.class);
    }
    
    public String buildJson() throws IOException {
        return new ObjectMapper().writeValueAsString(this);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAddress() {
        return this.address;
    }
    @SuppressWarnings("unused")
    private void setName(String name) {
        this.name = name;
    }
    
    @SuppressWarnings("unused")
    private void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [name=");
        builder.append(name);
        builder.append(", address=");
        builder.append(address);
        builder.append("]");
        return builder.toString();
    }
    
    
    
}
