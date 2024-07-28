package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class bm implements au {

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, bm> f10502d = new a();

    /* renamed from: a  reason: collision with root package name */
    final Object f10503a = new Object();

    /* renamed from: b  reason: collision with root package name */
    volatile Map<String, ?> f10504b;

    /* renamed from: c  reason: collision with root package name */
    final List<Object> f10505c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f10506e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f10507f = new bl(this);

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, java.lang.String, com.google.android.gms.internal.measurement.bm] */
    static bm a(Context context) {
        bm bmVar;
        SharedPreferences sharedPreferences;
        ? r1 = 0;
        if (!((!aq.a() || r1.startsWith("direct_boot:")) ? true : aq.a(context))) {
            return r1;
        }
        synchronized (bm.class) {
            bmVar = f10502d.get(r1);
            if (bmVar == null) {
                if (r1.startsWith("direct_boot:")) {
                    if (aq.a()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(r1.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(r1, 0);
                }
                bmVar = new bm(sharedPreferences);
                f10502d.put(r1, bmVar);
            }
        }
        return bmVar;
    }

    private bm(SharedPreferences sharedPreferences) {
        this.f10506e = sharedPreferences;
        this.f10506e.registerOnSharedPreferenceChangeListener(this.f10507f);
    }

    public final Object a(String str) {
        Map<String, ?> map = this.f10504b;
        if (map == null) {
            synchronized (this.f10503a) {
                map = this.f10504b;
                if (map == null) {
                    map = this.f10506e.getAll();
                    this.f10504b = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    static synchronized void a() {
        synchronized (bm.class) {
            for (bm next : f10502d.values()) {
                next.f10506e.unregisterOnSharedPreferenceChangeListener(next.f10507f);
            }
            f10502d.clear();
        }
    }
}
