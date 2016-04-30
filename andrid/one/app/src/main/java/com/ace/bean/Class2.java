package com.ace.bean;

/**
 * Created by chen-gui on 16-4-30.
 */
public class Class2 {
    private String id;
    private String class_name;

    public Class2(String id, String class_name) {
        this.id = id;
        this.class_name = class_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
