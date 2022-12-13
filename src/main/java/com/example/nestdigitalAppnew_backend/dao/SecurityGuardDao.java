package com.example.nestdigitalAppnew_backend.dao;

import com.example.nestdigitalAppnew_backend.model.Employee;
import com.example.nestdigitalAppnew_backend.model.SecurityGuard;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityGuardDao extends CrudRepository<SecurityGuard,Integer> {

//    @Query(value = "SELECT `id`, `address`, `email`, `empcode`, `name`, `password`, `username` FROM `securityguard` WHERE `empcode` =:empcode",nativeQuery = true)
//    List<SecurityGuard> SearchSecurityGuard(@Param("empcode") int empcode);
//    @Modifying
//    @Transactional
//    @Query(value = "DELETE FROM `securityguard` WHERE `id`= :id",nativeQuery = true)
//    void DeleteSecurityGuard(@Param("id") Integer id);
//
//    @Query(value = "SELECT `id`, `address`, `email`, `empcode`, `name`, `password`, `username` FROM `securityguard` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
//    List<SecurityGuard> SecurityGuardLogin(@Param("username") String username, @Param("password") String password);
//    @Query(value = "SELECT `id`, `address`, `email`, `empcode`, `name`, `password`, `username` FROM `securityguard` WHERE `id`= :id",nativeQuery = true)
//    List<SecurityGuard> UserById(@Param("id") Integer id);
}
