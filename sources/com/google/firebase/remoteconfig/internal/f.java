package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Date f39367d = new Date(0);

    /* renamed from: a  reason: collision with root package name */
    JSONObject f39368a;

    /* renamed from: b  reason: collision with root package name */
    public Date f39369b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f39370c;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f39371e;

    /* synthetic */ f(JSONObject jSONObject, Date date, JSONArray jSONArray, byte b2) throws JSONException {
        this(jSONObject, date, jSONArray);
    }

    private f(JSONObject jSONObject, Date date, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("configs_key", jSONObject);
        jSONObject2.put("fetch_time_key", date.getTime());
        jSONObject2.put("abt_experiments_key", jSONArray);
        this.f39368a = jSONObject;
        this.f39369b = date;
        this.f39370c = jSONArray;
        this.f39371e = jSONObject2;
    }

    static f a(JSONObject jSONObject) throws JSONException {
        return new f(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"));
    }

    public final String toString() {
        return this.f39371e.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f39371e.toString().equals(((f) obj).toString());
    }

    public final int hashCode() {
        return this.f39371e.hashCode();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Date f39372a;

        /* renamed from: b  reason: collision with root package name */
        private JSONObject f39373b;

        /* renamed from: c  reason: collision with root package name */
        private JSONArray f39374c;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.f39373b = new JSONObject();
            this.f39372a = f.f39367d;
            this.f39374c = new JSONArray();
        }

        public final a a(Map<String, String> map) {
            this.f39373b = new JSONObject(map);
            return this;
        }

        public final a a(JSONObject jSONObject) {
            try {
                this.f39373b = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public final a a(JSONArray jSONArray) {
            try {
                this.f39374c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public final f a() throws JSONException {
            return new f(this.f39373b, this.f39372a, this.f39374c, (byte) 0);
        }
    }

    public static a a() {
        return new a((byte) 0);
    }
}
