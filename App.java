package org.example;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;
import org.mortbay.util.ajax.JSON;
import java.net.URI;
import java.net.URISyntaxException;

public class App
{

    public static void main(String[] args ) throws URISyntaxException {

           WebSocketClient webSocket = new WebSocketClient( new URI("wss://liveff01.tickerchart.net/streamhubws/")) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {

                this.send("uid=034d4dc7-a9bc-412e-9051-c32605336934");
                this.send("subscribe=QO.2010.TAD,QO.4180.TAD,QO.4061.TAD,QO.2140.TAD,QO.4130.TAD,QO.6070.TAD,QO.1120.TAD,QO.2170.TAD,QO.1080.TAD,QO.3010.TAD,QO.2210.TAD,QO.2200.TAD,QO.4150.TAD,QO.4080.TAD,QO.6060.TAD,QO.1020.TAD,QO.1050.TAD,QO.3080.TAD,QO.2180.TAD,QO.2100.TAD,QO.6090.TAD,QO.4190.TAD,QO.4100.TAD,QO.6010.TAD,QO.4160.TAD,QO.2080.TAD,QO.2090.TAD,QO.2060.TAD,QO.2220.TAD,QO.6020.TAD,QO.1010.TAD,QO.1090.TAD,QO.2120.TAD,QO.2020.TAD,QO.2030.TAD,QO.2160.TAD,QO.4050.TAD,QO.2110.TAD,QO.3030.TAD,QO.2040.TAD,QO.2230.TAD,QO.5110.TAD,QO.6050.TAD,QO.4010.TAD,QO.2130.TAD,QO.4140.TAD,QO.2250.TAD,QO.2190.TAD,QO.4110.TAD,QO.2070.TAD");

                System.out.println("socket is open....");
            }

            @Override
            public void onMessage(String s) {

                // convert json string to json object

                JSONObject jsonObject = new JSONObject(s);

                // get values of keys from json object

                String date = jsonObject.getString("date");
                String askprice = jsonObject.getString("askprice");
                String gclose = jsonObject.getString("gclose");
                String change = jsonObject.getString("change");
                String gvolume = jsonObject.getString("gvolume");
                String gesi = jsonObject.getString("gesi");
                String last = jsonObject.getString("last");
                String dirction = jsonObject.getString("direction");
                String bidprice = jsonObject.getString("bidprice");
                String egi = jsonObject.getString("egi");
                String gpchange = jsonObject.getString("gpchange");
                String lastvolume = jsonObject.getString("lastvolume");
                String tbv = jsonObject.getString("tbv");
                String open = jsonObject.getString("open");
                String tav = jsonObject.getString("tav");
                String askvolume = jsonObject.getString("askvolume");
                String outflowers = jsonObject.getString("outflowers");
                String gchange = jsonObject.getString("gchange");
                String volume = jsonObject.getString("volume");
                String time = jsonObject.getString("time");
                String week52low = jsonObject.getString("week52low");
                String inflowvalue = jsonObject.getString("inflowvalue");
                String week52high = jsonObject.getString("week52high");
                String wsi = jsonObject.getString("wsi");
                String trades = jsonObject.getString("trades");
                String ipchange = jsonObject.getString("ipchange");
                String gegi = jsonObject.getString("gegi");
                String min = jsonObject.getString("min");
                String topic = jsonObject.getString("topic");
                String pchange = jsonObject.getString("pghange");
                String esi = jsonObject.getString("esi");
                String max = jsonObject.getString("max");
                String issnapshot = jsonObject.getString("issnapshot");
                String wgi = jsonObject.getString("wgi");
                String pclose = jsonObject.getString("pclose");
                String maxlv = jsonObject.getString("maxlv");
                String iclose = jsonObject.getString("iclose");
                String outflowvolume = jsonObject.getString("outflowvolume");
                String lastvalue = jsonObject.getString("lastvalue");
                String high = jsonObject.getString("high");
                String low = jsonObject.getString("low");
                String lasttradeprice = jsonObject.getString("lasttradeprice");
                String phigh = jsonObject.getString("phigh");
                String outfloworders = jsonObject.getString("outfloworders");

                // create object of class SaveData and send values to class , SaveData class saving values i got it from json object

                SaveData saveData = new  SaveData( date, askprice, gclose, change, gvolume, gesi, last, dirction, bidprice,
                         egi, gpchange, lastvolume,  tbv,  open, tav, askvolume, outflowers, gchange, volume, time,
                         week52low, inflowvalue,  week52high,  wsi, trades, ipchange, gegi, min, topic, pchange,
                         esi, max, issnapshot,  wgi, pclose, maxlv, iclose, outflowvolume, lastvalue, high, low,
                         lasttradeprice, phigh, outfloworders);

                // if you want update on specific value you can by setter and getter
                saveData.setAskprice("12:45"); // just example

                // then convert json from object to string
                JSON json = new JSON();
                String update = json.toJSON(saveData);

                // you can send it to server or printed
                this.send(update);
                System.out.println(update);



             /* JSON jj = new JSON();
                App obj = (App) jj.fromJSON(s);
                Map<String,Object> map = new HashMap();
                map.put("key","value");
                map.replace("key","oldvalue","newvalue"); //just to try
                for (String i : map.keySet()){
                map.replace("key","newvalue");
                }*/
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("socket is close....");
            }

            @Override
            public void onError(Exception e) {
                System.out.println("Error....");

            }
        };
        webSocket.connect();
    }


}
