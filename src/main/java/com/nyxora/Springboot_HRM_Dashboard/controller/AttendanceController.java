package com.nyxora.Springboot_HRM_Dashboard.controller;

import com.nyxora.Springboot_HRM_Dashboard.entity.Attendance;
import com.nyxora.Springboot_HRM_Dashboard.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;


    @PostMapping("/add")
    public String add(@RequestBody Attendance a){
        return service.add(a);
    }


    @GetMapping("/all")
    public List<Attendance> all(){
        return service.all();
    }


    @GetMapping("/search/{id}")
    public List<Attendance> search(@PathVariable Long id){

    System.out.println("SEARCH ID = "+id);

    return service.searchByEmployeeId(id);
    }




    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return service.delete(id);
    }
}
