package com.example.nestdigitalAppnew_backend.dao;

import com.example.nestdigitalAppnew_backend.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Query(value = "SELECT `id`, `designation`, `email_id`, `emp_code`, `name`, `password`, `phone_no`, `salary` FROM `employees` WHERE `emp_code`=:empCode",nativeQuery = true)
    List<Employee> FindEmployee(@Param("empCode") int empCode);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employees` WHERE `id`=:id",nativeQuery = true)
    void DeleteEmployee(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `employees` SET `designation`=:designation,`email_id`=:emailId,`emp_code`=:empCode,`name`=:name,`password`=:password,`phone_no`=:phoneNo,`salary`=:salary WHERE `id`=:id",nativeQuery = true)
    void UpdateEmployeeFields(@Param("id") int id,@Param("empCode") int empCode,@Param("name") String name,@Param("designation") String designation,@Param("salary") int salary,@Param("phoneNo") String phoneNo,@Param("emailId") String emailId,@Param("password") String password);
}

