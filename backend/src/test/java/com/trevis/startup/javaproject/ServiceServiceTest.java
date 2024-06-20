package com.trevis.startup.javaproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trevis.startup.javaproject.dto.payload.ServiceEntityPayload;
import com.trevis.startup.javaproject.exception.AppResponseException;
import com.trevis.startup.javaproject.services.ServiceService;

@SpringBootTest
public class ServiceServiceTest {
    
    @Autowired
    ServiceService serviceService;

    @Test
    void testServiceCreation() {
        
        var service = serviceService.create(
            new ServiceEntityPayload("Service", "A generic service", true),
            1l,
            1l
        );
        
        assertNotNull(service);
        assertEquals("Service", service.getName());
        assertEquals("A generic service", service.getDescription());
    }

    @Test
    void testServiceRead() {
        
        var service = serviceService.create(
            new ServiceEntityPayload("Service", "A generic service", true),
            1l,
            1l
        );
        var found = serviceService.get(service.getId());

        assertEquals(found.getName(), service.getName());
        assertThrows(AppResponseException.class, () -> { serviceService.get(10000l); });
    }

    @Test
    void testServiceUpdate() {

        var service = serviceService.create(
            new ServiceEntityPayload("Service", "A generic service", true),
            1l,
            1l
        );

        var updated = serviceService.update(
            new ServiceEntityPayload("Another Service", "A different service", true),
            service.getId()
        );

        assertNotNull(updated);
        assertEquals(updated.getName(), "Another Service");
        assertEquals(updated.getDescription(), "A different service");
    }

    @Test
    void testServiceDeletion() {

        var service = serviceService.create(
            new ServiceEntityPayload("Service", "A generic service", true),
            1l,
            1l
        );
        serviceService.delete(service.getId());

        assertThrows(AppResponseException.class, () -> { serviceService.get(service.getId()); });
    }
}
