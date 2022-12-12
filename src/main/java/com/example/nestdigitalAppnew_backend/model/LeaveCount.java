package com.example.nestdigitalAppnew_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leavecount")
public class LeaveCount {
@Id
    @GeneratedValue
    private int id;
private int empcode;
private String year;
private String casualleave;
private String sickleave;
private String specialleave

    public LeaveCount() {
    }

    public LeaveCount(int id, int empcode, String year, String casualleave, String sickleave, String specialleave) {
        this.id = id;
        this.empcode = empcode;
        this.year = year;
        this.casualleave = casualleave;
        this.sickleave = sickleave;
        this.specialleave = specialleave;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCasualleave() {
        return casualleave;
    }

    public void setCasualleave(String casualleave) {
        this.casualleave = casualleave;
    }

    public String getSickleave() {
        return sickleave;
    }

    public void setSickleave(String sickleave) {
        this.sickleave = sickleave;
    }

    public String getSpecialleave() {
        return specialleave;
    }

    public void setSpecialleave(String specialleave) {
        this.specialleave = specialleave;
    }
}
