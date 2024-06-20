package com.trevis.startup.javaproject.impl;

import com.trevis.startup.javaproject.dto.payload.UserEntityPayload;
import com.trevis.startup.javaproject.model.UserEntity;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import com.trevis.startup.javaproject.services.UserService;

public class UserServiceMock implements UserService {
    
    private List<UserEntity> userList = new ArrayList<>();

    @Override
    public UserEntity create(UserEntityPayload payload, Long departmentId) {
        UserEntity entity = new UserEntity();
        entity.setPassword(payload.password()); 
        entity.setUserName(payload.userName()); 
        userList.add(entity);

        return entity;
    }

    @Override
    public UserEntity get(String userName) throws NoSuchElementException {
        UserEntity entity = userList.stream()
        .filter(x -> x.getUserName().equals(userName))
        .findFirst()
        .get();

        if (entity == null) {
            throw new NoSuchElementException();
        }

        return entity;
    }

    @Override
    public UserEntity get(Long id) {
        UserEntity entity = userList.stream()
            .filter(x -> x.getId().equals(id))
            .findFirst()
            .get();

        if (entity == null) {
            throw new NoSuchElementException();
        }

        return entity;
    }

    @Override
    public UserEntity update(UserEntityPayload payload, Long id) throws NoSuchElementException {
        UserEntity entity = get(id);

        if(payload.password() != null)
            entity.setPassword(payload.password());
        
        if(payload.userName() != null)
            entity.setUserName(payload.userName());

        return entity;
    }

    @Override
    public void delete(Long id) {
        UserEntity entity = get(id);

        userList.remove(entity);
    }
}
