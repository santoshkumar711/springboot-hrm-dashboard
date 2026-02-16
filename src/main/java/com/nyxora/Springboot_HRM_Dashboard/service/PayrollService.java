package com.nyxora.Springboot_HRM_Dashboard.service;

import com.nyxora.Springboot_HRM_Dashboard.entity.Payroll;
import com.nyxora.Springboot_HRM_Dashboard.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository repo;


    // ADD PAYROLL
    public String add(Payroll p){

        double net = p.getSalary() + p.getBonus() - p.getDeduction();
        p.setNetSalary(net);

        if(p.getStatus()==null)
            p.setStatus("Pending");

        repo.save(p);
        return "Payroll Generated Successfully";
    }


    // GET ALL
    public List<Payroll> all(){
        return repo.findAll();
    }


    // SEARCH BY EMPLOYEE ID
    public List<Payroll> search(Long id){
        return repo.findByEmployeeId(id);
    }


    // MARK PAID
    public String markPaid(Long id){

        Payroll p = repo.findById(id).orElse(null);

        if(p==null) return "Record Not Found";

        p.setStatus("Paid");
        repo.save(p);

        return "Marked as Paid";
    }


    // DELETE
    public String delete(Long id){
        repo.deleteById(id);
        return "Deleted Successfully";
    }
}
