package com.trevis.startup.javaproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserEntity")
public class UserEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    @ManyToOne @JoinColumn(name = "DepartmentId", referencedColumnName = "id")
    private DepartmentEntity departmentEntity;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }
    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public UserEntity() {}

    public UserEntity(String userName, String password, DepartmentEntity departmentEntity) {
        this.userName = userName;
        this.password = password;
        this.departmentEntity = departmentEntity;
    }
}
