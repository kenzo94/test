package com.example.hung.fitnessdatenbanktest.TabellenObjekte;

public class Benutzer {


    private String benutzername;
    private int id,alter;
    private double gewicht;



    public Benutzer(int id,String benutzername, int alter, double gewicht){
        this.id=id;
        this.alter=alter;
        this.gewicht=gewicht;
        this.benutzername=benutzername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }


    @Override
    public String toString() {
        String s = "->ID: "+id+" Benutzername: "+ benutzername+" Gewicht: "+gewicht+" Alter: "+
                alter;
        return s;
    }
}
