package com.swahilipothub.arostonoma;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by ZoomIT User1 on 8/25/2016.
 */
public class SectionFragObject {



    private String name;
    private int photo;

    public SectionFragObject(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
