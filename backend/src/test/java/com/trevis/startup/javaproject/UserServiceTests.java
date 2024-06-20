package com.trevis.startup.javaproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.javaproject.dto.payload.UserEntityPayload;
import com.trevis.startup.javaproject.model.UserEntity;
import com.trevis.startup.javaproject.services.UserService;

@SpringBootTest
public class UserServiceTests {
	@Autowired
	UserService userService;

    @Test
    void testCreate() {
        String username = "andrey";
        String pw = "123321";
        UserEntity entity = userService.create(new UserEntityPayload(username, pw), 0L);

        assertNotNull(entity);

        assertEquals(entity.getUserName(), username);
        assertEquals(entity.getPassword(), pw);
    }

    @Test
    void testGetByUsername(){
        String username = "andrey";
        
        UserEntity entity = userService.create(new UserEntityPayload(username, ""), 0L);

        UserEntity found = userService.get(username);

        assertNotNull(found);
        assertEquals(entity, found);
    }

    @Test
    void testGetById(){
        String username = "andrey";
        
        UserEntity entity = userService.create(new UserEntityPayload(username, ""), 0L);

        UserEntity found = userService.get(entity.getId());

        assertNotNull(found);
        assertEquals(entity, found);
    }

    @Test
    void testUpdate() {
        String username = "andrey";
        
        UserEntity entity = userService.create(new UserEntityPayload(username, ""), 0L);

        userService.update(new UserEntityPayload("jaoo", null), entity.getId());

        assertNotNull(entity);
        assertEquals(entity.getUserName(), "jaoo");
    }

    @Test
    void testeDelete() {
        UserEntity entity = userService.create(new UserEntityPayload("test", "123"), 0L);
        UserEntity found = null;

        userService.delete(entity.getId());

        try {
            found = userService.get(entity.getId());
        } catch(Exception e ) {
        }
        
        assertEquals(found, null);
    }
    
}
