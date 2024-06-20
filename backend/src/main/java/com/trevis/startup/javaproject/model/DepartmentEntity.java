package com.trevis.startup.javaproject.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "DepartmentEntity")
public class DepartmentEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DepartmentName")
    private String departmentName;

    @OneToMany(mappedBy = "departmentEntity")
    private Set<UserEntity> userEntities;

    @OneToMany(mappedBy = "departmentEntity")
    private Set<ServiceEntity> serviceEntities;


    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
