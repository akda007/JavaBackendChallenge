package com.trevis.startup.javaproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.javaproject.services.PasswordService;

@SpringBootTest
public class PasswordServiceTest {
    
    @Autowired
    PasswordService passwordService;

    @Test
    void testCryptography() {

        String testPassword = "123456";
        String wrongPassword = "12345";

        String cryptographed = passwordService.applyCryptography(testPassword);

        assertTrue(passwordService.verifyCryptography(testPassword, cryptographed));

        assertFalse(passwordService.verifyCryptography(wrongPassword, cryptographed));
    }

    @Test
    void testVeirifyRules() {

        assertEquals(passwordService.verifyRules("@&%$"), 1);
        assertEquals(passwordService.verifyRules("1234567"), 2);
        assertEquals(passwordService.verifyRules("12345678"), 3);
        assertEquals(passwordService.verifyRules("1234567A"), 4);
        assertEquals(passwordService.verifyRules("12345678Am"), 5);
    }
}
