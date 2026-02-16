package com.nyxora.Springboot_HRM_Dashboard.repository;

import com.nyxora.Springboot_HRM_Dashboard.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
