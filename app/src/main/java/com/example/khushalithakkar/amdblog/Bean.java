package com.example.khushalithakkar.amdblog;

/**
 * Created by Khushali Thakkar on 7/7/2017.
 */

public class Bean {
    int country_photo;
    String newsname;
    String admin;
     String news;





    public Bean(int country_photo,String newsname,String admin,String news) {


        this.country_photo = country_photo;
        this.newsname = newsname;
        this.admin = admin;
        this.news = news;

    }

    public int getCountry_photo(){
        return country_photo;
    }

    public void setCountry_photo(int country_photo) {
        this.country_photo = country_photo;
    }
    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname;
    }


    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }


    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }





}
