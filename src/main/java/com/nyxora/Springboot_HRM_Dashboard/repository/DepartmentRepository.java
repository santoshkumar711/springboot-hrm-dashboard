package com.nyxora.Springboot_HRM_Dashboard.repository;

import com.nyxora.Springboot_HRM_Dashboard.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    List<Department> findByNameContainingIgnoreCase(String name);

}
