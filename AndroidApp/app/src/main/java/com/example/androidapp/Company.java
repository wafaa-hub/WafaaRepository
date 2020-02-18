package com.example.androidapp;
import org.json.JSONObject;


import java.util.*;

public class Company {

    public JSONObject jsonObject;
    public String date;
    public String askprice;
    public String gclose;
    public String change;
    public String gvolume;
    public String gesi;
    public String last;
    public String direction;
    public String bidprice;
    public String egi;
    public String gpchange;
    public String lastvolume;
    public String tbv;
    public String open;
    public String tav;
    public String outflowers;
    public String gchange;
    public String volume;
    public String time;
    public String week52low;
    public String inflowvalue;
    public String week52high;
    public String wsi;
    public String trades;
    public String ipchange;
    public String gegi;
    public String min;
    public String topic;
    public String pchange;
    public String esi;
    public String max;
    public String issnapshot;
    public String wgi;
    public String pclose;
    public String maxlv;
    public String iclose;
    public String outflowvolume;
    public String lastvalue;
    public String high;
    public String low;
    public String lasttradeprice;
    public String phigh;
    public String outfloworders;
    public String askvolume;
    public String plow;


    public Company(JSONObject jsonObject) {

        this.jsonObject = jsonObject;
        date = "";
        askprice = "";
        gclose = "";
        change = "";
        gvolume = "";
        gesi = "";
        last = "";
        direction = "";
        bidprice = "";
        egi = "";
        gpchange = "";
        lastvolume = "";
        tbv = "";
        open = "";
        tav = "";
        outflowers = "";
        gchange = "";
        volume = "";
        time = "";
        week52low = "";
        inflowvalue = "";
        week52high = "";
        wsi = "";
        trades = "";
        ipchange = "";
        gegi = "";
        min = "";
        topic = "";
        pchange = "";
        esi = "";
        max = "";
        issnapshot = "";
        wgi = "";
        pclose = "";
        maxlv = "";
        iclose = "";
        outflowvolume = "";
        lastvalue = "";
        high = "";
        low = "";
        lasttradeprice = "";
        phigh = "";
        outfloworders = "";
        askvolume = "";
        plow = "";
    }

    public JSONObject update(JSONObject jsonObject) throws Exception {

        Iterator keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            switch (key) {
                case "date":
                    this.date = jsonObject.getString("date");
                    break;
                case "askprice":
                    this.askprice = jsonObject.getString("askprice");
                    break;
                case "gclose":
                    this.gclose = jsonObject.getString("gclose");
                    break;
                case "change":
                    this.change = jsonObject.getString("change");
                    break;
                case "gesi":
                    this.gesi = jsonObject.getString("gesi");
                    break;
                case "last":
                    this.last = jsonObject.getString("last");
                    break;
                case "direction":
                    this.direction = jsonObject.getString("direction");
                    break;
                case "bidprice":
                    this.bidprice = jsonObject.getString("bidprice");
                    break;
                case "egi":
                    this.egi = jsonObject.getString("egi");
                    break;
                case "gpchange":
                    this.gpchange = jsonObject.getString("gpchange");
                    break;
                case "gvolume":
                    this.gvolume = jsonObject.getString("gvolume");
                    break;
                case "tbv":
                    this.tbv = jsonObject.getString("tbv");
                    break;
                case "open":
                    this.open = jsonObject.getString("open");
                    break;
                case "tav":
                    this.tav = jsonObject.getString("tav");
                    break;
                case "askvolume":
                    this.askvolume = jsonObject.getString("askvolume");
                    break;
                case "outflowers":
                    this.outflowers = jsonObject.getString("outflowers");
                    break;
                case "gchange":
                    this.gchange = jsonObject.getString("gchange");
                    break;
                case "volume":
                    this.volume = jsonObject.getString("volume");
                    break;
                case "time":
                    this.time = jsonObject.getString("time");
                    break;
                case "week52low":
                    this.week52low = jsonObject.getString("week52low");
                    break;
                case "inflowvalue":
                    this.inflowvalue = jsonObject.getString("inflowvalue");
                    break;
                case "week52high":
                    this.week52high = jsonObject.getString("week52high");
                    break;
                case "wsi":
                    this.wsi = jsonObject.getString("wsi");
                    break;
                case "trades":
                    this.trades = jsonObject.getString("trades");
                    break;
                case "ipchange":
                    this.ipchange = jsonObject.getString("ipchange");
                    break;
                case "gegi":
                    this.gegi = jsonObject.getString("gegi");
                    break;
                case "min":
                    this.min = jsonObject.getString("min");
                    break;
                case "pchange":
                    this.pchange = jsonObject.getString("pchange");
                    break;
                case "esi":
                    this.esi = jsonObject.getString("esi");
                    break;
                case "max":
                    this.max = jsonObject.getString("max");
                    break;
                case "issnapshot":
                    this.issnapshot = jsonObject.getString("issnapshot");
                    break;
                case "wgi":
                    this.wgi = jsonObject.getString("wgi");
                    break;
                case "pclose":
                    this.pclose = jsonObject.getString("pclose");
                    break;
                case "maxlv":
                    this.maxlv = jsonObject.getString("maxlv");
                    break;
                case "iclose":
                    this.iclose = jsonObject.getString("iclose");
                    break;
                case "outflowvolume":
                    this.outflowvolume = jsonObject.getString("outflowvolume");
                    break;
                case "lastvalue":
                    this.lastvalue = jsonObject.getString("lastvalue");
                    break;
                case "high":
                    this.high = jsonObject.getString("high");
                    break;
                case "low":
                    this.low = jsonObject.getString("low");
                    break;
                case "lasttradeprice":
                    this.lasttradeprice = jsonObject.getString("lasttradeprice");
                    break;
                case "phigh":
                    this.phigh = jsonObject.getString("phigh");
                    break;
                case "outfloworders":
                    this.outfloworders = jsonObject.getString("outfloworders");
                    break;
                case "plow":
                    this.plow = jsonObject.getString("plow");
                    break;
            }
        }
        return jsonObject;

    }

    @Override
    public String toString() {
        return "Company{" +
                "topic='" + topic + '\'' +
                '}';
    }


}
