package com.example.khushalithakkar.amdblog;

/**
 * Created by Khushali Thakkar on 7/7/2017.
 */
public class Bean {
     int newsimage1;
     int newsimage2;
     int more;
    String newsname;
    String time;
     String news;
     String newssub;
     String intrest;


    public Bean(int newsimage1, int newsimage2, int more, String newsname, String time, String news, String newssub, String intrest) {

        this.newsimage1 = newsimage1;
        this.newsimage2 = newsimage2;
        this.more = more;
        this.newsname = newsname;
        this.time = time;
        this.news = news;
        this.newssub = newssub;
        this.intrest = intrest;


    }

    public int getNewsimage1() {
        return newsimage1;
    }

    public void setNewsimage1(int newsimage1) {
        this.newsimage1 = newsimage1;
    }

    public int getNewsimage2() {
        return newsimage2;
    }

    public void setNewsimage2(int newsimage2) {
        this.newsimage2 = newsimage2;
    }

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getNewssub() {
        return newssub;
    }

    public void setNewssub(String newssub) {
        this.newssub = newssub;
    }

    public String getIntrest() {
        return intrest;
    }

    public void setIntrest(String intrest) {
        this.intrest = intrest;
    }

}
