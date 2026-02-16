package com.nyxora.Springboot_HRM_Dashboard.service;

import com.nyxora.Springboot_HRM_Dashboard.entity.Leaves;
import com.nyxora.Springboot_HRM_Dashboard.repository.LeavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeavesService {

    @Autowired
    private LeavesRepository repo;

    public String apply(Leaves l){
        l.setStatus("Pending");
        repo.save(l);
        return "Leave Applied";
    }

    public List<Leaves> all(){
        return repo.findAll();
    }

    public List<Leaves> search(Long id){
        return repo.findByEmployeeId(id);
    }

    public String approve(Long id){
        Leaves l=repo.findById(id).orElse(null);
        if(l==null) return "Not found";
        l.setStatus("Approved");
        repo.save(l);
        return "Approved";
    }

    public String reject(Long id){
        Leaves l=repo.findById(id).orElse(null);
        if(l==null) return "Not found";
        l.setStatus("Rejected");
        repo.save(l);
        return "Rejected";
    }

    public String delete(Long id){
        repo.deleteById(id);
        return "Deleted";
    }
}
