package com.alipay.mobile.rome.syncsdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.e.h;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15005a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f15006b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static a f15007c;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f15007c == null) {
                f15007c = new a();
            }
            aVar = f15007c;
        }
        return aVar;
    }

    public final synchronized void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            b(context, str, str2);
        }
    }

    public final synchronized String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return c(context, str);
    }

    private synchronized String c(Context context, String str) {
        String str2;
        str2 = f15006b.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            str2 = context.getSharedPreferences("com.alipay.android.phone.rome.syncsdk.linkinfo", 0).getString(str, (String) null);
            if (str2 != null) {
                f15006b.put(str, str2);
            }
        } catch (Exception e2) {
            String str3 = f15005a;
            h.d(str3, "getString: [ Exception " + e2 + " ]");
        }
        return str2;
    }

    private synchronized boolean b(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("com.alipay.android.phone.rome.syncsdk.linkinfo", 0).edit().putString(str, str2).commit();
            f15006b.put(str, str2);
        } catch (Exception e2) {
            String str3 = f15005a;
            h.d(str3, "putString: [ Exception " + e2 + " ]");
            return false;
        }
        return true;
    }

    public final synchronized void b(Context context, String str) {
        f15006b.remove(str);
        try {
            context.getSharedPreferences("com.alipay.android.phone.rome.syncsdk.linkinfo", 4).edit().remove(str).commit();
        } catch (Exception e2) {
            String str2 = f15005a;
            h.d(str2, "putString: [ Exception " + e2 + " ]");
        }
    }
}
