package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f39020a;

    public n(Bundle bundle) {
        if (bundle != null) {
            this.f39020a = new Bundle(bundle);
            return;
        }
        throw new NullPointerException("data");
    }

    public final String a(String str) {
        return this.f39020a.getString(e(str));
    }

    private String e(String str) {
        if (!this.f39020a.containsKey(str) && str.startsWith("gcm.n.")) {
            String i2 = i(str);
            if (this.f39020a.containsKey(i2)) {
                return i2;
            }
        }
        return str;
    }

    public final boolean b(String str) {
        String a2 = a(str);
        return "1".equals(a2) || Boolean.parseBoolean(a2);
    }

    public final Integer c(String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(a2));
        } catch (NumberFormatException unused) {
            String h2 = h(str);
            StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 38 + String.valueOf(a2).length());
            sb.append("Couldn't parse value of ");
            sb.append(h2);
            sb.append("(");
            sb.append(a2);
            sb.append(") into an int");
            return null;
        }
    }

    public final Long d(String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(a2));
        } catch (NumberFormatException unused) {
            String h2 = h(str);
            StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 38 + String.valueOf(a2).length());
            sb.append("Couldn't parse value of ");
            sb.append(h2);
            sb.append("(");
            sb.append(a2);
            sb.append(") into a long");
            return null;
        }
    }

    private Object[] f(String str) {
        String valueOf = String.valueOf(str);
        JSONArray g2 = g("_loc_args".length() != 0 ? valueOf.concat("_loc_args") : new String(valueOf));
        if (g2 == null) {
            return null;
        }
        String[] strArr = new String[g2.length()];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = g2.optString(i2);
        }
        return strArr;
    }

    private JSONArray g(String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            return new JSONArray(a2);
        } catch (JSONException unused) {
            String h2 = h(str);
            StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 50 + String.valueOf(a2).length());
            sb.append("Malformed JSON for key ");
            sb.append(h2);
            sb.append(": ");
            sb.append(a2);
            sb.append(", falling back to default");
            return null;
        }
    }

    private static String h(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public final long[] a() {
        JSONArray g2 = g("gcm.n.vibrate_timings");
        if (g2 == null) {
            return null;
        }
        try {
            if (g2.length() > 1) {
                long[] jArr = new long[g2.length()];
                for (int i2 = 0; i2 < jArr.length; i2++) {
                    jArr[i2] = g2.optLong(i2);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            String valueOf = String.valueOf(g2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 74);
            sb.append("User defined vibrateTimings is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting vibrateTimings.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final int[] b() {
        JSONArray g2 = g("gcm.n.light_settings");
        if (g2 == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (g2.length() == 3) {
                int parseColor = Color.parseColor(g2.optString(0));
                if (parseColor != -16777216) {
                    iArr[0] = parseColor;
                    iArr[1] = g2.optInt(1);
                    iArr[2] = g2.optInt(2);
                    return iArr;
                }
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (JSONException unused) {
            String valueOf = String.valueOf(g2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 58);
            sb.append("LightSettings is invalid: ");
            sb.append(valueOf);
            sb.append(". Skipping setting LightSettings");
            return null;
        } catch (IllegalArgumentException e2) {
            String valueOf2 = String.valueOf(g2);
            String message = e2.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 60 + String.valueOf(message).length());
            sb2.append("LightSettings is invalid: ");
            sb2.append(valueOf2);
            sb2.append(". ");
            sb2.append(message);
            sb2.append(". Skipping setting LightSettings");
            return null;
        }
    }

    public final Bundle c() {
        Bundle bundle = new Bundle(this.f39020a);
        for (String str : this.f39020a.keySet()) {
            if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public final Bundle d() {
        Bundle bundle = new Bundle(this.f39020a);
        for (String str : this.f39020a.keySet()) {
            if (!(str.startsWith("google.c.a.") || str.equals("from"))) {
                bundle.remove(str);
            }
        }
        return bundle;
    }

    public final String a(Resources resources, String str, String str2) {
        String a2 = a(str2);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return b(resources, str, str2);
    }

    public static boolean a(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(i("gcm.n.e")));
    }

    private static String i(String str) {
        if (!str.startsWith("gcm.n.")) {
            return str;
        }
        return str.replace("gcm.n.", "gcm.notification.");
    }

    private String b(Resources resources, String str, String str2) {
        String valueOf = String.valueOf(str2);
        String a2 = a("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        int identifier = resources.getIdentifier(a2, "string", str);
        if (identifier == 0) {
            String valueOf2 = String.valueOf(str2);
            String h2 = h("_loc_key".length() != 0 ? valueOf2.concat("_loc_key") : new String(valueOf2));
            StringBuilder sb = new StringBuilder(String.valueOf(h2).length() + 49 + String.valueOf(str2).length());
            sb.append(h2);
            sb.append(" resource not found: ");
            sb.append(str2);
            sb.append(" Default value will be used.");
            return null;
        }
        Object[] f2 = f(str2);
        if (f2 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, f2);
        } catch (MissingFormatArgumentException unused) {
            String h3 = h(str2);
            String arrays = Arrays.toString(f2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(h3).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(h3);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            return null;
        }
    }
}
