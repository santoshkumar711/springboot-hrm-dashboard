package com.nyxora.Springboot_HRM_Dashboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="performance")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String name;
    private String rating;
    private String reviewer;
    private String date;

    public Performance(){}

    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }

    public Long getEmployeeId(){ return employeeId; }
    public void setEmployeeId(Long employeeId){ this.employeeId = employeeId; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getRating(){ return rating; }
    public void setRating(String rating){ this.rating = rating; }

    public String getReviewer(){ return reviewer; }
    public void setReviewer(String reviewer){ this.reviewer = reviewer; }

    public String getDate(){ return date; }
    public void setDate(String date){ this.date = date;
    }
}
