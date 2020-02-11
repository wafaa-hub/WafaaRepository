package org.example;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void main(String[] args ) throws URISyntaxException {


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

                Map<String,Object> map = new HashMap<>();
                map.put(jsonObject.getString("topic"), new Company(jsonObject));
                String newVal ="987987";
                try {

                if (map.containsKey("topic")) {

                    switch(jsonObject.keys().toString())
                    {
                        case "date" :
                            new Company().update("date", newVal);
                            break;
                        case "askprice" :
                            new Company().update("askprice", newVal);
                            break;
                        case "gclose" :
                            new Company().update("gclose", newVal);
                            break;
                        case "change" :
                            new Company().update("change", newVal);
                            break;
                        case "gesi" :
                            new Company().update("gesi", newVal);
                            break;
                        case "last" :
                            new Company().update("last", newVal);
                            break;
                        case "direction" :
                            new Company().update("direction", newVal);
                            break;
                        case "bidprice" :
                            new Company().update("bidprice", newVal);
                            break;
                        case "egi" :
                            new Company().update("egi", newVal);
                            break;
                        case "gpchange" :
                            new Company().update("gpchange", newVal);
                            break;
                        case "gvolume" :
                            new Company().update("gvolume", newVal);
                            break;
                        case "tbv" :
                            new Company().update(" tbv", newVal);
                            break;
                        case "open" :
                            new Company().update("open", newVal);
                            break;
                        case "tav" :
                            new Company().update("tav", newVal);
                            break;
                        case "askvolume" :
                            new Company().update("askvolume", newVal);
                            break;
                        case "outflowers" :
                            new Company().update("outflowers", newVal);
                            break;
                        case "gchange" :
                            new Company().update("gchange", newVal);
                            break;
                        case "volume" :
                            new Company().update("volume", newVal);
                            break;
                        case "time" :
                            new Company().update("time", newVal);
                            break;
                        case "week52low" :
                            new Company().update("week52low", newVal);
                            break;
                        case "inflowvalue" :
                            new Company().update("inflowvalue", newVal);
                            break;
                        case "week52high" :
                            new Company().update("week52high", newVal);
                            break;
                        case "wsi" :
                            new Company().update("wsi", newVal);
                            break;
                        case "trades" :
                            new Company().update("trades", newVal);
                            break;
                        case "ipchange" :
                            new Company().update("ipchange", newVal);
                            break;
                        case "gegi" :
                            new Company().update("gegi", newVal);
                            break;
                        case "min" :
                            new Company().update("min", newVal);
                            break;
                        case "pchange" :
                            new Company().update("pchange", newVal);
                            break;
                        case "esi" :
                            new Company().update("esi", newVal);
                            break;
                        case "max" :
                            new Company().update("max", newVal);
                            break;
                        case "issnapshot" :
                            new Company().update("issnapshot", newVal);
                            break;
                        case "wgi" :
                            new Company().update("wgi", newVal);
                            break;
                        case "pclose" :
                            new Company().update("pclose", newVal);
                            break;
                        case "maxlv" :
                            new Company().update("maxlv", newVal);
                            break;
                        case "iclose" :
                            new Company().update("iclose", newVal);
                            break;
                        case "outflowvolume" :
                            new Company().update("outflowvolume", newVal);
                            break;
                        case "lastvalue" :
                            new Company().update("lastvalue", newVal);
                            break;
                        case "high" :
                            new Company().update("high", newVal);
                            break;
                        case "low" :
                            new Company().update("low", newVal);
                            break;
                        case "lasttradeprice" :
                            new Company().update("lasttradeprice", newVal);
                            break;
                        case "phigh" :
                            new Company().update("phigh", newVal);
                            break;
                        case "outfloworders" :
                            new Company().update("outfloworders", newVal);
                            break;

                    }

                }
                else {
                    map.put(jsonObject.getString("topic"), new Company(jsonObject));

                }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }

             }

                @Override
                public void onClose ( int i, String s,boolean b){
                    System.out.println("socket is close....");
                }

                @Override
                public void onError (Exception e){

                }
            };
                webSocket.connect();

        }



}
