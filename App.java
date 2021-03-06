package org.example;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.Comparator;

public class App {
    private static Map<String, Company> map;

    public static void main(String[] args) throws URISyntaxException {
        map = new HashMap<>();


        WebSocketClient webSocket = new WebSocketClient(new URI("wss://liveff01.tickerchart.net/streamhubws/")) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                this.send("uid=034d4dc7-a9bc-412e-9051-c32605336934");
                this.send("subscribe=QO.2010.TAD,QO.4180.TAD,QO.4061.TAD,QO.2140.TAD,QO.4130.TAD,QO.6070.TAD,QO.1120.TAD,QO.2170.TAD,QO.1080.TAD,QO.3010.TAD,QO.2210.TAD,QO.2200.TAD,QO.4150.TAD,QO.4080.TAD,QO.6060.TAD,QO.1020.TAD,QO.1050.TAD,QO.3080.TAD,QO.2180.TAD,QO.2100.TAD,QO.6090.TAD,QO.4190.TAD,QO.4100.TAD,QO.6010.TAD,QO.4160.TAD,QO.2080.TAD,QO.2090.TAD,QO.2060.TAD,QO.2220.TAD,QO.6020.TAD,QO.1010.TAD,QO.1090.TAD,QO.2120.TAD,QO.2020.TAD,QO.2030.TAD,QO.2160.TAD,QO.4050.TAD,QO.2110.TAD,QO.3030.TAD,QO.2040.TAD,QO.2230.TAD,QO.5110.TAD,QO.6050.TAD,QO.4010.TAD,QO.2130.TAD,QO.4140.TAD,QO.2250.TAD,QO.2190.TAD,QO.4110.TAD,QO.2070.TAD");
                System.out.println("socket is open....");
            }

            @Override
            public void onMessage(String s) {

                JSONObject jsonObject = new JSONObject(s);
                try {
                    if (map.containsKey(jsonObject.getString("topic"))) {
                        map.get(jsonObject.getString("topic")).update(jsonObject);
                    } else {
                        map.put(jsonObject.getString("topic"), new Company(jsonObject));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                List<Map.Entry<String, Company>> list = new ArrayList<>(map.entrySet());
                

               Collections.sort(list, new Comparator<Map.Entry<String, Company>>() {
                    @Override
                    public int compare(Map.Entry<String, Company> t, Map.Entry<String, Company> t1) {
                        return t.getValue().change.compareTo(t1.getValue().change);

                    }
                });

               // System.out.println(list);

            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("socket is close....");
            }

            @Override
            public void onError(Exception e) {

            }
        };
        webSocket.connect();

    }


}
