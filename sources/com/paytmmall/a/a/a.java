package com.paytmmall.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import org.json.JSONObject;

public final class a extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    private static String f15364a = "H5BroadcastPlugin";

    public a() {
        super("mpBroadcast");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        if (h5Event == null || h5Event.getParams() == null) {
            return false;
        }
        try {
            HashMap<String, Object> b2 = b(h5Event);
            Activity activity = h5Event.getActivity();
            if (b2.containsKey("broadcastKey")) {
                if (activity != null) {
                    String valueOf = String.valueOf(b2.get("broadcastKey"));
                    String str = null;
                    if (b2.containsKey("broadcastData")) {
                        str = String.valueOf(b2.get("broadcastData"));
                    }
                    Intent intent = new Intent(valueOf);
                    intent.putExtra("broadcastKey", valueOf);
                    intent.putExtra("broadcastData", str);
                    androidx.localbroadcastmanager.a.a.a((Context) activity).a(intent);
                }
            }
            com.paytmmall.artifact.common.b.a.a.a(b(h5Event), h5Event.getActivity());
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        return super.a(h5Event, bVar);
    }

    private static HashMap<String, Object> b(H5Event h5Event) {
        JSONObject params = h5Event.getParams();
        HashMap<String, Object> hashMap = new HashMap<>();
        if (params != null && params.length() > 0) {
            Iterator<String> keys = params.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, params.optString(next));
            }
        }
        return hashMap;
    }
}
