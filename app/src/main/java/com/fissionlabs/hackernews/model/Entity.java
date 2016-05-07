package com.fissionlabs.hackernews.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 07-05-2016.
 */
public class Entity implements Serializable {
    private String by;
    private int descendants;
    private Long id;
    private ArrayList<Integer> kids;
    private int score;
    private long time;
    private String title;
    private String type;
    private String url;

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public int getDescendants() {
        return descendants;
    }

    public void setDescendants(int descendants) {
        this.descendants = descendants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Integer> getKids() {
        return kids;
    }

    public void setKids(ArrayList<Integer> kids) {
        this.kids = kids;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
