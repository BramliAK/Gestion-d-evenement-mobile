package com.example.ahmed.andoidapp.model;




/**
 * Created by ahmed on 22/11/2018.
 */

public class Dateevents {

    private long id;
    private String date;


    public Dateevents() {
    }

    public Dateevents(long id, String date) {
        this.id = id;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
