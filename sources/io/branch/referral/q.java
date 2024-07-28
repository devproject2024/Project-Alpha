package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class q {

    /* renamed from: c  reason: collision with root package name */
    public static JSONObject f46563c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f46564d = null;

    /* renamed from: e  reason: collision with root package name */
    private static q f46565e = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f46566i = null;
    private static String j = null;
    private static boolean k = false;

    /* renamed from: a  reason: collision with root package name */
    final JSONObject f46567a = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    final JSONObject f46568b = new JSONObject();

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences f46569f;

    /* renamed from: g  reason: collision with root package name */
    private SharedPreferences.Editor f46570g = this.f46569f.edit();

    /* renamed from: h  reason: collision with root package name */
    private final JSONObject f46571h = new JSONObject();

    private q(Context context) {
        this.f46569f = context.getSharedPreferences("branch_referral_shared_pref", 0);
    }

    public static q a(Context context) {
        if (f46565e == null) {
            f46565e = new q(context);
        }
        return f46565e;
    }

    public static String a() {
        if (URLUtil.isHttpsUrl(f46566i)) {
            return f46566i;
        }
        return Build.VERSION.SDK_INT >= 20 ? "https://api2.branch.io/" : "https://api.branch.io/";
    }

    static String b() {
        return !TextUtils.isEmpty(j) ? j : "https://cdn.branch.io/";
    }

    public static int c() {
        return b("bnc_timeout", 5500);
    }

    public static int d() {
        return b("bnc_retry_interval", 1000);
    }

    public final boolean a(String str) {
        f46564d = str;
        if (d("bnc_branch_key").equals(str)) {
            return false;
        }
        k();
        a("bnc_branch_key", str);
        return true;
    }

    public static String e() {
        if (f46564d == null) {
            f46564d = d("bnc_branch_key");
        }
        return f46564d;
    }

    public static void a(boolean z) {
        a("bnc_is_full_app_conversion", Boolean.valueOf(z));
    }

    static ArrayList<String> g() {
        String d2 = d("bnc_buckets");
        if (d2.equals("bnc_no_value")) {
            return new ArrayList<>();
        }
        return l(d2);
    }

    static void a(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            a("bnc_buckets", "bnc_no_value");
        } else {
            a("bnc_buckets", c(arrayList));
        }
    }

    public static void a(String str, int i2) {
        ArrayList<String> g2 = g();
        if (!g2.contains(str)) {
            g2.add(str);
            a(g2);
        }
        c("bnc_credit_base_".concat(String.valueOf(str)), i2);
    }

    public static int b(String str) {
        return b("bnc_credit_base_".concat(String.valueOf(str)), 0);
    }

    static ArrayList<String> h() {
        String d2 = d("bnc_actions");
        if (d2.equals("bnc_no_value")) {
            return new ArrayList<>();
        }
        return l(d2);
    }

    static void b(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            a("bnc_actions", "bnc_no_value");
        } else {
            a("bnc_actions", c(arrayList));
        }
    }

    private static String c(ArrayList<String> arrayList) {
        Iterator<String> it2 = arrayList.iterator();
        String str = "";
        while (it2.hasNext()) {
            str = str + it2.next() + AppConstants.COMMA;
        }
        return str.substring(0, str.length() - 1);
    }

    private static ArrayList<String> l(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, str.split(AppConstants.COMMA));
        return arrayList;
    }

    public static int b(String str, int i2) {
        return f46565e.f46569f.getInt(str, i2);
    }

    public static long c(String str) {
        return f46565e.f46569f.getLong(str, 0);
    }

    public static String d(String str) {
        return f46565e.f46569f.getString(str, "bnc_no_value");
    }

    public static boolean e(String str) {
        return f46565e.f46569f.getBoolean(str, false);
    }

    public static void c(String str, int i2) {
        f46565e.f46570g.putInt(str, i2);
        f46565e.f46570g.apply();
    }

    public static void a(String str, long j2) {
        f46565e.f46570g.putLong(str, j2);
        f46565e.f46570g.apply();
    }

    public static void a(String str, String str2) {
        f46565e.f46570g.putString(str, str2);
        f46565e.f46570g.apply();
    }

    public static void a(String str, Boolean bool) {
        f46565e.f46570g.putBoolean(str, bool.booleanValue());
        f46565e.f46570g.apply();
    }

    public static int f(String str) {
        return b("bnc_branch_view_use_".concat(String.valueOf(str)), 0);
    }

    public static JSONObject i() {
        JSONObject jSONObject = f46563c;
        if (jSONObject != null) {
            return jSONObject;
        }
        String d2 = d("bnc_branch_analytical_data");
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(d2) && !d2.equals("bnc_no_value")) {
            try {
                return new JSONObject(d2);
            } catch (JSONException unused) {
            }
        }
        return jSONObject2;
    }

    /* access modifiers changed from: package-private */
    public final String g(String str) {
        if (str == null) {
            return null;
        }
        try {
            return this.f46571h.get(str).toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean j() {
        try {
            return this.f46571h.length() != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void h(String str) {
        if (j.b() || k) {
            TextUtils.isEmpty(str);
        }
    }

    public static void i(String str) {
        TextUtils.isEmpty(str);
    }

    public static void j(String str) {
        TextUtils.isEmpty(str);
    }

    static boolean k(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(j.a() ? "key_test_" : "key_");
    }

    public static int f() {
        return b("bnc_is_referrable", 0);
    }

    private void k() {
        String d2 = d("bnc_link_click_id");
        String d3 = d("bnc_link_click_identifier");
        String d4 = d("bnc_app_link");
        String d5 = d("bnc_push_identifier");
        this.f46570g.clear();
        a("bnc_link_click_id", d2);
        a("bnc_link_click_identifier", d3);
        a("bnc_app_link", d4);
        a("bnc_push_identifier", d5);
        f46565e.f46570g.apply();
    }
}
