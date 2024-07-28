package com.android.billingclient.api;

import android.text.TextUtils;
import com.sendbird.android.constant.StringSet;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f30954a = new JSONObject(this.f30955b);

    /* renamed from: b  reason: collision with root package name */
    private final String f30955b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30956c;

    public g(String str, String str2) throws JSONException {
        this.f30955b = str;
        this.f30956c = str2;
    }

    public final String a() {
        return this.f30954a.optString("productId");
    }

    public final String b() {
        JSONObject jSONObject = this.f30954a;
        return jSONObject.optString(StringSet.token, jSONObject.optString("purchaseToken"));
    }

    public final String toString() {
        return "Purchase. Json: " + this.f30955b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return TextUtils.equals(this.f30955b, gVar.f30955b) && TextUtils.equals(this.f30956c, gVar.f30956c);
    }

    public final int hashCode() {
        return this.f30955b.hashCode();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<g> f30957a;

        /* renamed from: b  reason: collision with root package name */
        public int f30958b;

        a(int i2, List<g> list) {
            this.f30957a = list;
            this.f30958b = i2;
        }
    }
}
