package com.example.nestdigitalAppnew_backend.controller;

import com.example.nestdigitalAppnew_backend.dao.EmployeeDao;
import com.example.nestdigitalAppnew_backend.dao.SecurityGuardDao;
import com.example.nestdigitalAppnew_backend.model.Employee;
import com.example.nestdigitalAppnew_backend.model.SecurityGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityGuardController {
    @Autowired
    private SecurityGuardDao dao;
    @CrossOrigin("*")
    @PostMapping(path = "/addsg", consumes ="application/json",produces = "application/json")
    public Map<String,String> AddSecurityGuard(@RequestBody SecurityGuard s)
    {
        System.out.println(s.getName().toString());
        System.out.println(s.getEmpcode());
        System.out.println(s.getAddress().toString());
        System.out.println(s.getEmail().toString());
        System.out.println(s.getUsername().toString());
        System.out.println(s.getPassword().toString());
        dao.save(s);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        map.put("empid",String.valueOf(s.getId()));
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewsg")
    public List<SecurityGuard> ViewSecurityGuard()
    {
        return (List<SecurityGuard>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchsg",consumes = "application/json",produces = "application/json")
    public List<SecurityGuard> SearchSecurityGuard(@RequestBody SecurityGuard s)
    {
        int empcode=s.getEmpcode();
        System.out.println(empcode);
        return (List<SecurityGuard>) dao.SearchSecurityGuard(s.getEmpcode());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deletesg",consumes = "application/json",produces = "application/json")
    public Map<String, String> DeleteSecurityGuard(@RequestBody Employee e)
    {
        String id=String.valueOf(e.getId());
        System.out.println(id);
        dao.DeleteSecurityGuard(e.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
}
