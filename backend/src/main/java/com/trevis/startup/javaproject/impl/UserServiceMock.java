package com.trevis.startup.javaproject.impl;

import com.trevis.startup.javaproject.dto.payload.UserEntityPayload;
import com.trevis.startup.javaproject.exception.AppResponseException;
import com.trevis.startup.javaproject.model.UserEntity;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import com.trevis.startup.javaproject.services.UserService;

public class UserServiceMock implements UserService {
    
    private List<UserEntity> userList = new ArrayList<>();
    private Long currentId = 1l;

	private Long getCurrentId() {
		return currentId++;
	}

    @Override
    public UserEntity create(UserEntityPayload payload, Long departmentId) {
        UserEntity entity = new UserEntity();
        entity.setId(getCurrentId());
        entity.setPassword(payload.password()); 
        entity.setUserName(payload.userName()); 
        userList.add(entity);

        return entity;
    }

    @Override
    public UserEntity get(String userName) {
        try {
            return userList
                .stream()
                .filter(x -> x.getUserName().equals(userName))
                .findFirst()
                .get();
        } catch (Exception e) {
            throw new AppResponseException("User not found", 404);
        }
    }

    @Override
    public UserEntity get(Long id) {
        try {
            return userList
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .get();
        } catch (Exception e) {
            throw new AppResponseException("User not found", 404);
        }
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
