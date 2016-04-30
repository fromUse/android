package com.ace.bean;

/**
 * Created by chen-gui on 16-4-30.
 */
public class Market {
    private String ID = null;
    private String user_id = null;
    private String content = null;
    private String title = null;
    private String img_url = null;
    private String phone = null;

    public Market(String ID, String phone, String img_url, String content, String title, String user_id) {
        this.ID = ID;
        this.phone = phone;
        this.img_url = img_url;
        this.content = content;
        this.title = title;
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
