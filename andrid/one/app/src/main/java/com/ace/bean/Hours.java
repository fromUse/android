package com.ace.bean;

/**
 * Created by chen-gui on 16-4-30.
 */
public class Hours {
    private String id = null;
    private String user_id = null;
    private String content = null;
    private String time = null;
    private String event_hours = null;

    public Hours(String id, String event_hours, String time, String content, String user_id) {
        this.id = id;
        this.event_hours = event_hours;
        this.time = time;
        this.content = content;
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent_hours() {
        return event_hours;
    }

    public void setEvent_hours(String event_hours) {
        this.event_hours = event_hours;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
