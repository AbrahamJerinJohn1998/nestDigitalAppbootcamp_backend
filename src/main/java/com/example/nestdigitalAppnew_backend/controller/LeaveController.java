package com.example.nestdigitalAppnew_backend.controller;

import com.example.nestdigitalAppnew_backend.dao.LeaveDao;
import com.example.nestdigitalAppnew_backend.model.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao ladao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeave",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddLeave(@RequestBody Leave la)
    {
        String empId = String.valueOf(la.getEmpId());
        String leaveType = la.getLeaveType();
        String remarks = la.getRemarks();
        String fromDate = String.valueOf(la.getFromDate());
        String toDate = String.valueOf(la.getToDate());
        String applyDate = String.valueOf(la.getApplyDate());
        String leaveStatus = String.valueOf(la.getLeaveStatus());


        ladao.save(la);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","applied for leave successfully");

        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/handleLeave",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> HandleLeave(@RequestBody Leave la)
    {
        String id=String.valueOf(la.getId());
        String empId=String.valueOf(la.getEmpId());


        String leaveStatus=String.valueOf(la.getLeaveStatus());

        ladao.UpdateLeaveStatus(la.getId(),la.getEmpId(),la.getLeaveStatus());

        HashMap<String,String> map=new HashMap<>();

        if(Objects.equals(leaveStatus, "1"))
        {
            map.put("status","leave approved");
            map.put("empId",String.valueOf(la.getEmpId()));
            map.put("leaveType",la.getLeaveType());
        }
        else if(Objects.equals(la.getLeaveStatus(), "0"))
        {
            map.put("status","Leave in processing");
        }
        else
        {
            map.put("status","leave not approved");
        }

        return map;
    }

}