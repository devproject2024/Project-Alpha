package com.paytmmall.artifact.scan.d;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.utility.q;
import com.paytmmall.artifact.scan.entity.RecentScan;
import org.json.JSONObject;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f15880c;

    /* renamed from: a  reason: collision with root package name */
    public RecentScan f15881a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f15882b = "RecentScansHelper";

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f15880c == null) {
                f15880c = new a();
            }
            aVar = f15880c;
        }
        return aVar;
    }

    private a() {
    }

    public final void a(Context context, String str, String str2, int i2) {
        if (!TextUtils.isEmpty(str2) && a(i2, str, context, str2)) {
            this.f15881a = new RecentScan();
            this.f15881a.setScanResult(a(str));
            this.f15881a.setType(1);
            this.f15881a.setUniqKey(str2);
            this.f15881a.setTimestamp(System.currentTimeMillis());
        }
    }

    private static String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("mode", "RECENT_SCAN");
            return jSONObject.toString();
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return str;
        }
    }

    private static boolean a(int i2, String str, Context context, String str2) {
        if (i2 == 2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                com.paytmmall.artifact.scan.entity.a aVar = new com.paytmmall.artifact.scan.entity.a();
                aVar.a(jSONObject, context);
                if (!TextUtils.isEmpty(aVar.f15889g)) {
                    return false;
                }
                if (TextUtils.isEmpty(aVar.f15890h) || str2.equalsIgnoreCase(aVar.f15890h)) {
                    return true;
                }
                return false;
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        return true;
    }
}
