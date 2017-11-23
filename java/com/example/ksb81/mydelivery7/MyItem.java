package com.example.ksb81.mydelivery7;

/**
 * Created by hyon1001 on 2017-11-16.
 */

public class MyItem {
    String pname;
    String date;
    String day;
    String deldate;
    String status;
    String cname;

    public MyItem(String pname, String date, String day, String deldate, String status, String cname) {
        this.pname = pname;
        this.date = date;
        this.day = day;
        this.deldate = deldate;
        this.status = status;
        this.cname = cname;
    }

    public String getPname() {
        return pname;
    }

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getDeldate() {
        return deldate;
    }

    public String getStatus() {
        return status;
    }

    public String getCname() {
        return cname;
    }
}