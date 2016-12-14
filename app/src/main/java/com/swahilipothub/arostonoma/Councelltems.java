package com.swahilipothub.arostonoma;

/**
 * Created by ZoomIT User1 on 8/28/2016.
 */
public class Councelltems {

    private String category;
    private String description;
    private int image_id;

    public Councelltems(){}

    public Councelltems(String category, String description, int image_id) {

        this.category = category;
        this.description = description;
        this.image_id = image_id;
    }


    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public int getImage() {

        return image_id;
    }

    public void setImage(int image_location) {

        this.image_id = image_location;
    }
}
