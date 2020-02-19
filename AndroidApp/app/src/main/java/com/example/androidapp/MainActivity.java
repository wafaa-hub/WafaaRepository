package com.example.androidapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ListView watchMarket;
    CompanyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        watchMarket = findViewById(R.id.watchmarket);

        adapter = new CompanyListAdapter(this, R.layout.listadapterview, new WebSocketEcho().list());
        watchMarket.setAdapter(adapter);


    }
}
