package com.example.androidapp;

import org.json.JSONException;
import org.json.JSONObject;


import java.text.DecimalFormat;
import java.util.*;

public class Company {

    private boolean lastHasChanged;
    private String topic;
    private String pclose;
    private String lastvalue;

     String getTopic() {
        return topic;
    }

     String getPclose() {
        return pclose;
    }

     String getLastvalue() {
        return lastvalue;
    }

     boolean islastHasChanged() {
        return lastHasChanged;
    }

     void setlastHasChanged(boolean lastHasChanged) {
        this.lastHasChanged = lastHasChanged;
    }

    public Company(JSONObject messageJsonObject) throws JSONException {
        lastHasChanged = false;
        pclose = messageJsonObject.get("pclose").toString();
        topic =  messageJsonObject.get("topic").toString().substring(3, 7);
        lastvalue = checkNumericValue(messageJsonObject.get("lastvalue").toString());
    }

    public void updateCompany(JSONObject messageJsonObject) throws Exception {
        Iterator keys = messageJsonObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            switch (key) {

                case "lastvalue":
                    this.lastvalue = checkNumericValue(messageJsonObject.getString("lastvalue"));
                    break;

                case "pclose":
                    this.pclose = messageJsonObject.getString("pclose");
                    break;

                case "topic":
                    this.topic = messageJsonObject.getString("topic").substring(3, 7);
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

    public String checkNumericValue(String lastValue) {
        String value;
        if (!lastValue.equals("#")) {
            value = formatLastValue(lastValue);
        } else {
            value = lastValue;
        }
        return value;
    }

    public String formatLastValue(String formattedLastvalue) {
        String pattern = "###,###.###";
        DecimalFormat formatter = new DecimalFormat(pattern);
        double parseValue = Double.parseDouble(formattedLastvalue);
        formattedLastvalue = formatter.format(parseValue);
        return formattedLastvalue;

    }
}


