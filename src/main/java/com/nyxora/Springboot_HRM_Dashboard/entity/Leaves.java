package com.nyxora.Springboot_HRM_Dashboard.entity;

import jakarta.persistence.*;

@Entity
@Table(name="leaves")
public class Leaves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String name;
    private String type;
    private String fromDate;
    private String toDate;
    private String reason;
    private String status; // Pending / Approved / Rejected

    public Leaves(){}

    public Long getId(){ return id; }

    public Long getEmployeeId(){ return employeeId; }
    public void setEmployeeId(Long employeeId){ this.employeeId = employeeId; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getType(){ return type; }
    public void setType(String type){ this.type = type; }

    public String getFromDate(){ return fromDate; }
    public void setFromDate(String fromDate){ this.fromDate = fromDate; }

    public String getToDate(){ return toDate; }
    public void setToDate(String toDate){ this.toDate = toDate; }

    public String getReason(){ return reason; }
    public void setReason(String reason){ this.reason = reason; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }
}
