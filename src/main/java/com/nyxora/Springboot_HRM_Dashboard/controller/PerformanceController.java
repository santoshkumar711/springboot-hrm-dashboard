package com.nyxora.Springboot_HRM_Dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyxora.Springboot_HRM_Dashboard.entity.Performance;
import com.nyxora.Springboot_HRM_Dashboard.service.PerformanceService;

@RestController
@CrossOrigin("*")
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService service;

    @PostMapping("/add")
    public String add(@RequestBody Performance p){
        return service.add(p);
    }

    @GetMapping("/all")
    public List<Performance> all(){
        return service.all();
    }

    @GetMapping("/search/{id}")
    public List<Performance> search(@PathVariable Long id){
        return service.search(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return service.delete(id);
    }
}

