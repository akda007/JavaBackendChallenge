package com.trevis.startup.javaproject.services;

import com.trevis.startup.javaproject.dto.payload.UserEntityPayload;
import com.trevis.startup.javaproject.model.UserEntity;

public interface UserService {
    UserEntity create(UserEntityPayload payload, Long departmentId);
    UserEntity get(String userName); 
    UserEntity get(Long id); 
    UserEntity update(UserEntityPayload payload, Long id);
    void delete(Long id);
}
