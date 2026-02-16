package com.nyxora.Springboot_HRM_Dashboard.entity;

import jakarta.persistence.*;

@Entity
@Table(name="attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    private String name;

    private String date;

    private String status; // Present / Absent / Leave

    private String checkIn;

    private String checkOut;
    
    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	private String department;


    public Attendance(){}

    public Long getId(){ return id; }

    public Long getEmployeeId(){ return employeeId; }
    public void setEmployeeId(Long employeeId){ this.employeeId = employeeId; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getDate(){ return date; }
    public void setDate(String date){ this.date = date; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }

    public String getCheckIn(){ return checkIn; }
    public void setCheckIn(String checkIn){ this.checkIn = checkIn; }

    public String getCheckOut(){ return checkOut; }
    public void setCheckOut(String checkOut){ this.checkOut = checkOut; }
}
