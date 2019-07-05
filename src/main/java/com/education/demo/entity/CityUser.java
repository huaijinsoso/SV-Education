package com.education.demo.entity;

public class CityUser extends Page{
    private int cuserId;
    private int cityId;
    private String cuserName;
    private String cPassword;

    public int getCuserId() {
        return cuserId;
    }

    public void setCuserId(int cuserId) {
        this.cuserId = cuserId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCuserName() {
        return cuserName;
    }

    public void setCuserName(String cuserName) {
        this.cuserName = cuserName;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

}
