package com.example.androidapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tech.gusavila92.websocketclient.WebSocketClient;


public class MainActivity extends AppCompatActivity {
    private static Map<String, Company> map;
    private static ArrayList<MarketWatchData> arrayList = new ArrayList<>();

    public static ListView watchMarket;
    public static CompanyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewlistcontent);


        map = new HashMap();
        watchMarket = findViewById(R.id.watchmarket);
        adapter = new CompanyListAdapter(this, R.layout.listadapterview, arrayList);
        watchMarket.setAdapter(adapter);

        URI uri;
        try {
            uri = new URI("wss://liveff01.tickerchart.net/streamhubws/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        WebSocketClient webSocket = new WebSocketClient(uri) {
            @Override
            public void onOpen() {

                this.send("uid=034d4dc7-a9bc-412e-9051-c32605336934");
                this.send("subscribe=QO.2010.TAD,QO.4180.TAD,QO.4061.TAD,QO.2140.TAD,QO.4130.TAD,QO.6070.TAD,QO.1120.TAD,QO.2170.TAD,QO.1080.TAD,QO.3010.TAD,QO.2210.TAD,QO.2200.TAD,QO.4150.TAD,QO.4080.TAD,QO.6060.TAD,QO.1020.TAD,QO.1050.TAD,QO.3080.TAD,QO.2180.TAD,QO.2100.TAD,QO.6090.TAD,QO.4190.TAD,QO.4100.TAD,QO.6010.TAD,QO.4160.TAD,QO.2080.TAD,QO.2090.TAD,QO.2060.TAD,QO.2220.TAD,QO.6020.TAD,QO.1010.TAD,QO.1090.TAD,QO.2120.TAD,QO.2020.TAD,QO.2030.TAD,QO.2160.TAD,QO.4050.TAD,QO.2110.TAD,QO.3030.TAD,QO.2040.TAD,QO.2230.TAD,QO.5110.TAD,QO.6050.TAD,QO.4010.TAD,QO.2130.TAD,QO.4140.TAD,QO.2250.TAD,QO.2190.TAD,QO.4110.TAD,QO.2070.TAD");
                System.out.println("socket is open....");
            }

            @Override
            public void onTextReceived(String message) {

                JSONObject jsonObject = null;

                try {
                    jsonObject = new JSONObject(message);

                    if (map.containsKey(jsonObject.getString("topic"))) {
                        map.get(jsonObject.getString("topic")).update(jsonObject);
                    } else {
                        map.put(jsonObject.getString("topic"), new Company(jsonObject));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

               // List<Map.Entry<String, Company>> list = new ArrayList<>(map.entrySet());
                Map.Entry<String, Company> m = new Map.Entry<String, Company>() {
                    @Override
                    public String getKey() {
                        return null;
                    }

                    @Override
                    public Company getValue() {
                        return null;
                    }

                    @Override
                    public Company setValue(Company value) {
                        return null;
                    }
                };

                MarketWatchData marketWatchData = new MarketWatchData(m.getValue().topic, m.getValue().gclose, m.getValue().lastvalue);
                arrayList.add(marketWatchData);

            }

            @Override
            public void onBinaryReceived(byte[] data) {

            }

            @Override
            public void onPingReceived(byte[] data) {

            }

            @Override
            public void onPongReceived(byte[] data) {

            }

            @Override
            public void onException(Exception e) {

            }

            @Override
            public void onCloseReceived() {
                System.out.println("socket is close....");

            }

        };
        webSocket.connect();


    }


}
