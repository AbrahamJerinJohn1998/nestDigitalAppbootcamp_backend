package com.example.nestdigitalAppnew_backend.dao;

import com.example.nestdigitalAppnew_backend.model.Leave;
import com.example.nestdigitalAppnew_backend.model.LeaveCount;
import org.springframework.data.repository.CrudRepository;

public interface LeaveDao extends CrudRepository<Leave,Integer> {
}
