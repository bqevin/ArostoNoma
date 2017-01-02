package com.swahilipothub.arostonoma;

/**
 * Created by Kevin Barassa on 03-Jan-17.
 */

public class CHelp {
    private String title, icon, details, counsellors;

    public CHelp(String title, String icon, String details, String counsellors) {
        this.title = title;
        this.icon = icon;
        this.details = details;
        this.counsellors = counsellors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCounsellors() {
        return counsellors;
    }

    public void setCounsellors(String counsellors) {
        this.counsellors = counsellors;
    }
}
