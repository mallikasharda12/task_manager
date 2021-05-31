package com.mallika_747.taskmanager;

import java.util.Date;

public class class_file {
    String tasks;
    int userid;
    Date datetime;

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getTasks() {
        return tasks;
    }

    public int getUserid() {
        return userid;
    }

    public Date getDatetime() {
        return datetime;
    }
}
