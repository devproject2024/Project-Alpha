package io.branch.indexing;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: i  reason: collision with root package name */
    private static b f46393i;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f46394a;

    /* renamed from: b  reason: collision with root package name */
    public String f46395b;

    /* renamed from: c  reason: collision with root package name */
    public int f46396c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f46397d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f46398e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46399f = false;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f46400g;

    /* renamed from: h  reason: collision with root package name */
    public SharedPreferences f46401h;
    private final String j = "BNC_CD_MANIFEST";

    private b(Context context) {
        this.f46401h = context.getSharedPreferences("bnc_content_discovery_manifest_storage", 0);
        String string = this.f46401h.getString("BNC_CD_MANIFEST", (String) null);
        if (string != null) {
            try {
                this.f46394a = new JSONObject(string);
                if (this.f46394a.has("mv")) {
                    this.f46395b = this.f46394a.getString("mv");
                }
                if (this.f46394a.has("m")) {
                    this.f46400g = this.f46394a.getJSONArray("m");
                }
            } catch (JSONException unused) {
                this.f46394a = new JSONObject();
            }
        } else {
            this.f46394a = new JSONObject();
        }
    }

    public static b a(Context context) {
        if (f46393i == null) {
            f46393i = new b(context);
        }
        return f46393i;
    }

    /* access modifiers changed from: package-private */
    public final a a(Activity activity) {
        if (this.f46400g != null) {
            String str = "/" + activity.getClass().getSimpleName();
            int i2 = 0;
            while (i2 < this.f46400g.length()) {
                try {
                    JSONObject jSONObject = this.f46400g.getJSONObject(i2);
                    if (jSONObject.has("p") && jSONObject.getString("p").equals(str)) {
                        return new a(jSONObject);
                    }
                    i2++;
                } catch (JSONException unused) {
                }
            }
        }
        return null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f46395b)) {
            return H5BridgeContext.INVALID_ID;
        }
        return this.f46395b;
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        final JSONObject f46402a;

        /* renamed from: b  reason: collision with root package name */
        boolean f46403b;

        /* renamed from: c  reason: collision with root package name */
        int f46404c;

        /* renamed from: d  reason: collision with root package name */
        int f46405d = 15;

        a(JSONObject jSONObject) {
            this.f46402a = jSONObject;
            if (jSONObject.has("h")) {
                try {
                    this.f46403b = !jSONObject.getBoolean("h");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                if (jSONObject.has("dri")) {
                    this.f46404c = jSONObject.getInt("dri");
                }
                if (jSONObject.has("mdr")) {
                    this.f46405d = jSONObject.getInt("mdr");
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        public final JSONArray a() {
            if (this.f46402a.has("ck")) {
                try {
                    return this.f46402a.getJSONArray("ck");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
    }
}
