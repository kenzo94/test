package com.example.hung.fitnessdatenbanktest;

import android.provider.BaseColumns;

public class DatabaseContract {

    private DatabaseContract() {
    }


    //durch Basecolumns müssen wir keine IDs mehr vergeben

    //Usertabelle
    public static abstract class User implements BaseColumns {
        public static final String TBL_NAME = "User_Tabelle";
        public static final String BENUTZERNAME = "User_Benutzername";
        public static final String GEWICHT = "User_Gewicht";
        public static final String ALTER = "_Alter";

        public static final String SQL_CREATE =
                "CREATE TABLE " + TBL_NAME + "(" +
                        BENUTZERNAME + " TEXT PRIMARY KEY, " +
                        GEWICHT + " INTEGER, " +
                        ALTER + " INTEGER);";


        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TBL_NAME;
    }

    //Trainingtabelle
    public static class Training implements BaseColumns {
        public static final String TBL_NAME = " Training_Tabelle ";
        public static final String BENUTZERNAME = " User_Benutzername "; //FK
        public static final String GERAETE_ID = " Geräte_ID "; //FK
        public static final String BESCHREIBUNG = " Beschreibung ";
        public static final String KCAL = " Kcal ";
        public static final String DATUM = " Datum ";


        public static final String SQL_CREATE =
                " CREATE TABLE " + TBL_NAME + "(" +
                        Training._ID + " integer primary key autoincrement desc, " +
                        Training.BENUTZERNAME + " text, FOREIGN KEY( " + Training.BENUTZERNAME +
                        " ) REFERENCES " + User.TBL_NAME + " ( " + User.BENUTZERNAME + " )" +
                        " ON DELETE CASCADE ON UPDATE CASCADE, " +
                        BESCHREIBUNG + " text, " +
                        GERAETE_ID + " integer, FOREIGN KEY( " + GERAETE_ID + " ) REFERENCES " +
                        Geraet.TBL_NAME + " ( " + Geraet._ID + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                        KCAL + " double, " + //REAL
                        DATUM + " text not null);";


        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TBL_NAME;
    }

    //Trainingszieltabelle
    public static class Trainingsziel implements BaseColumns {
        public static final String TBL_NAME = " Trainingsziel Tabelle ";
        public static final String TRAINING_ID = " Training_ID "; //FK
        public static final String GERAET_NAME = " Gerätname ";
        public static final String SOLL_GEWICHT = " Sollgewicht ";
        public static final String SOLL_DAUER = " Solldauer_in_Min. ";
        public static final String SOLL_GESCHW = " Sollgeschwindigkeit_in_Km/H ";

        public static final String SQL_CREATE =
                "CREATE TABLE " + TBL_NAME + "("
                        + Trainingsziel._ID + " integer primary key autouncrement desc, "
                        + Trainingsziel.TRAINING_ID + " integer, FOREIGN KEY ( " + Trainingsziel.TRAINING_ID
                        + ") REFERENCES " + Training.TBL_NAME + " (" + Training._ID + ")" +
                        " ON DELETE CASCADE ON UPDATE CASCADE, "
                        + GERAET_NAME + " text not null," +
                        SOLL_GEWICHT + " double, " +
                        SOLL_DAUER + " integer, " +
                        SOLL_GESCHW + " double);";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TBL_NAME;
    }

    //Gerätetabelle
    public static class Geraet implements BaseColumns {
        public static final String TBL_NAME = " Gerät Tabelle ";
        public static final String NAME = " Gerätname ";
        public static final String TYP = " Gerät_Typ ";
        public static final String GESCHW = " Geschwindigkeit ";
        public static final String DAUER = " Dauer ";
        public static final String POSITION = " Position ";
        public static final String GEWICHT = " Gewicht ";


        public static final String SQL_CREATE =
                "CREATE TABLE" + TBL_NAME + "(" +
                        Geraet._ID + " integer primary key autoincrement desc, " +
                        NAME + " text not null, " +
                        TYP + " text not null, " +
                        DAUER + " text, " +
                        GESCHW + " text," +
                        GEWICHT + " " +
                        POSITION + " text); ";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TBL_NAME;


    }

    public static class Satz implements BaseColumns {

        public static final String TBL_NAME = " Satz";
        public static final String NR = " Satznummer";
        public static final String GEWICHT = " Satzgewicht";
        public static final String GERAET_ID = "Gerät_ID";

        public static final String SQL_CREATE =
                "CREATE TABLE " + TBL_NAME + " ( " +
                        Satz._ID + " integer primary key autoincrement desc," +
                        Satz.GERAET_ID + " integer, FOREIGN KEY ( " + Satz.GERAET_ID + ") REFERENCES " +
                        Geraet.TBL_NAME + " (" + Geraet._ID + ") ON DELETE CASCADE ON UPDATE CASCADE, " +
                        NR + " integer not null, " +
                        GEWICHT + " double not null);";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TBL_NAME;

    }
}

    /*public static final String[] SQL_CREATE_TABLE_ARRAY = {
            User.SQL_CREATE,
            Training.SQL_CREATE,
            Geraet.SQL_CREATE,
            Trainingsziel.SQL_CREATE,
            Satz.SQL_CREATE
    };

    public  static final String[] SQL_DELETE_TABLE_ARRAY ={
            User.DELETE_TABLE,
            Training.DELETE_TABLE,
            Geraet.DELETE_TABLE,
            Trainingsziel.DELETE_TABLE,
            Satz.DELETE_TABLE
    };*/


