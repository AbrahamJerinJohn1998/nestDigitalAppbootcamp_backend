package com.example.nestdigitalAppnew_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "logvisitors")
public class LogVisitors {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String purpose;
    private String whomtovisit;
    private Date date;
    private String entry;
    private String exit;

    public LogVisitors() {
    }

    public LogVisitors(int id, String name, String purpose, String whomtovisit, Date date, String entry, String exit) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
        this.whomtovisit = whomtovisit;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getWhomtovisit() {
        return whomtovisit;
    }

    public void setWhomtovisit(String whomtovisit) {
        this.whomtovisit = whomtovisit;
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
