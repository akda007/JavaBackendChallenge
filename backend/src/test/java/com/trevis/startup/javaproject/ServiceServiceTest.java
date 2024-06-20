package com.trevis.startup.javaproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.javaproject.dto.payload.ServiceEntityPayload;
import com.trevis.startup.javaproject.services.ServiceService;

@SpringBootTest
public class ServiceServiceTest {
    
    @Autowired
    ServiceService serviceService;

    @Test
    void testServiceCreation() {
        
        var service = serviceService.create(
            new ServiceEntityPayload("Service", "A generic service"),
            1l,
            1l
        );
        
        assertNotNull(service);
        assertEquals(service.getName(), "Service");
        assertEquals(service.getDescription(), "A generic service");
    }

    @Test
    void testServiceRead() {
        
        var service = serviceService.create(
            new ServiceEntityPayload("Service", "A generic service"),
            1l,
            1l
        );

        var found = serviceService.get(service.getId());

        assertNotNull(found);
        assertEquals(found.getName(), service.getName());
    }

    @Test
    void testServiceUpdate() {

        var service = serviceService.create(
            new ServiceEntityPayload("Service", "A generic service"),
            1l,
            1l
        );

        var updated = serviceService.update(
            new ServiceEntityPayload("Another Service", "A different service"),
            service.getId()
        );

        assertNotNull(updated);
        assertEquals(updated.getName(), "Another Service");
        assertEquals(updated.getDescription(), "A different service");
    }

    @Test
    void testServiceDeletion() {

        var service = serviceService.create(
            new ServiceEntityPayload("Service", "A generic service"),
            1l,
            1l
        );

        serviceService.delete(service.getId());

        assertNull(serviceService.get(service.getId()));
    }
}
