package org.example;

import org.json.JSONObject;
import java.util.Iterator;

public class Company {

    public JSONObject obj;
    String date;
    String askprice;
    String gclose;
    String change;
    String gvolume;
    String gesi;
    String last;
    String direction;
    String bidprice;
    String egi;
    String gpchange;
    String lastvolume;
    String tbv;
    String open;
    String tav;
    String outflowers;
    String gchange;
    String volume;
    String time;
    String week52low;
    String inflowvalue;
    String week52high;
    String wsi;
    String trades;
    String ipchange;
    String gegi;
    String min;
    String topic;
    String pchange;
    String esi;
    String max;
    String issnapshot;
    String wgi;
    String pclose;
    String maxlv;
    String iclose;
    String outflowvolume;
    String lastvalue;
    String high;
    String low;
    String lasttradeprice;
    String phigh;
    String outfloworders;
    String askvolume;
    String plow;

    public Company() {
    }

    public Company(JSONObject obj) {

         this.obj = obj;
         date="";
         askprice="";
         gclose="";
         change ="";
         gvolume ="";
         gesi ="";
         last ="";
         direction ="";
         bidprice ="";
         egi = "";
         gpchange= "";
         lastvolume ="";
         tbv ="";
         open ="";
         tav ="";
         outflowers ="";
         gchange ="";
         volume ="";
         time ="";
         week52low ="";
         inflowvalue="";
         week52high="";
         wsi="";
         trades ="";
         ipchange ="";
         gegi = "";
         min ="";
         topic ="";
         pchange ="";
         esi ="";
         max ="";
         issnapshot ="";
         wgi ="";
         pclose ="";
         maxlv ="";
         iclose ="";
         outflowvolume ="";
         lastvalue ="";
         high ="";
         low ="";
         lasttradeprice ="";
         phigh ="";
         outfloworders ="";
         askvolume ="";
         plow ="";
    }

    @Override
    public String toString() {
        return "Company{" +
                "obj=" + obj +
                ", date='" + date + '\'' +
                ", askprice='" + askprice + '\'' +
                ", gclose='" + gclose + '\'' +
                ", change='" + change + '\'' +
                ", gvolume='" + gvolume + '\'' +
                ", gesi='" + gesi + '\'' +
                ", last='" + last + '\'' +
                ", direction='" + direction + '\'' +
                ", bidprice='" + bidprice + '\'' +
                ", egi='" + egi + '\'' +
                ", gpchange='" + gpchange + '\'' +
                ", lastvolume='" + lastvolume + '\'' +
                ", tbv='" + tbv + '\'' +
                ", open='" + open + '\'' +
                ", tav='" + tav + '\'' +
                ", outflowers='" + outflowers + '\'' +
                ", gchange='" + gchange + '\'' +
                ", volume='" + volume + '\'' +
                ", time='" + time + '\'' +
                ", week52low='" + week52low + '\'' +
                ", inflowvalue='" + inflowvalue + '\'' +
                ", week52high='" + week52high + '\'' +
                ", wsi='" + wsi + '\'' +
                ", trades='" + trades + '\'' +
                ", ipchange='" + ipchange + '\'' +
                ", gegi='" + gegi + '\'' +
                ", min='" + min + '\'' +
                ", topic='" + topic + '\'' +
                ", pchange='" + pchange + '\'' +
                ", esi='" + esi + '\'' +
                ", max='" + max + '\'' +
                ", issnapshot='" + issnapshot + '\'' +
                ", wgi='" + wgi + '\'' +
                ", pclose='" + pclose + '\'' +
                ", maxlv='" + maxlv + '\'' +
                ", iclose='" + iclose + '\'' +
                ", outflowvolume='" + outflowvolume + '\'' +
                ", lastvalue='" + lastvalue + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", lasttradeprice='" + lasttradeprice + '\'' +
                ", phigh='" + phigh + '\'' +
                ", outfloworders='" + outfloworders + '\'' +
                ", askvolume='" + askvolume + '\'' +
                ", plow='" + plow + '\'' +
                '}';
    }

    public JSONObject getObj() {
        return obj;
    }

    public void setObj(JSONObject obj) {
        this.obj = obj;
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

}
