package com.nyxora.Springboot_HRM_Dashboard.repository;

import com.nyxora.Springboot_HRM_Dashboard.entity.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeavesRepository extends JpaRepository<Leaves,Long>{

    List<Leaves> findByEmployeeId(Long employeeId);
    long countByStatus(String status);


}
