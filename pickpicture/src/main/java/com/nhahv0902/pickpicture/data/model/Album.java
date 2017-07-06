package com.nhahv0902.pickpicture.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhahv0902 on 7/8/2017.
 * <></>
 */

public class Album {
    private String name;
    private List<String> pictures = new ArrayList<>();

    public Album(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
