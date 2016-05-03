package com.ace.bean;

/**
 * Created by chen-gui on 16-5-3.
 */
public class SellBean {

             /*"id":"1",
            "user_id":"2014111111",
            "title":"贱卖宝贝电脑",
            "price":"2500",
            "content":"缺钱、缺钱、缺钱， 电脑配件齐全， 无暗病可以小刀， 私聊QQ123456789",
            "url":"http://img.3ghuashang.com/upload/zhaotie/1204/11/20843bc9c9fe19666d84bf170ee6b092.jpg",
            "phone":"123456789101"*/
    String id = null;
    String user_id = null;
    String title = null;
    String price = null;
    String content = null;
    String imgURL = null;
    String phone = null;
    String time = null;

    public SellBean(String id, String time, String phone, String imgURL, String content, String price, String title, String user_id) {
        this.id = id;
        this.time = time;
        this.phone = phone;
        this.imgURL = imgURL;
        this.content = content;
        this.price = price;
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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
}
