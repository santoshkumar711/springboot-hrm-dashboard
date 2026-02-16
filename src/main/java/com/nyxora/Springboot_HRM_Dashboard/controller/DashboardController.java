package com.nyxora.Springboot_HRM_Dashboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyxora.Springboot_HRM_Dashboard.repository.AttendanceRepository;
import com.nyxora.Springboot_HRM_Dashboard.repository.DepartmentRepository;
import com.nyxora.Springboot_HRM_Dashboard.repository.EmployeeRepository;
import com.nyxora.Springboot_HRM_Dashboard.repository.LeavesRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    AttendanceRepository attRepo;

    @Autowired
    LeavesRepository leaveRepo;

    @Autowired
    DepartmentRepository deptRepo;

    @GetMapping("/stats")
    public Map<String,Object> stats(){

        Map<String,Object> map=new HashMap<>();

        map.put("employees", empRepo.count());
        map.put("departments", deptRepo.count());

        long present = attRepo.countByStatus("Present");
        long leave = leaveRepo.countByStatus("Approved");

        map.put("present", present);
        map.put("leave", leave);

        return map;
    }
}

