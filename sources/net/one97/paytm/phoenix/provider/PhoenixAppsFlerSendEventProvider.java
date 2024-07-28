package net.one97.paytm.phoenix.provider;

import android.content.Context;
import java.util.HashMap;

public interface PhoenixAppsFlerSendEventProvider {
    void sendAppsFlyerEvent(Context context, String str, HashMap<String, String> hashMap);
}
