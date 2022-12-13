package com.example.nestdigitalAppnew_backend.controller;

import com.example.nestdigitalAppnew_backend.dao.LeaveCountDao;
import com.example.nestdigitalAppnew_backend.dao.LeaveDao;
import com.example.nestdigitalAppnew_backend.model.Employee;
import com.example.nestdigitalAppnew_backend.model.Leave;
import com.example.nestdigitalAppnew_backend.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {
    @Autowired
    private LeaveDao ldao;
    @Autowired
    private LeaveCountDao l1dao;

   DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyLeave", produces = "application/json", consumes = "application/json")
    public HashMap<String, String> ApplyLeave(@RequestBody Leave lv){
        LocalDateTime now = LocalDateTime.now();
        lv.setApplieddate(date.format(now));
        ldao.save(lv);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllLeaves")
    public List<Map<String, String>> GetAllLeaves(){
        return ldao.GetAllLeaves();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/getEmployeeLeaves", produces = "application/json", consumes = "application/json")
    public List<Leave> GetEmployeeLeaves(@RequestBody Employee emp){
        return ldao.GetEmployeeLeaves(Integer.valueOf(emp.getId()));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateLeaves", produces = "application/json", consumes = "application/json")
    public HashMap<String, String> UpdateLeaves(@RequestBody Leave lv){
        ldao.UpdateLeaves(lv.getId(), lv.getStatus());
        String leaveType = lv.getLeavetype();
        System.out.println(lv.getFromdate());
        System.out.println(lv.getTodate());
        LocalDate dateBefore = LocalDate.parse(lv.getFromdate());
        LocalDate dateAfter = LocalDate.parse(lv.getTodate());
        int daysOfLeave = (int) ChronoUnit.DAYS.between(dateBefore, dateAfter)+1;
        List<LeaveCount> l1 = (List<LeaveCount>) l1dao.GetLeaveDetails(lv.getEmpcode());
        System.out.println(l1.get(0).getCasualleave()-daysOfLeave);
        if(leaveType.equals("casualLeave")){
            l1dao.UpdateLeave(lv.getEmpcode(),(l1.get(0).getCasualleave()-daysOfLeave),l1.get(0).getSickleave(),l1.get(0).getSpecialleave());
        } else if (leaveType.equals("sickLeave")) {
            l1dao.UpdateLeave(lv.getEmpcode(),l1.get(0).getCasualleave(),(l1.get(0).getSickleave()-daysOfLeave),l1.get(0).getSpecialleave());
        }else if (leaveType.equals("specialLeave")){
            l1.get(0).setSpecialleave(l1.get(0).getSickleave()-daysOfLeave);
            l1dao.UpdateLeave(lv.getEmpcode(),l1.get(0).getCasualleave(),l1.get(0).getSickleave(),(l1.get(0).getSickleave()-daysOfLeave));
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("status","success");
        return hashMap;
    }

}
