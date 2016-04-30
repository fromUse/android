package com.ace.bean;

/**
 * Created by chen-gui on 16-4-30.
 */
public class Any {

    private String ID = null;
    private String user_id =null;
    private String content = null;
    private String title = null;
    private String parent_id = null;
    private String img_url = null;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Any(String ID, String parent_id, String title, String content, String user_id) {
        this.ID = ID;
        this.parent_id = parent_id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
