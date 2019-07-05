package com.education.demo.entity;

public class School extends Page{
    private int SchoolId;
    private int cityId;
    private String schoolName;

    public int getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(int schoolId) {
        SchoolId = schoolId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
