package com.aristocampapi.service;
public interface TokenBlacklist { 
    void addToBlacklist(String token);
    boolean isBlacklisted(String token);
}

