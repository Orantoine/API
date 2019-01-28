package fr.Orantoine.APIJAVA.models;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;

    public String firstName;

    public String lastName;

    public int year;

    public String pseudo;

    public String password;

    public boolean admin;


    public User(String id, String firstName, String lastName, int year, String pseudo, String password, boolean admin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.pseudo = pseudo;
        this.password = password;
        this.admin = admin;
    }


    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }
}
