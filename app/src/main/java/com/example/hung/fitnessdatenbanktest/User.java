package com.example.hung.fitnessdatenbanktest;

public class User {

    private String benutzerName;
    private int alter;
    private double gewicht;



    public User(String benutzerName,int alter, double gewicht){
        this.alter=alter;
        this.gewicht=gewicht;
        this.benutzerName=benutzerName;
    }


    public String getName() {
        return benutzerName;
    }

    public void setName(String benutzerName) {
        this.benutzerName = benutzerName;
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
        String output = "Name: "+benutzerName+ " Alter: "+alter+ " Gewicht: "+gewicht;
        return output;
    }
}
