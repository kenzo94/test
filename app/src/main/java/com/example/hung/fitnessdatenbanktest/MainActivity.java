package com.example.hung.fitnessdatenbanktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hung.fitnessdatenbanktest.Datenbank.BenutzerData;
import com.example.hung.fitnessdatenbanktest.TabellenObjekte.Benutzer;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = MainActivity.class.getSimpleName();
    private BenutzerData benutzerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        benutzerData = new BenutzerData(this);

        Log.d(LOG, "Die Datenquelle wird geöffnet.");
        benutzerData.open();

        Benutzer benutzer= benutzerData.createBenutzer("king",60
        ,20);
        Log.d(LOG,"folgender Eintrag in der Datenbank");
        Log.d(LOG,"Inhalt: "+benutzer.toString());


        Log.d(LOG, "Die Datenquelle wird geschlossen.");
        benutzerData.close();



    }
}
