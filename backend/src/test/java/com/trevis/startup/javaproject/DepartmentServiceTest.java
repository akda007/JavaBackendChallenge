package com.trevis.startup.javaproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.javaproject.dto.payload.DepartmentEntityPayload;
import com.trevis.startup.javaproject.services.DepartmentService;

@SpringBootTest
public class DepartmentServiceTest {
    
    @Autowired
    DepartmentService departmentService;

    @Test
    void testDepartmentCreation() {

        var department = departmentService.create(new DepartmentEntityPayload("ETS"));

        assertEquals(department.getDepartmentName(), "ETS");
        assertNotNull(department.getId());
    }

    @Test
    void testGetDepartmentById() {
        
        var departmentCreation = departmentService.create(new DepartmentEntityPayload("ETS"));
        var departmentRead = departmentService.get(departmentCreation.getId());

        assertEquals(departmentCreation.getDepartmentName(), departmentRead.getDepartmentName());
    }

    @Test
    void testDepartmentUpdate() {

        var department = departmentService.create(new DepartmentEntityPayload("ETS"));
        var updated = departmentService.update(new DepartmentEntityPayload("New ETS"), department.getId());

        assertEquals(updated.getDepartmentName(), "New ETS");
    }

    @Test
    void testDepartmentDeletion() {

        var department = departmentService.create(new DepartmentEntityPayload("ETS"));
        departmentService.delete(department.getId());

        assertNull(departmentService.get(department.getId()));
    }
}