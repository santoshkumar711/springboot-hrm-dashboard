package com.nyxora.Springboot_HRM_Dashboard.controller;

import com.nyxora.Springboot_HRM_Dashboard.entity.Payroll;
import com.nyxora.Springboot_HRM_Dashboard.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollService service;


    // ADD
    @PostMapping("/add")
    public String add(@RequestBody Payroll p){
        return service.add(p);
    }


    // ALL
    @GetMapping("/all")
    public List<Payroll> all(){
        return service.all();
    }


    // SEARCH
    @GetMapping("/search/{id}")
    public List<Payroll> search(@PathVariable Long id){
        return service.search(id);
    }


    // MARK PAID
    @PutMapping("/pay/{id}")
    public String pay(@PathVariable Long id){
        return service.markPaid(id);
    }


    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return service.delete(id);
    }
}
