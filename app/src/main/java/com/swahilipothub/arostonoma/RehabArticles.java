package com.swahilipothub.arostonoma;

/**
 * Created by Kevin Barassa on 04/01/2017.
 */
public class RehabArticles {

    private String title, body, author, image,time;

    public RehabArticles(){}


    public RehabArticles(String title, String body, String author, String image, String time) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.image = image;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
