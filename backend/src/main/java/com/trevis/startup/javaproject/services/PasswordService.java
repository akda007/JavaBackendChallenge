package com.trevis.startup.javaproject.services;

public interface PasswordService {
    String applyCryptography(String password);
    Boolean verifyCryptography(String password, String encryptedPassword);
    Integer verifyRules(String password);
}
