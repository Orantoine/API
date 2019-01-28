package fr.Orantoine.APIJAVA.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Movie {

    @Id
    private String id;

    private String title;

    private String[] actors;

    private Date production;

    private float note;

    public Movie(String id, String title, String[] actors, Date production, float note) {
        this.id = id;
        this.title = title;
        this.actors = actors;
        this.production = production;
        this.note = note;
    }

    public Movie() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public Date getProduction() {
        return production;
    }

    public void setProduction(Date production) {
        this.production = production;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }


}
