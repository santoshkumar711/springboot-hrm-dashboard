package com.nyxora.Springboot_HRM_Dashboard.controller;

import com.nyxora.Springboot_HRM_Dashboard.entity.Leaves;
import com.nyxora.Springboot_HRM_Dashboard.service.LeavesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/leave")
public class LeavesController {

    @Autowired
    private LeavesService service;

    @PostMapping("/apply")
    public String apply(@RequestBody Leaves l){
        return service.apply(l);
    }

    @GetMapping("/all")
    public List<Leaves> all(){
        return service.all();
    }

    @GetMapping("/search/{id}")
    public List<Leaves> search(@PathVariable Long id){
        return service.search(id);
    }

    @PutMapping("/approve/{id}")
    public String approve(@PathVariable Long id){
        return service.approve(id);
    }

    @PutMapping("/reject/{id}")
    public String reject(@PathVariable Long id){
        return service.reject(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return service.delete(id);
    }
}
