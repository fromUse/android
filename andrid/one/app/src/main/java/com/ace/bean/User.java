package com.ace.bean;

/**
 * Created by chen-gui on 16-4-30.
 */
public class User {
   private String user_id = null;
   private String user_name = null;
   private String password = null;
   private String class_id = null;
   private String all_hours = null;
   private String ID = null;
   private String alias = null;

    public User(String user_id, String alias, String all_hours, String class_id, String password, String user_name, String ID) {
        this.user_id = user_id;
        this.alias = alias;
        this.all_hours = all_hours;
        this.class_id = class_id;
        this.password = password;
        this.user_name = user_name;
        this.ID = ID;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAll_hours() {
        return all_hours;
    }

    public void setAll_hours(String all_hours) {
        this.all_hours = all_hours;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
