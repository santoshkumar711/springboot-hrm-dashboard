package com.nyxora.Springboot_HRM_Dashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyxora.Springboot_HRM_Dashboard.entity.Performance;
import com.nyxora.Springboot_HRM_Dashboard.repository.PerformanceRepository;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository repo;

    public String add(Performance p){
        repo.save(p);
        return "Performance Saved";
    }

    public List<Performance> all(){
        return repo.findAll();
    }

    public List<Performance> search(Long id){
        return repo.findByEmployeeId(id);
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Deleted";
    }
}

