package com.example.nestdigitalAppnew_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "logemployee")
public class LogEmployee {
    @Id
    @GeneratedValue
    private int id;
    private int empcode;
    private Date date;
    private String entry;
    private String exit;

    public LogEmployee() {
    }

    public LogEmployee(int id, int empcode, Date date, String entry, String exit) {
        this.id = id;
        this.empcode = empcode;
        this.date = date;
        this.entry = entry;
        this.exit = exit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpcode() {
        return empcode;
    }

    public void setEmpcode(int empcode) {
        this.empcode = empcode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }
}
