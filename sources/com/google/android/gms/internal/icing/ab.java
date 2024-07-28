package com.google.android.gms.internal.icing;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ab implements r {

    /* renamed from: a  reason: collision with root package name */
    static final Map<String, ab> f10049a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Object f10050b = new Object();

    /* renamed from: c  reason: collision with root package name */
    volatile Map<String, ?> f10051c;

    /* renamed from: d  reason: collision with root package name */
    final List<Object> f10052d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f10053e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f10054f = new aa(this);

    /* JADX WARNING: type inference failed for: r1v0, types: [com.google.android.gms.internal.icing.ab, java.lang.Object, java.lang.String] */
    static ab a(Context context) {
        ab abVar;
        SharedPreferences sharedPreferences;
        ? r1 = 0;
        if (!((!k.a() || r1.startsWith("direct_boot:")) ? true : k.a(context))) {
            return r1;
        }
        synchronized (ab.class) {
            abVar = f10049a.get(r1);
            if (abVar == null) {
                if (r1.startsWith("direct_boot:")) {
                    if (k.a()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(r1.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(r1, 0);
                }
                abVar = new ab(sharedPreferences);
                f10049a.put(r1, abVar);
            }
        }
        return abVar;
    }

    private ab(SharedPreferences sharedPreferences) {
        this.f10053e = sharedPreferences;
        this.f10053e.registerOnSharedPreferenceChangeListener(this.f10054f);
    }

    public final Object a(String str) {
        Map<String, ?> map = this.f10051c;
        if (map == null) {
            synchronized (this.f10050b) {
                map = this.f10051c;
                if (map == null) {
                    map = this.f10053e.getAll();
                    this.f10051c = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
