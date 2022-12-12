package com.example.nestdigitalAppnew_backend.model;

import java.util.Date;

public class Leave {
    private int id;
    private int empcode;
    private  String leavetype;
    private String remarks;
    private Date applieddate;
    private Date fromdate;
    private Date todate;
    private String status;

    public Leave() {
    }

    public Leave(int id, int empcode, String leavetype, String remarks, Date applieddate, Date fromdate, Date todate, String status) {
        this.id = id;
        this.empcode = empcode;
        this.leavetype = leavetype;
        this.remarks = remarks;
        this.applieddate = applieddate;
        this.fromdate = fromdate;
        this.todate = todate;
        this.status = status;
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

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getApplieddate() {
        return applieddate;
    }

    public void setApplieddate(Date applieddate) {
        this.applieddate = applieddate;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
