package com.example.jawwad.biosapp;

import java.io.Serializable;

public class DataModel implements Serializable {

    String names;
    String description;
    int images;

    public DataModel(String names, String description, int images) {
        this.names = names;
        this.description = description;
        this.images = images;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
