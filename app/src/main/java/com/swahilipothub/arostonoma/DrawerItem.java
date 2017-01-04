package com.swahilipothub.arostonoma;

import android.graphics.drawable.Drawable;

/**
 * Created by Kevin Barassa on 04-Jan-17.
 */

public class DrawerItem
{
    String title;
    Drawable image;

    // Empty Constructor
    public DrawerItem()
    {

    }

    // Constructor
    public DrawerItem(String title, Drawable image)
    {
        super();
        this.title = title;
        this.image = image;
    }

    // Getter and Setter Method
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Drawable getImage()
    {
        return image;
    }

    public void setImage(Drawable image)
    {
        this.image = image;
    }


}