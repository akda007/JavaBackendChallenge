package com.trevis.startup.javaproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.javaproject.dto.payload.DepartmentEntityPayload;
import com.trevis.startup.javaproject.exception.AppResponseException;
import com.trevis.startup.javaproject.services.DepartmentService;

@SpringBootTest
public class DepartmentServiceTest {
    
    @Autowired
    DepartmentService departmentService;

    @Test
    void testDepartmentCreation() {

        String departmentName = "ETS";

        var department = departmentService.create(new DepartmentEntityPayload(departmentName));

        assertNotNull(department);
        assertEquals(departmentName, department.getDepartmentName());
    }

    @Test
    void testGetDepartmentById() {

        String departmentName = "ETS";
        
        var departmentCreation = departmentService.create(new DepartmentEntityPayload(departmentName));
        var departmentRead = departmentService.get(departmentCreation.getId());

        assertEquals(departmentCreation.getId(), departmentRead.getId());
    }

    @Test
    void testDepartmentUpdate() {

        String departmentName = "ETS";
        String updateDepartmentName = "New ETS";

        var department = departmentService.create(new DepartmentEntityPayload(departmentName));
        var updated = departmentService.update(new DepartmentEntityPayload(updateDepartmentName), department.getId());

        assertEquals(updateDepartmentName, updated.getDepartmentName());
    }

    @Test
    void testDepartmentDeletion() {

        String departmentName = "ETS";

        var department = departmentService.create(new DepartmentEntityPayload(departmentName));
        departmentService.delete(department.getId());

        assertThrows(AppResponseException.class, () -> { departmentService.get(department.getId()); });
    }
}
