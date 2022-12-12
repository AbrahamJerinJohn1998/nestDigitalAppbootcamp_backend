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
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemp", consumes ="application/json",produces = "application/json")
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
    @GetMapping("/viewemp")
    public List<Employee> ViewEmployee()
    {
        return (List<Employee>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemp",consumes = "application/json",produces = "application/json")
    public List<Employee> SearchEmployee(@RequestBody Employee e)
    {
        int empcode=e.getEmpcode();
        System.out.println(empcode);
        return (List<Employee>) dao.SearchEmployee(e.getEmpcode());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteemp",consumes = "application/json",produces = "application/json")
    public Map<String, String> DeleteEmployee(@RequestBody Employee e)
    {
        String id=String.valueOf(e.getId());
        System.out.println(id);
        dao.DeleteEmployee(e.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/emplogin",consumes = "application/json",produces = "application/json")
    public Map<String,String> UserLogin(@RequestBody Employee e)
    {
        String username= e.getUsername().toString();
        String password=e.getPassword().toString();
        System.out.println(username);
        System.out.println(password);
        List<Employee> result=(List<Employee>) dao.UserLogin(e.getUsername(),e.getPassword());
        HashMap<String,String> map=new HashMap<>();
        if(result.size()==0)
        {
            map.put("status","failed");
        }
        else{
            int id=result.get(0).getId();
            map.put("userId",String.valueOf(id));
            map.put("status","success");
        }
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/empviewprofile",consumes = "application/json",produces = "application/json")
    public List<Employee> UserById(@RequestBody Employee e)
    {
        String id=String.valueOf(e.getId());
        System.out.println(id);
        return (List<Employee>) dao.UserById(e.getId());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateemp",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> UpdateEmployee(@RequestBody Employee e)
    {
        String eid=String.valueOf(e.getId());
        String empCode=String.valueOf(e.getEmpcode());
        String name=String.valueOf(e.getName().toString());
        String designation=String.valueOf(e.getDesignation().toString());
        String address=String.valueOf(e.getAddress().toString());
        String email=String.valueOf(e.getEmail().toString());
        String password=String.valueOf(e.getPassword().toString());

        dao.UpdateEmployeeFields(e.getId(),e.getEmpcode(),e.getName(),e.getDesignation(),e.getAddress(),e.getEmail(),e.getPassword());

        HashMap<String,String> map=new HashMap<>();

        map.put("status","updated employee record!");

        return map;
    }
}
