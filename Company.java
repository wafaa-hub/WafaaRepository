package org.example;

import org.json.JSONObject;
import java.util.Iterator;

public class Company {

    JSONObject obj;

    public Company() {
    }

    public Company(JSONObject obj) {

        this.obj=obj;
    }
    public JSONObject getObj() {
        return obj;
    }

    public void setObj(JSONObject obj) {
        this.obj = obj;
    }


    public JSONObject update( String keyString, String newValue) throws Exception {

        Iterator iterator = obj.keys();
        String key = null, value = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            value = obj.getString(key);
            if ( (obj.optJSONObject(key) == null)) {
                if ((key.equals(keyString))) {
                    obj.put(key, newValue);
                    return obj;
                }
            }
            if (obj.optJSONObject(key) != null) {
                update(keyString, newValue);

            }
        }
        return obj;
    }
}

