package com.nyxora.Springboot_HRM_Dashboard.repository;

import com.nyxora.Springboot_HRM_Dashboard.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll,Long>{

    List<Payroll> findByEmployeeId(Long employeeId);

}
