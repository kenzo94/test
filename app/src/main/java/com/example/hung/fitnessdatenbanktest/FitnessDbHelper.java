package com.example.hung.fitnessdatenbanktest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

public class FitnessDbHelper extends SQLiteOpenHelper{

    public static final String LOG = FitnessDbHelper.class.getSimpleName();
    public static final int DB_VERSION = 1;
    public static final String DB_NAME= "FitnessDB.db";



    public FitnessDbHelper(Context context) {
        super(context, DB_NAME , null, DB_VERSION);
        Log.d(LOG,"FitnessDBHelper hat die Datenbank: "+ getDatabaseName()+" erzeugt.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            Log.d(LOG,"Die Tabellen mit den Anweisungen "+DatabaseContract.User.SQL_CREATE+" werden erzeugt.");
            db.execSQL(DatabaseContract.User.SQL_CREATE);
        }catch(Exception e){
            Log.d(LOG,"Fehler beim Anlegen der Tabllen: "+e.getStackTrace()+
                    "  "+e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DatabaseContract.User.DELETE_TABLE);
        onCreate(db);

    }
}
