package fr.Orantoine.APIJAVA.models;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class Session {

    @Id
    public String id;

    public String token;

    public Date creation;

    public Date expirement;

    public User user;

    public Session(String id, String token, Date creation, Date expirement,User user) {
        this.id = id;
        this.token = token;
        this.creation = creation;
        this.expirement = expirement;
        this.user = user;
    }

    public Session() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getExpirement() {
        return expirement;
    }

    public void setExpirement(Date expirement) {
        this.expirement = expirement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                ", creation=" + creation +
                ", expirement=" + expirement +
                ", user=" + user +
                '}';
    }
}
