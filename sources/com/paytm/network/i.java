package com.paytm.network;

import android.text.TextUtils;
import androidx.a.e;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static int f42954a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f42955b;

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Integer> f42956c;

    /* renamed from: d  reason: collision with root package name */
    private static e<String, IJRPaytmDataModel> f42957d;

    public static void a() {
        f42957d = new e<>(50);
        f42956c = new HashMap();
    }

    public static IJRPaytmDataModel a(String str) {
        e<String, IJRPaytmDataModel> eVar = f42957d;
        if (eVar == null) {
            return null;
        }
        return eVar.get(str);
    }

    public static boolean b(String str) {
        return (f42957d == null || str == null || a(str) == null) ? false : true;
    }

    public static void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
        e<String, IJRPaytmDataModel> eVar = f42957d;
        if (eVar != null) {
            eVar.put(str, iJRPaytmDataModel);
        }
    }

    private static Integer e(String str) {
        int i2 = 0;
        try {
            if (f42956c != null && !TextUtils.isEmpty(str) && f42956c.containsKey(str) && f42956c.get(str) != null) {
                i2 = f42956c.get(str).intValue();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return Integer.valueOf(i2);
    }

    public static void c(String str) {
        try {
            if (f42956c != null && !TextUtils.isEmpty(str)) {
                f42956c.put(str, Integer.valueOf(((!f42956c.containsKey(str) || f42956c.get(str) == null) ? 0 : f42956c.get(str).intValue()) + 1));
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public static void b() {
        e<String, IJRPaytmDataModel> eVar = f42957d;
        if (eVar != null) {
            eVar.evictAll();
            f42957d = null;
        }
        Map<String, Integer> map = f42956c;
        if (map != null) {
            map.clear();
            f42956c = null;
        }
    }

    public static boolean d(String str) {
        return f42955b && f42954a > 0 && e(str).intValue() > f42954a;
    }
}
