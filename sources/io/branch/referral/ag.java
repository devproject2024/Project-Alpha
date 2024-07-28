package io.branch.referral;

import com.business.merchant_payments.common.utility.AppUtility;
import org.json.JSONObject;

public final class ag {

    /* renamed from: a  reason: collision with root package name */
    int f46431a;

    /* renamed from: b  reason: collision with root package name */
    public Object f46432b;

    /* renamed from: c  reason: collision with root package name */
    private String f46433c;

    public ag(String str, int i2) {
        this.f46433c = str;
        this.f46431a = i2;
    }

    public final JSONObject a() {
        Object obj = this.f46432b;
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        return new JSONObject();
    }

    public final String b() {
        try {
            JSONObject a2 = a();
            if (a2 == null || !a2.has("error") || !a2.getJSONObject("error").has("message")) {
                return "";
            }
            String string = a2.getJSONObject("error").getString("message");
            if (string == null || string.trim().length() <= 0) {
                return string;
            }
            return string + AppUtility.CENTER_DOT;
        } catch (Exception unused) {
            return "";
        }
    }
}
