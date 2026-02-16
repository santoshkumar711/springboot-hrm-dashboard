package com.nyxora.Springboot_HRM_Dashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyxora.Springboot_HRM_Dashboard.entity.Performance;

public interface PerformanceRepository extends JpaRepository<Performance,Long>{

    List<Performance> findByEmployeeId(Long employeeId);

}

