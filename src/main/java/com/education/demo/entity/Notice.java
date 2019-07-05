package com.education.demo.entity;

import javax.xml.soap.Text;
import java.util.Date;

public class Notice extends Page{
    private int noticeId;
    private int cuserId;
    private String noticeName;
    private String noticeType;
    private Date relTime;
    private Date valTime;
    private String message;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public int getCuserId() {
        return cuserId;
    }

    public void setCuserId(int cuserId) {
        this.cuserId = cuserId;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public Date getRelTime() {
        return relTime;
    }

    public void setRelTime(Date relTime) {
        this.relTime = relTime;
    }

    public Date getValTime() {
        return valTime;
    }

    public void setValTime(Date valTime) {
        this.valTime = valTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
