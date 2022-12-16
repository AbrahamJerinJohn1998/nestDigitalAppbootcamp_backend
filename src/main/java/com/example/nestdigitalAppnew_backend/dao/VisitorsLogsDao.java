package com.example.nestdigitalAppnew_backend.dao;

import com.example.nestdigitalAppnew_backend.model.VisitorsLog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VisitorsLogsDao extends CrudRepository<VisitorsLog,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `visitor_logs` SET `exit_date_time`=:exit_date_time WHERE `id`=:id AND `date`=:date",nativeQuery = true)
    void UpdateExitTime(@Param("id") int id, @Param("date") String date, @Param("exit_date_time") String exit_date_time);

    @Query(value = "SELECT `id`, `date`, `entry_date_time`, `exit_date_time`, `name`, `purpose`, `whom_to_meet` FROM `visitor_logs` WHERE `date`=:date",nativeQuery = true)
    List<VisitorsLog> FindVisitorLogsByDate(@Param("date") String date);

}
