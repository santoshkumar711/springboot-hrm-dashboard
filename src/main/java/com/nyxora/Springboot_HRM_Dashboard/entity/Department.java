package com.nyxora.Springboot_HRM_Dashboard.entity;

import jakarta.persistence.*;

@Entity
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String manager;
    private int totalEmployees;

    public Department(){}

    public Long getId(){ return id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }

    public String getManager(){ return manager; }
    public void setManager(String manager){ this.manager=manager; }

    public int getTotalEmployees(){ return totalEmployees; }
    public void setTotalEmployees(int totalEmployees){ this.totalEmployees=totalEmployees; }
}
