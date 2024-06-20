package com.trevis.startup.javaproject.impl;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.trevis.startup.javaproject.dto.payload.ServiceEntityPayload;
import com.trevis.startup.javaproject.model.ServiceEntity;
import com.trevis.startup.javaproject.services.ServiceService;

public class ServiceServiceMock implements ServiceService {

    private List<ServiceEntity> servicesList = new ArrayList<>();

    @Override
    public List<ServiceEntity> get(String query, Integer pageIndex, Integer pageSize) {

        if (pageIndex < 1) {
            pageIndex = 1;
        }

        return servicesList
            .stream()
            .filter(x -> x.getName().contains(query))
            .skip((pageIndex - 1) * pageSize)
            .limit(pageSize)
            .toList();
    }

    @Override
    public ServiceEntity create(ServiceEntityPayload payload, Long managerId, Long departmentId) {
        if (payload.name().isEmpty()) throw new InvalidParameterException("Name");
        if (payload.description().isEmpty()) throw new InvalidParameterException("Description");

        ServiceEntity service = new ServiceEntity(payload.name(), payload.description());

        servicesList.add(service);

        return service;
    }

    @Override
    public ServiceEntity get(Long id) {
        ServiceEntity entity = servicesList
            .stream()
            .filter(x -> x.getId().equals(id))
            .findFirst()
            .get();


        if (entity == null) {
            throw new NoSuchElementException();
        }

        return entity;
    }

    @Override
    public ServiceEntity update(ServiceEntityPayload payload, Long id) {
        ServiceEntity entity = get(id);

        if (payload.name() != null) {
            entity.setName(payload.name());
        }

        if (payload.description() != null) {
            entity.setDescription(payload.description());
        }

        return entity;
    }

    @Override
    public void delete(Long id) {
        ServiceEntity entity = get(id);

        servicesList.remove(entity);
    }
    
}
