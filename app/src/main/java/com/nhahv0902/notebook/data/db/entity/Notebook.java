package com.nhahv0902.notebook.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import com.nhahv0902.notebook.data.db.Converters;
import java.util.ArrayList;
import java.util.List;

/**
 * <Created by nhahv0902 on 7/6/17.
 */

@Entity
@TypeConverters(Converters.class)
public class Notebook {
    @PrimaryKey
    private long id = System.currentTimeMillis();
    private String key;
    private String title;
    private String content;
    private String place;
    private long date;
    private String time;
    private List<String> pictures = new ArrayList<>();

    public Notebook(long id, String key, String title, String content, String place, long date,
            String time, List<String> pictures) {
        this.id = id;
        this.key = key;
        this.title = title;
        this.content = content;
        this.place = place;
        this.date = date;
        this.time = time;
        this.pictures = pictures;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
