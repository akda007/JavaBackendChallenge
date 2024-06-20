package com.trevis.startup.javaproject.services;

import com.trevis.startup.javaproject.dto.payload.DepartmentEntityPayload;
import com.trevis.startup.javaproject.model.DepartmentEntity;

public interface DepartmentService {
    DepartmentEntity create(DepartmentEntityPayload payload);
    DepartmentEntity get(Long id);
    DepartmentEntity update(DepartmentEntityPayload payload, Long id);
    void delete(Long id);
}
