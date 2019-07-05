package com.education.demo.entity;

import java.util.Date;

public class Project extends Page{
    private int projectId;
    private int schoolId;
    private String proName;
    private String proAddress;
    private String proClass;
    private int fund;
    private Date applyTime;
    private String proProgress;
    private int checkWait;
    private int checkResult;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }

    public String getProClass() {
        return proClass;
    }

    public void setProClass(String proClass) {
        this.proClass = proClass;
    }

    public int getFund() {
        return fund;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getProProgress() {
        return proProgress;
    }

    public void setProProgress(String proProgress) {
        this.proProgress = proProgress;
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
