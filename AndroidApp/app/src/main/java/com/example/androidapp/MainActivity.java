package com.example.androidapp;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class MainActivity extends AppCompatActivity {


    ListView watchMarket;
    private CompanyListAdapter adapter;
    private Map<String, Company> map = new HashMap();
    private ArrayList<Company> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        watchMarket = findViewById(R.id.watchmarket);
        adapter = new CompanyListAdapter(this, R.layout.listadapterview, arrayList);
        webSocket();
        watchMarket.setAdapter(adapter);
    }

    public void webSocket() {

        OkHttpClient client = new OkHttpClient();
        Request requestCoinPrice = new Request.Builder().url("wss://liveff01.tickerchart.net/streamhubws/").build();

        WebSocketListener webSocketListener = new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                System.out.println("on open.....");
                webSocket.send("uid=034d4dc7-a9bc-412e-9051-c32605336934");
                webSocket.send("subscribe=QO.2010.TAD,QO.4180.TAD,QO.4061.TAD,QO.2140.TAD,QO.4130.TAD,QO.6070.TAD,QO.1120.TAD,QO.2170.TAD,QO.1080.TAD,QO.3010.TAD,QO.2210.TAD,QO.2200.TAD,QO.4150.TAD,QO.4080.TAD,QO.6060.TAD,QO.1020.TAD,QO.1050.TAD,QO.3080.TAD,QO.2180.TAD,QO.2100.TAD,QO.6090.TAD,QO.4190.TAD,QO.4100.TAD,QO.6010.TAD,QO.4160.TAD,QO.2080.TAD,QO.2090.TAD,QO.2060.TAD,QO.2220.TAD,QO.6020.TAD,QO.1010.TAD,QO.1090.TAD,QO.2120.TAD,QO.2020.TAD,QO.2030.TAD,QO.2160.TAD,QO.4050.TAD,QO.2110.TAD,QO.3030.TAD,QO.2040.TAD,QO.2230.TAD,QO.5110.TAD,QO.6050.TAD,QO.4010.TAD,QO.2130.TAD,QO.4140.TAD,QO.2250.TAD,QO.2190.TAD,QO.4110.TAD,QO.2070.TAD");

            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                System.out.println(text);
                final JSONObject jsonObject;
                boolean flag = false;

                try {
                    jsonObject = new JSONObject(text);

                    if (map.containsKey(jsonObject.getString("topic"))) {
                        map.get(jsonObject.getString("topic")).update(jsonObject);
                        flag = true;
                        adapter.Flag(flag);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });

                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    map.put(jsonObject.getString("topic"), new Company(jsonObject));
                                    arrayList.add(new Company(jsonObject));
                                    adapter.notifyDataSetChanged();

                                } catch (JSONException e) {
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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

        client.newWebSocket(requestCoinPrice, webSocketListener);
        client.dispatcher().executorService().shutdown();
    }
}
