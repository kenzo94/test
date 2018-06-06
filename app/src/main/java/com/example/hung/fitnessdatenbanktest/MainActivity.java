package com.example.hung.fitnessdatenbanktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = MainActivity.class.getSimpleName();
    private UserDataSource userDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        User testuser = new User("kenzo94",23,70);
        Log.d(LOG,"Inhalt vom Test user: "+ testuser.toString());

        userDataSource = new UserDataSource(this);

        Log.d(LOG, "Die Datenquelle wird geöffnet.");
        userDataSource.open();

        Log.d(LOG, "Die Datenquelle wird geschlossen.");
        userDataSource.close();

    }
}
