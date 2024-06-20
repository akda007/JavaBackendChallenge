package com.trevis.startup.javaproject.impl;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import com.trevis.startup.javaproject.dto.payload.DepartmentEntityPayload;
import com.trevis.startup.javaproject.exception.AppResponseException;
import com.trevis.startup.javaproject.model.DepartmentEntity;
import com.trevis.startup.javaproject.services.DepartmentService;

public class DepartmentServiceMock implements DepartmentService {

    private List<DepartmentEntity> departmentEntities = new ArrayList<DepartmentEntity>();
	private Long currentId = 1l;

	private Long getCurrentId() {
		return currentId++;
	}

    @Override
    public DepartmentEntity create(DepartmentEntityPayload payload) {
        if (payload.name() == null) {
            throw new InvalidParameterException("Name");
        }

        DepartmentEntity entity = new DepartmentEntity();

		entity.setId(getCurrentId());
		entity.setDepartmentName(payload.name());

        departmentEntities.add(entity);

        return entity;
    }

	@Override
	public DepartmentEntity get(Long id) {
		try {
			return departmentEntities
				.stream()
				.filter(x -> x.getId().equals(id))
				.findFirst()
				.get();
		} catch (Exception e) {
			throw new AppResponseException("Department not found", 404);
		}
	}

    @Override
    public DepartmentEntity update(DepartmentEntityPayload payload, Long id) {
		DepartmentEntity entity = get(id);

		
		if (payload.name() != null) {
			entity.setDepartmentName(payload.name());
		}

		return entity;
    }

    @Override
    public void delete(Long id) {
		DepartmentEntity entity = get(id);

		departmentEntities.remove(entity);
    }
    
}
