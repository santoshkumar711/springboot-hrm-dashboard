package com.nyxora.Springboot_HRM_Dashboard.repository;

import com.nyxora.Springboot_HRM_Dashboard.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Long>{

    List<Attendance> findByEmployeeId(Long employeeId);
    long countByStatus(String status);


}
