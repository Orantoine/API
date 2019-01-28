package fr.Orantoine.APIJAVA.models;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class Session {

    @Id
    public String id;

    public String token;

    public Date creation;

    public Date expirement;

    public String idUser;

    public Session(String id, String token, Date creation, Date expirement,String idUser) {
        this.id = id;
        this.token = token;
        this.creation = creation;
        this.expirement = expirement;
        this.idUser = idUser;
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

    public String getIdUser(){
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                ", creation=" + creation +
                ", expirement=" + expirement +
                ", idUser=" + idUser+
                '}';
    }
}
