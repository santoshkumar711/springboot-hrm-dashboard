package com.nyxora.Springboot_HRM_Dashboard.service;

import com.nyxora.Springboot_HRM_Dashboard.entity.Department;
import com.nyxora.Springboot_HRM_Dashboard.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    public String add(Department d){
        repo.save(d);
        return "Department Added";
    }

    public List<Department> all(){
        return repo.findAll();
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Deleted";
    }

    public List<Department> search(String name){
        return repo.findByNameContainingIgnoreCase(name);
    }

    public String update(Long id, Department d){

        Department old = repo.findById(id).orElse(null);

        if(old==null) return "Not found";

        old.setName(d.getName());
        old.setManager(d.getManager());
        old.setTotalEmployees(d.getTotalEmployees());

        repo.save(old);

        return "Updated";
    }
}
