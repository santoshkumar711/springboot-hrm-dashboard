package com.nyxora.Springboot_HRM_Dashboard.service;

import com.nyxora.Springboot_HRM_Dashboard.entity.Employee;
import com.nyxora.Springboot_HRM_Dashboard.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public String addEmployee(Employee e){
        repo.save(e);
        return "Employee Added";
    }

    public List<Employee> getAll(){
        return repo.findAll();
    }

    public String delete(Long id){

        if(!repo.existsById(id))
            return "Employee not found";

        repo.deleteById(id);
        return "Employee Deleted";
    }

    public Employee getOne(Long id){
        return repo.findById(id).orElse(null);
    }
}
