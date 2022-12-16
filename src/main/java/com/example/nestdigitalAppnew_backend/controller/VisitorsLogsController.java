package com.example.nestdigitalAppnew_backend.controller;

import com.example.nestdigitalAppnew_backend.dao.VisitorsLogsDao;
import com.example.nestdigitalAppnew_backend.model.VisitorsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class VisitorsLogsController {

    @Autowired
    private VisitorsLogsDao vldao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/visitorEntryAdd",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddVisitorEntry(@RequestBody VisitorsLog vl)
    {
        String name=String.valueOf(vl.getName());
        String purpose=String.valueOf(vl.getPurpose());
        String whomtomeet=String.valueOf(vl.getWhomToMeet());
        vl.setDate(String.valueOf(java.time.LocalDate.now()));
        vl.setEntryDateTime(String.valueOf(java.time.LocalTime.now()));

        vldao.save(vl);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","visitor entry added");

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/visitorExitAdd",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddEmployeeExit(@RequestBody VisitorsLog vl)
    {
        String eid=String.valueOf(vl.getId());
        String date=String.valueOf(vl.getDate());

        vldao.UpdateExitTime(vl.getId(),vl.getDate(),String.valueOf(java.time.LocalTime.now()));

        HashMap<String,String> map=new HashMap<>();

        map.put("status","visitor exit added");

        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findallVisitorLogs")
    public List<VisitorsLog> FindAllEmployeeLogs()
    {
        return (List<VisitorsLog>) vldao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/findVisitorLogsByDate",produces = "application/json",consumes = "application/json")
    public List<VisitorsLog> FindEmployeeLogsByDate(@RequestBody VisitorsLog vl)
    {
        String date=String.valueOf(vl.getDate());

        return (List<VisitorsLog>) vldao.FindVisitorLogsByDate(vl.getDate());
    }
}
