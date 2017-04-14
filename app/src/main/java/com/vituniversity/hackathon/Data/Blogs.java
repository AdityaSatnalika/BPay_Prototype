package com.vituniversity.hackathon.Data;

/**
 * Created by SHAAN on 14-04-17.
 */
public class Blogs {

    private String title;
    private String author;
    private String hashtags;
    private String paymentType;
    private float price;
    private String desc;
    private String body;
    private int viewers;
    private String date;
    private String time;

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Blogs() {
        this.desc = "empty";
        this.author = "empty";
        this.date = "empty";
        this.hashtags = "empty";
        this.paymentType = "empty";
        this.price = 0.0f;
        this.time = "empty";
        this.title = "empty";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Blogs(String title, String author, String hashtags, String paymentType, float
            price, String body, String desc, String date, String time) {
        this.body = body;
        this.desc = desc;
        this.date = date;
        this.author = author;
        this.hashtags = hashtags;
        this.paymentType = paymentType;
        this.price = price;
        this.time = time;
        this.title = title;
        this.viewers = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
