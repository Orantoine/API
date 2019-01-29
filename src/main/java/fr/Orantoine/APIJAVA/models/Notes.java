package fr.Orantoine.APIJAVA.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Notes {

    @Id
    private String id;

    private Matter matter;

    private int note;

    private User user;

    private Date date;

    public Notes(String id, Matter matter, int note, User user, Date date) {
        this.id = id;
        this.matter = matter;
        this.note = note;
        this.user = user;
        this.date = date;
    }

    public Notes() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id='" + id + '\'' +
                ", matter=" + matter +
                ", note=" + note +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
