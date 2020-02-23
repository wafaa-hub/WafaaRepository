package com.example.androidapp;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.*;

public class Company {

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    private JSONObject jsonObject;
    private String date;
    private String askprice;
    private String gclose;
    private String change;
    private String gvolume;
    private String gesi;
    private String last;
    private String direction;
    private String bidprice;
    private String egi;
    private String gpchange;
    private String lastvolume;
    private String tbv;
    private String open;
    private String tav;
    private String gchange;
    private String volume;
    private String time;
    private String week52low;
    private String inflowvalue;
    private String week52high;
    private String wsi;
    private String trades;
    private String ipchange;
    private String gegi;
    private String min;
    private String topic;
    private String pchange;
    private String esi;
    private String max;
    private String issnapshot;
    private String wgi;
    private String pclose;
    private String maxlv;
    private String iclose;
    private String outflowvolume;
    private String lastvalue;
    private String high;
    private String low;
    private String lasttradeprice;
    private String phigh;
    private String outfloworders;
    private String askvolume;
    private String plow;

    public String getDate() {
        return date;
    }

    public String getAskprice() {
        return askprice;
    }

    public String getGclose() {
        return gclose;
    }

    public String getChange() {
        return change;
    }

    public String getGvolume() {
        return gvolume;
    }

    public String getGesi() {
        return gesi;
    }

    public String getLast() {
        return last;
    }

    public String getDirection() {
        return direction;
    }

    public String getBidprice() {
        return bidprice;
    }

    public String getEgi() {
        return egi;
    }

    public String getGpchange() {
        return gpchange;
    }

    public String getLastvolume() {
        return lastvolume;
    }

    public String getTbv() {
        return tbv;
    }

    public String getOpen() {
        return open;
    }

    public String getTav() {
        return tav;
    }

    public String getGchange() {
        return gchange;
    }

    public String getVolume() {
        return volume;
    }

    public String getTime() {
        return time;
    }

    public String getWeek52low() {
        return week52low;
    }

    public String getInflowvalue() {
        return inflowvalue;
    }

    public String getWeek52high() {
        return week52high;
    }

    public String getWsi() {
        return wsi;
    }

    public String getTrades() {
        return trades;
    }

    public String getIpchange() {
        return ipchange;
    }

    public String getGegi() {
        return gegi;
    }

    public String getMin() {
        return min;
    }

    public String getTopic() {
        return topic;
    }

    public String getPchange() {
        return pchange;
    }

    public String getEsi() {
        return esi;
    }

    public String getMax() {
        return max;
    }

    public String getIssnapshot() {
        return issnapshot;
    }

    public String getWgi() {
        return wgi;
    }

    public String getPclose() {
        return pclose;
    }

    public String getMaxlv() {
        return maxlv;
    }

    public String getIclose() {
        return iclose;
    }

    public String getOutflowvolume() {
        return outflowvolume;
    }

    public String getLastvalue() {
        return lastvalue;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getLasttradeprice() {
        return lasttradeprice;
    }

    public String getPhigh() {
        return phigh;
    }

    public String getOutfloworders() {
        return outfloworders;
    }

    public String getAskvolume() {
        return askvolume;
    }

    public String getPlow() {
        return plow;
    }

    public Company(JSONObject jsonObject) throws JSONException {

        this.jsonObject = jsonObject;
        date = jsonObject.get("date").toString();
        askprice = jsonObject.get("askprice").toString();
        gclose = jsonObject.get("gclose").toString();
        change = jsonObject.get("change").toString();
        gvolume = jsonObject.get("gvolume").toString();
        gesi = jsonObject.get("gesi").toString();
        last = jsonObject.get("last").toString();
        direction = jsonObject.get("direction").toString();
        bidprice = jsonObject.get("bidprice").toString();
        egi = jsonObject.get("egi").toString();
        gpchange = jsonObject.get("gpchange").toString();
        lastvolume = jsonObject.get("lastvolume").toString();
        tbv = jsonObject.get("tbv").toString();
        open = jsonObject.get("open").toString();
        tav = jsonObject.get("tav").toString();
        gchange = jsonObject.get("gchange").toString();
        volume = jsonObject.get("volume").toString();
        time = jsonObject.get("time").toString();
        week52low = jsonObject.get("week52low").toString();
        inflowvalue = jsonObject.get("inflowvalue").toString();
        week52high = jsonObject.get("week52high").toString();
        wsi = jsonObject.get("wsi").toString();
        trades = jsonObject.get("trades").toString();
        ipchange = jsonObject.get("ipchange").toString();
        gegi = jsonObject.get("gegi").toString();
        min = jsonObject.get("min").toString();
        topic = jsonObject.get("topic").toString();
        pchange = jsonObject.get("pchange").toString();
        esi = jsonObject.get("esi").toString();
        max = jsonObject.get("max").toString();
        issnapshot = jsonObject.get("issnapshot").toString();
        wgi = jsonObject.get("wgi").toString();
        pclose = jsonObject.get("pclose").toString();
        maxlv = jsonObject.get("maxlv").toString();
        iclose = jsonObject.get("iclose").toString();
        outflowvolume = jsonObject.get("outflowvolume").toString();
        lastvalue = jsonObject.get("lastvalue").toString();
        high = jsonObject.get("high").toString();
        low = jsonObject.get("low").toString();
        lasttradeprice = jsonObject.get("lasttradeprice").toString();
        phigh = jsonObject.get("phigh").toString();
        outfloworders = jsonObject.get("outfloworders").toString();
        askvolume = jsonObject.get("askvolume").toString();
        plow = jsonObject.get("plow").toString();
    }

    public void update(JSONObject jsonObject) throws Exception {
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

    }

    @Override
    public String toString() {
        return "Company{" +
                "topic='" + topic + '\'' +
                '}';
    }
}
