package com.example.nestdigitalAppnew_backend.dao;

import com.example.nestdigitalAppnew_backend.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer>{
    @Query(value = "SELECT `id`, `address`, `designation`, `email`, `empcode`, `name`, `password`, `username` FROM `employee` WHERE `empcode` =:empcode",nativeQuery = true)
    List<Employee> SearchEmployee(@Param("empcode") int empcode);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employee` WHERE `id`= :id",nativeQuery = true)
    void DeleteEmployee(@Param("id") Integer id);

    @Query(value = "SELECT `id`, `address`, `designation`, `email`, `empcode`, `name`, `password`, `username` FROM `employee` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<Employee> UserLogin(@Param("username") String username, @Param("password") String password);
    @Query(value = "SELECT `id`, `address`, `designation`, `email`, `empcode`, `name`, `password`, `username` FROM `employee` WHERE `id`= :id",nativeQuery = true)
    List<Employee> UserById(@Param("id") Integer id);
}
