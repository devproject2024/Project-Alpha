package net.one97.paytm.phoenix.provider;

import android.content.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PhoenixHttpProvider {

    public interface PhoenixHttpResponseListener {
        void onResponse(int i2, String str, String str2, HashMap<String, List<String>> hashMap);
    }

    void performRequest(String str, String str2, Map<String, String> map, String str3, Integer num, Context context, PhoenixHttpResponseListener phoenixHttpResponseListener, Boolean bool);
}
