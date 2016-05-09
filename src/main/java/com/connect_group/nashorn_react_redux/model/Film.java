package com.connect_group.nashorn_react_redux.model;

/**
 * Created by arran on 09/05/16.
 */
public class Film {

    private String title;
    private int year;

    public Film(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
