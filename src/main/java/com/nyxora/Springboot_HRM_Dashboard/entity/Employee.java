package com.nyxora.Springboot_HRM_Dashboard.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private String email;
    private String phone;
    private String jobTitle;
    private double salary;
    private String joiningDate;

    public Employee(){}

    // getters setters
    public Long getId(){ return id; }
    
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getDepartment(){ return department; }
    public void setDepartment(String department){ this.department = department; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    public String getPhone(){ return phone; }
    public void setPhone(String phone){ this.phone = phone; }

    public String getJobTitle(){ return jobTitle; }
    public void setJobTitle(String jobTitle){ this.jobTitle = jobTitle; }

    public double getSalary(){ return salary; }
    public void setSalary(double salary){ this.salary = salary; }

    public String getJoiningDate(){ return joiningDate; }
    public void setJoiningDate(String joiningDate){ this.joiningDate = joiningDate; }
}
