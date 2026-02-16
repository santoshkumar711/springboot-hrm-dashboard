package com.nyxora.Springboot_HRM_Dashboard.controller;

import com.nyxora.Springboot_HRM_Dashboard.entity.Department;
import com.nyxora.Springboot_HRM_Dashboard.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("/add")
    public String add(@RequestBody Department d){
        return service.add(d);
    }

    @GetMapping("/all")
    public List<Department> all(){
        return service.all();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return service.delete(id);
    }

    @GetMapping("/search/{name}")
    public List<Department> search(@PathVariable String name){
        return service.search(name);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,@RequestBody Department d){
        return service.update(id,d);
    }
}
