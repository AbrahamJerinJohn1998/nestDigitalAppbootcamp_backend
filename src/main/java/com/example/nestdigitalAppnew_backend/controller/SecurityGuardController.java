package com.example.nestdigitalAppnew_backend.controller;

import com.example.nestdigitalAppnew_backend.dao.SecurityGuardDao;
import com.example.nestdigitalAppnew_backend.model.Employee;
import com.example.nestdigitalAppnew_backend.model.SecurityGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SecurityGuardController {
    @Autowired
    private SecurityGuardDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path="/addsg", consumes ="application/json",produces = "application/json")
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
    public Map<String, String> DeleteSecurityGuard(@RequestBody SecurityGuard s)
    {
        String id=String.valueOf(s.getId());
        System.out.println(id);
        dao.DeleteSecurityGuard(s.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/sglogin",consumes = "application/json",produces = "application/json")
    public Map<String,String> SecurityGuardLogin(@RequestBody SecurityGuard s)
    {
        String username= s.getUsername().toString();
        String password=s.getPassword().toString();
        System.out.println(username);
        System.out.println(password);
        List<SecurityGuard> result=(List<SecurityGuard>) dao.SecurityGuardLogin(s.getUsername(),s.getPassword());
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
    @PostMapping(path = "/sgviewprofile",consumes = "application/json",produces = "application/json")
    public List<SecurityGuard> UserById(@RequestBody SecurityGuard s)
    {
        String id=String.valueOf(s.getId());
        System.out.println(id);
        return (List<SecurityGuard>) dao.UserById(s.getId());
    }
}
