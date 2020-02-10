package org.example;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.net.URISyntaxException;

public class App
{

    public static void main( String[] args ) throws URISyntaxException {

           WebSocketClient webSocket = new WebSocketClient( new URI("wss://liveff01.tickerchart.net/streamhubws/")) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                this.send("034d4dc7-a9bc-412e-9051-c32605336923");
                this.send("QO.2010.TAD,QO.4180.TAD,QO.4061.TAD,QO.2140.TAD,QO.4130.TAD,QO.6070.TAD,QO.1120.TAD,QO.2170.TAD,QO.1080.TAD,QO.3010.TAD,QO.2210.TAD,QO.2200.TAD,QO.4150.TAD,QO.4080.TAD,QO.6060.TAD,QO.1020.TAD,QO.1050.TAD,QO.3080.TAD,QO.2180.TAD,QO.2100.TAD,QO.6090.TAD,QO.4190.TAD,QO.4100.TAD,QO.6010.TAD,QO.4160.TAD,QO.2080.TAD,QO.2090.TAD,QO.2060.TAD,QO.2220.TAD,QO.6020.TAD,QO.1010.TAD,QO.1090.TAD,QO.2120.TAD,QO.2020.TAD,QO.2030.TAD,QO.2160.TAD,QO.4050.TAD,QO.2110.TAD,QO.3030.TAD,QO.2040.TAD,QO.2230.TAD,QO.5110.TAD,QO.6050.TAD,QO.4010.TAD,QO.2130.TAD,QO.4140.TAD,QO.2250.TAD,QO.2190.TAD,QO.4110.TAD,QO.2070.TAD");

                System.out.println("socket is open....");
            }

            @Override
            public void onMessage(String s) {
                System.out.println(s);

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
