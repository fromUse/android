package com.ace.bean;

/**
 * Created by chen-gui on 16-4-30.
 */
public class Notice {

   private String ID = null;
   private String title = null;
   private String content = null;
   private String time = null;
   private String img_url =null;
   private String noticeurl = null;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Notice(String ID, String noticeurl, String img_url, String time, String content, String title) {
        this.ID = ID;
        this.noticeurl = noticeurl;
        this.img_url = img_url;
        this.time = time;
        this.content = content;
        this.title = title;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNoticeurl() {
        return noticeurl;
    }

    public void setNoticeurl(String noticeurl) {
        this.noticeurl = noticeurl;
    }

    public String getImgurl() {
        return img_url;
    }

    public void setImgurl(String imgurl) {
        this.img_url = imgurl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
}
