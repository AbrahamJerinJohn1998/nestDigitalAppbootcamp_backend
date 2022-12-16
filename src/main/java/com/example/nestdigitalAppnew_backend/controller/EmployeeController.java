package com.example.nestdigitalAppnew_backend.controller;

import com.example.nestdigitalAppnew_backend.model.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class EmployeeController {
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
        dao.save(s);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
}
}
