package com.google.android.gms.internal.firebase_ml;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.j;
import com.google.firebase.components.b;
import com.google.firebase.components.e;
import com.google.firebase.components.n;
import java.util.UUID;

public class ef {

    /* renamed from: a  reason: collision with root package name */
    public static final b<?> f9854a = b.a(ef.class).a(n.b(ds.class)).a(n.b(Context.class)).a(ee.f9853a).a();

    /* renamed from: b  reason: collision with root package name */
    private static final j f9855b = new j("SharedPrefManager", "");

    /* renamed from: c  reason: collision with root package name */
    private final Context f9856c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9857d;

    private ef(ds dsVar, Context context) {
        this.f9856c = context;
        this.f9857d = dsVar.f9817b.h();
    }

    public static ef a(ds dsVar) {
        return (ef) dsVar.a(ef.class);
    }

    public final synchronized boolean a() {
        return d().getBoolean(String.format("logging_%s_%s", new Object[]{"vision", this.f9857d}), true);
    }

    public final synchronized boolean b() {
        return d().getBoolean(String.format("logging_%s_%s", new Object[]{"model", this.f9857d}), true);
    }

    public final synchronized String c() {
        String string = d().getString("ml_sdk_instance_id", (String) null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        d().edit().putString("ml_sdk_instance_id", uuid).apply();
        return uuid;
    }

    private final SharedPreferences d() {
        return this.f9856c.getSharedPreferences("com.google.firebase.ml.internal", 0);
    }

    static final /* synthetic */ ef a(e eVar) {
        return new ef((ds) eVar.a(ds.class), (Context) eVar.a(Context.class));
    }
}
