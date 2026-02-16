package com.nyxora.Springboot_HRM_Dashboard.entity;

import jakarta.persistence.*;

@Entity
@Table(name="payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String name;
    private String month;

    private double salary;
    private double bonus;
    private double deduction;
    private double netSalary;

    private String status; // Paid / Pending

    public Payroll(){}

    public Long getId(){ return id; }

    public Long getEmployeeId(){ return employeeId; }
    public void setEmployeeId(Long employeeId){ this.employeeId = employeeId; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getMonth(){ return month; }
    public void setMonth(String month){ this.month = month; }

    public double getSalary(){ return salary; }
    public void setSalary(double salary){ this.salary = salary; }

    public double getBonus(){ return bonus; }
    public void setBonus(double bonus){ this.bonus = bonus; }

    public double getDeduction(){ return deduction; }
    public void setDeduction(double deduction){ this.deduction = deduction; }

    public double getNetSalary(){ return netSalary; }
    public void setNetSalary(double netSalary){ this.netSalary = netSalary; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }
}
