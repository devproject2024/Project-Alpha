package net.one97.paytm.nativesdk.orflow.interfaces;

import android.content.Context;
import java.util.Map;

public interface GAEventListener {
    void sendGAEvents(Context context, Map<String, Object> map);

    void sendScreenViewEvent(Context context, String str, String str2);
}
