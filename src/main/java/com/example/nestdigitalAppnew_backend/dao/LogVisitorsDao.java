package com.example.nestdigitalAppnew_backend.dao;

import com.example.nestdigitalAppnew_backend.model.LeaveCount;
import com.example.nestdigitalAppnew_backend.model.LogVisitors;
import org.springframework.data.repository.CrudRepository;

public interface LogVisitorsDao extends CrudRepository<LogVisitors,Integer> {
}
