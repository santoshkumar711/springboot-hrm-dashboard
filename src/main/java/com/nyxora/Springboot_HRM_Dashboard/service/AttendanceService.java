package com.nyxora.Springboot_HRM_Dashboard.service;

import com.nyxora.Springboot_HRM_Dashboard.entity.Attendance;
import com.nyxora.Springboot_HRM_Dashboard.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repo;

    public String add(Attendance a){
        repo.save(a);
        return "Attendance Saved";
    }

    public List<Attendance> all(){
        return repo.findAll();
    }

    public List<Attendance> searchByEmployeeId(Long id){
        return repo.findByEmployeeId(id);
    }


    public String delete(Long id){
        repo.deleteById(id);
        return "Deleted Successfully";
    }
}
