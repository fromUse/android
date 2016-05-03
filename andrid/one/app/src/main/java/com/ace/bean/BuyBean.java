package com.ace.bean;

import java.io.Serializable;

/**
 * Created by chen-gui on 16-5-2.
 */
public class BuyBean implements Serializable {


    String id      = null;
    String user_id = null;
    String title  =  null;
    String content = null;
    String phone =   null;
    String time = null;


    public BuyBean(String id, String time, String phone, String content, String title, String user_id) {
        this.id = id;
        this.time = time;
        this.phone = phone;
        this.content = content;
        this.title = title;
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
