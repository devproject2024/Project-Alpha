package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.business.merchant_payments.common.utility.AppConstants;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ar extends a {
    public ar() {
        super("getStartupParams");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        Object obj;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        String bridgeName = h5Event.getBridgeName();
        if (bridgeName != null && bridgeName.hashCode() == -305376595 && bridgeName.equals("getStartupParams")) {
            Activity activity = h5Event.getActivity();
            if (activity != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject params = h5Event.getParams();
                    JSONArray optJSONArray = params != null ? params.optJSONArray("key") : null;
                    if (optJSONArray == null) {
                        a(jSONObject, activity);
                    } else if (optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            Object opt = optJSONArray.opt(i2);
                            if (opt instanceof String) {
                                Intent intent = activity.getIntent();
                                k.a((Object) intent, "activity.intent");
                                Bundle extras = intent.getExtras();
                                if (!(extras == null || (obj = extras.get((String) opt)) == null)) {
                                    if (obj instanceof Map) {
                                        jSONObject.put((String) opt, new JSONObject((Map) obj));
                                    } else {
                                        jSONObject.put((String) opt, obj);
                                    }
                                }
                            }
                        }
                    } else {
                        a(jSONObject, activity);
                    }
                    a(h5Event, (Object) jSONObject, true);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "");
                    return false;
                }
            } else {
                a(h5Event, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "");
            }
        }
        return false;
    }

    private static void a(JSONObject jSONObject, Activity activity) {
        Set<String> keySet;
        k.c(jSONObject, "params");
        k.c(activity, "activity");
        Intent intent = activity.getIntent();
        k.a((Object) intent, "activity.intent");
        Bundle extras = intent.getExtras();
        if (extras != null && (keySet = extras.keySet()) != null && (r0 = keySet.iterator()) != null) {
            for (String str : keySet) {
                Object obj = extras.get(str);
                if (obj instanceof Map) {
                    jSONObject.put(str, new JSONObject((Map) obj));
                } else {
                    jSONObject.put(str, extras.get(str));
                }
            }
        }
    }
}
