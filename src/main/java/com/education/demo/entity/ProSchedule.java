package com.education.demo.entity;

import java.util.Date;

public class ProSchedule extends Page{
    private int schId;
    private int projectId;
    private String schAddress;
    private Date handinTime;
    private int checkWait;
    private int checkResult;

    public int getSchId() {
        return schId;
    }

    public void setSchId(int schId) {
        this.schId = schId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getSchAddress() {
        return schAddress;
    }

    public void setSchAddress(String schAddress) {
        this.schAddress = schAddress;
    }

    public Date getHandinTime() {
        return handinTime;
    }

    public void setHandinTime(Date handinTime) {
        this.handinTime = handinTime;
    }

    public int getCheckWait() {
        return checkWait;
    }

    public void setCheckWait(int checkWait) {
        this.checkWait = checkWait;
    }

    public int getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(int checkResult) {
        this.checkResult = checkResult;
    }
}
