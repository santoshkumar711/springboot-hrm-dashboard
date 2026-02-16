package com.nyxora.Springboot_HRM_Dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nyxora.Springboot_HRM_Dashboard.entity.Attendance;
import com.nyxora.Springboot_HRM_Dashboard.entity.Employee;
import com.nyxora.Springboot_HRM_Dashboard.entity.Payroll;
import com.nyxora.Springboot_HRM_Dashboard.entity.Performance;
import com.nyxora.Springboot_HRM_Dashboard.repository.AttendanceRepository;
import com.nyxora.Springboot_HRM_Dashboard.repository.EmployeeRepository;
import com.nyxora.Springboot_HRM_Dashboard.repository.PayrollRepository;
import com.nyxora.Springboot_HRM_Dashboard.repository.PerformanceRepository;

@RestController
@RequestMapping("/reports")
@CrossOrigin("*")
public class ReportsController {

@Autowired AttendanceRepository attendanceRepo;
@Autowired PayrollRepository payrollRepo;
@Autowired EmployeeRepository employeeRepo;
@Autowired PerformanceRepository performanceRepo;

@GetMapping("/filter")
public Map<String,Object> filter(
@RequestParam(required=false) Integer month,
@RequestParam(required=false) Integer year,
@RequestParam(required=false) String dept){

Map<String,Object> map=new HashMap<>();


/* ATTENDANCE FILTER */
List<Attendance> list=attendanceRepo.findAll().stream()
.filter(a->{

boolean ok=true;

if(month!=null && !a.getDate().isEmpty()){
ok &= Integer.parseInt(a.getDate().substring(5,7))==month;
}

if(year!=null && !a.getDate().isEmpty()){
ok &= Integer.parseInt(a.getDate().substring(0,4))==year;
}

if(dept!=null && !dept.isEmpty()){
ok &= dept.equalsIgnoreCase(a.getDepartment());
}

return ok;
})
.toList();

long present=list.stream().filter(a->"Present".equals(a.getStatus())).count();
long absent=list.stream().filter(a->"Absent".equals(a.getStatus())).count();
long leave=list.stream().filter(a->"Leave".equals(a.getStatus())).count();

map.put("present",present);
map.put("absent",absent);
map.put("leave",leave);



/* SALARY FILTER */
List<Payroll> pay=payrollRepo.findAll().stream()
.filter(p->{

boolean ok=true;

if(month!=null && p.getMonth()!=null){
ok &= Integer.parseInt(p.getMonth().split("-")[1])==month;
}

if(year!=null && p.getMonth()!=null){
ok &= Integer.parseInt(p.getMonth().split("-")[0])==year;
}

return ok;
})
.toList();

map.put("salaryLabels", pay.stream().map(Payroll::getMonth).toList());
map.put("salaryData", pay.stream().map(Payroll::getNetSalary).toList());



/* DEPARTMENT FILTER */
List<Employee> emp=employeeRepo.findAll().stream()
.filter(e->{
if(dept==null || dept.isEmpty()) return true;
return dept.equalsIgnoreCase(e.getDepartment());
})
.toList();

Map<String,Long> dmap=emp.stream()
.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

map.put("deptLabels",dmap.keySet());
map.put("deptCounts",dmap.values());



/* PERFORMANCE FILTER */
List<Performance> perf=performanceRepo.findAll().stream()
.filter(p->{

boolean ok=true;

if(month!=null && p.getDate()!=null){
ok &= Integer.parseInt(p.getDate().substring(5,7))==month;
}

if(year!=null && p.getDate()!=null){
ok &= Integer.parseInt(p.getDate().substring(0,4))==year;
}

return ok;
})
.toList();

map.put("excellent",perf.stream().filter(p->"Excellent".equals(p.getRating())).count());
map.put("good",perf.stream().filter(p->"Good".equals(p.getRating())).count());
map.put("average",perf.stream().filter(p->"Average".equals(p.getRating())).count());
map.put("poor",perf.stream().filter(p->"Poor".equals(p.getRating())).count());

return map;
}
}
