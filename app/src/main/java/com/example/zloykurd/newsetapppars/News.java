package com.example.zloykurd.newsetapppars;

/**
 * Created by ZloykurD on 24.06.2016.
 **/
public class News {
    String LOG_TAG = "newsClass";

    int news_id;
    String news_title;
    String news_date;
    String news_desc;
    String news_image;
    String news_category;
    String news_link;
    String news_source;

    public News() {

    }

    public News(int news_id, String news_title, String news_date, String news_desc, String news_image, String news_category, String news_link, String news_source) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_date = news_date;
        this.news_desc = news_desc;
        this.news_image = news_image;
        this.news_category = news_category;
        this.news_link = news_link;
        this.news_source = news_source;
    }

    public News(String news_title, String news_date, String news_desc, String news_image, String news_category, String news_link, String news_source) {
        this.news_title = news_title;
        this.news_date = news_date;
        this.news_desc = news_desc;
        this.news_image = news_image;
        this.news_category = news_category;
        this.news_link = news_link;
        this.news_source = news_source;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public String getNews_desc() {
        return news_desc;
    }

    public void setNews_desc(String news_desc) {
        this.news_desc = news_desc;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }

    public String getNews_category() {
        return news_category;
    }

    public void setNews_category(String news_category) {
        this.news_category = news_category;
    }

    public String getNews_link() {
        return news_link;
    }

    public void setNews_link(String news_link) {
        this.news_link = news_link;
    }

    public String getNews_source() {
        return news_source;
    }

    public void setNews_source(String news_source) {
        this.news_source = news_source;
    }

    @Override
    public String toString() {
        return "News{" +
                "news_id=" + news_id +
                ", news_title='" + news_title + '\'' +
                ", news_date='" + news_date + '\'' +
                ", news_desc='" + news_desc + '\'' +
                ", news_image='" + news_image + '\'' +
                ", news_category='" + news_category + '\'' +
                ", news_link='" + news_link + '\'' +
                ", news_source='" + news_source + '\'' +
                '}';
    }
}
