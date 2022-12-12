package com.example.nestdigitalAppnew_backend.controller;

import com.example.nestdigitalAppnew_backend.dao.EmployeeDao;
import com.example.nestdigitalAppnew_backend.model.Employee;
import com.example.nestdigitalAppnew_backend.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao dao;
    @CrossOrigin("*")
    @PostMapping(path = "/add", consumes ="application/json",produces = "application/json")
    public Map<String,String> AddEmployee(@RequestBody Employee e)
    {
        System.out.println(e.getName().toString());
        System.out.println(e.getEmpcode());
        System.out.println(e.getDesignation().toString());
        System.out.println(e.getEmail().toString());
        System.out.println(e.getAddress().toString());
        System.out.println(e.getUsername().toString());
        System.out.println(e.getPassword().toString());
        dao.save(e);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        map.put("empid",String.valueOf(e.getId()));
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Employee> ViewEmployee()
    {
        return (List<Employee>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Employee> SearchEmployee(@RequestBody Employee e)
    {
        int empcode=e.getEmpcode();
        System.out.println(empcode);
        return (List<Employee>) dao.SearchEmployee(e.getEmpcode());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public Map<String, String> DeleteEmployee(@RequestBody Employee e)
    {
        String id=String.valueOf(e.getId());
        System.out.println(id);
        dao.DeleteEmployee(e.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
}
