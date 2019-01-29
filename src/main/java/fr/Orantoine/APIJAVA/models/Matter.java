package fr.Orantoine.APIJAVA.models;

import org.springframework.data.annotation.Id;

public class Matter {

    @Id
    private String id;

    private String name;

    private int annee;

    private int ue;

    private int coef;

    private boolean valid;

    public Matter(String id, String name, int annee, int ue, int coef, boolean valid) {
        this.id = id;
        this.name = name;
        this.annee = annee;
        this.ue = ue;
        this.coef = coef;
        this.valid = valid;
    }

    public Matter() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getUe() {
        return ue;
    }

    public void setUe(int ue) {
        this.ue = ue;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Matter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", annee=" + annee +
                ", ue=" + ue +
                ", coef=" + coef +
                ", valid=" + valid +
                '}';
    }

}
