package net.one97.paytm.nativesdk.orflow.promo.model;

import kotlin.g.b.k;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonUtils {
    public static final JsonUtils INSTANCE = new JsonUtils();

    private JsonUtils() {
    }

    public final Object getObject(JSONObject jSONObject, String str) {
        k.c(str, "key");
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.get(str);
        } catch (JSONException unused) {
            return null;
        }
    }
}
