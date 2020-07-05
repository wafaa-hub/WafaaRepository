package com.example.androidapp;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class MainActivity extends AppCompatActivity {

    private ListView               marketWatch;
    private Toolbar                toolbar;
    private CompanyListViewAdapter companyListViewAdapter;
    private Map<String, Company>   mapOfCompanies =   new HashMap();
    private ArrayList<Company>     companies =        new ArrayList<>();
    final   String                 url =             "wss://liveff01.tickerchart.net/streamhubws/";
    final   String                 uid =             "uid=034d4dc7-a9bc-412e-9051-c32605336934";
    final   String                 subscribe =       "subscribe=QO.2010.TAD,QO.4180.TAD,QO.4061.TAD,QO.2140.TAD,QO.4130.TAD,QO.6070.TAD,QO.1120.TAD,QO.2170.TAD,QO.1080.TAD,QO.3010.TAD,QO.2210.TAD,QO.2200.TAD,QO.4150.TAD,QO.4080.TAD,QO.6060.TAD,QO.1020.TAD,QO.1050.TAD,QO.3080.TAD,QO.2180.TAD,QO.2100.TAD,QO.6090.TAD,QO.4190.TAD,QO.4100.TAD,QO.6010.TAD,QO.4160.TAD,QO.2080.TAD,QO.2090.TAD,QO.2060.TAD,QO.2220.TAD,QO.6020.TAD,QO.1010.TAD,QO.1090.TAD,QO.2120.TAD,QO.2020.TAD,QO.2030.TAD,QO.2160.TAD,QO.4050.TAD,QO.2110.TAD,QO.3030.TAD,QO.2040.TAD,QO.2230.TAD,QO.5110.TAD,QO.6050.TAD,QO.4010.TAD,QO.2130.TAD,QO.4140.TAD,QO.2250.TAD,QO.2190.TAD,QO.4110.TAD,QO.2070.TAD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marketWatch =             findViewById(R.id.watchmarket);
        toolbar =                 findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        companyListViewAdapter =  new CompanyListViewAdapter(this, R.layout.listadapterview, companies);
        openWebSocket();
        marketWatch.setAdapter(companyListViewAdapter);
    }

    public void openWebSocket() {
        OkHttpClient okHttpClient =           new OkHttpClient();
        Request request =                     new Request
                                              .Builder()
                                              .url(url)
                                              .build();
        WebSocketListener webSocketListener = new WebSocketListener() {

            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                System.out.println("on open.....");
                webSocket.send(uid);
                webSocket.send(subscribe);
            }

            @Override
            public void onMessage(WebSocket webSocket, String message) {
                System.out.println(message);
                final JSONObject messageJsonObject;

                      try {
                          messageJsonObject = new JSONObject(message);
                          String key =        "topic";

                        if (mapOfCompanies.containsKey(messageJsonObject.getString(key))) {
                          final Company company = mapOfCompanies.get(messageJsonObject.getString(key));
                          company.updateCompany(messageJsonObject);

                          if(messageJsonObject.has("last")){
                               company.setlastHasChanged(true);
                          }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                companyListViewAdapter.notifyDataSetChanged();
                            }
                        });
                       } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Company newCompany = new Company(messageJsonObject);
                                    mapOfCompanies.put(messageJsonObject.getString("topic"), newCompany);
                                    companies.add(newCompany);
                                    companyListViewAdapter.notifyDataSetChanged();

                                } catch (JSONException e) { }
                            }
                        });
                      }
                      } catch (Exception e) {
                          throw new RuntimeException(e);
                      }
            }

            @Override
            public void onClosing(WebSocket webSocket, int code, String reason) {
                webSocket.close(1000, null);
                webSocket.cancel();
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {

            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {

            }
        };

        okHttpClient.newWebSocket(request, webSocketListener);
        okHttpClient.dispatcher().executorService().shutdown();
    }
}
