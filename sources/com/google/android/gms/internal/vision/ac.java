package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ac implements o {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, ac> f10974d = new a();

    /* renamed from: a  reason: collision with root package name */
    final Object f10975a = new Object();

    /* renamed from: b  reason: collision with root package name */
    volatile Map<String, ?> f10976b;

    /* renamed from: c  reason: collision with root package name */
    final List<Object> f10977c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f10978e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f10979f = new ae(this);

    static ac a(Context context, String str) {
        ac acVar;
        if (!((!i.a() || str.startsWith("direct_boot:")) ? true : i.a(context))) {
            return null;
        }
        synchronized (ac.class) {
            acVar = f10974d.get(str);
            if (acVar == null) {
                acVar = new ac(b(context, str));
                f10974d.put(str, acVar);
            }
        }
        return acVar;
    }

    private static SharedPreferences b(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (i.a()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return sharedPreferences;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private ac(SharedPreferences sharedPreferences) {
        this.f10978e = sharedPreferences;
        this.f10978e.registerOnSharedPreferenceChangeListener(this.f10979f);
    }

    /* JADX INFO: finally extract failed */
    public final Object a(String str) {
        Map<String, ?> map = this.f10976b;
        if (map == null) {
            synchronized (this.f10975a) {
                map = this.f10976b;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.f10978e.getAll();
                        this.f10976b = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void a() {
        synchronized (ac.class) {
            for (ac next : f10974d.values()) {
                next.f10978e.unregisterOnSharedPreferenceChangeListener(next.f10979f);
            }
            f10974d.clear();
        }
    }
}
