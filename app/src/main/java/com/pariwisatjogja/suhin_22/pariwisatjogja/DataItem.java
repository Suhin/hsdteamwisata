package com.pariwisatjogja.suhin_22.pariwisatjogja;

/**
 * Created by SUHIN_22 on 31/12/2015.
 */
public class DataItem {
    private String name;
    private String job;

    private int photo;

    public DataItem (String name, String job, int photo) {
        this.name = name;
        this.job = job;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getPhoto() {
        return photo;
    }

}
