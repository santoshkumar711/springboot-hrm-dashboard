package com.nyxora.Springboot_HRM_Dashboard.controller;

import com.nyxora.Springboot_HRM_Dashboard.entity.Employee;
import com.nyxora.Springboot_HRM_Dashboard.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // ADD
    @PostMapping("/add")
    public String add(@RequestBody Employee e){
        return service.addEmployee(e);
    }

    // GET ALL
    @GetMapping("/all")
    public List<Employee> all(){
        return service.getAll();
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return service.delete(id);
    }

    // SEARCH BY ID
    @GetMapping("/search/{id}")
    public Employee search(@PathVariable Long id){
        return service.getOne(id);
    }
}

