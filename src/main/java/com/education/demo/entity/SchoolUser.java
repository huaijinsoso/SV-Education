package com.education.demo.entity;

public class SchoolUser extends Page {
    private int suserId;
    private int schoolId;
    private String suserName;
    private String sPassword;

    public int getSuserId() {
        return suserId;
    }

    public void setSuserId(int suserId) {
        this.suserId = suserId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSuserName() {
        return suserName;
    }

    public void setSuserName(String suserName) {
        this.suserName = suserName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }
}
