package com.travel.citybus.best.e;

import com.paytm.network.model.NetworkCustomError;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static String a(NetworkCustomError networkCustomError) {
        try {
            return new JSONObject(new String(networkCustomError.networkResponse.data)).getString("statusMessage");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
