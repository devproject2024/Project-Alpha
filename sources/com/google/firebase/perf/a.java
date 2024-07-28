package com.google.firebase.perf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.internal.p001firebaseperf.z;
import com.google.firebase.c;
import com.google.firebase.perf.internal.FeatureControl;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.RemoteConfigManager;
import com.google.firebase.perf.metrics.Trace;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f39177b;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f39178a;

    /* renamed from: c  reason: collision with root package name */
    private final z f39179c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f39180d;

    public static a a() {
        Class cls = a.class;
        if (f39177b == null) {
            synchronized (cls) {
                if (f39177b == null) {
                    f39177b = (a) c.e().a(cls);
                }
            }
        }
        return f39177b;
    }

    a(c cVar, com.google.firebase.remoteconfig.a aVar) {
        this(cVar, aVar, RemoteConfigManager.zzbz(), FeatureControl.zzao(), GaugeManager.zzbe());
    }

    private a(c cVar, com.google.firebase.remoteconfig.a aVar, RemoteConfigManager remoteConfigManager, FeatureControl featureControl, GaugeManager gaugeManager) {
        this.f39178a = new ConcurrentHashMap();
        this.f39180d = null;
        if (cVar == null) {
            this.f39180d = Boolean.FALSE;
            this.f39179c = new z(new Bundle());
            return;
        }
        Context a2 = cVar.a();
        this.f39179c = b(a2);
        this.f39180d = a(a2);
        remoteConfigManager.zza(aVar);
        remoteConfigManager.zza(cVar);
        featureControl.zza(this.f39179c);
        gaugeManager.zze(a2);
    }

    public static Trace a(String str) {
        Trace a2 = Trace.a(str);
        a2.start();
        return a2;
    }

    public final boolean b() {
        Boolean bool = this.f39180d;
        if (bool != null) {
            return bool.booleanValue();
        }
        return c.e().f();
    }

    public static Trace b(String str) {
        return Trace.a(str);
    }

    private static z b(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "No perf enable meta data found ".concat(valueOf);
            } else {
                new String("No perf enable meta data found ");
            }
            bundle = null;
        }
        return bundle != null ? new z(bundle) : new z();
    }

    private final Boolean a(Context context) {
        if (this.f39179c.a("firebase_performance_collection_deactivated", false)) {
            return Boolean.FALSE;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
        try {
            if (sharedPreferences.contains("isEnabled")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("isEnabled", true));
            }
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Unable to access enable value: ".concat(valueOf);
            } else {
                new String("Unable to access enable value: ");
            }
        }
        if (this.f39179c.f9735a.containsKey("firebase_performance_collection_enabled")) {
            return Boolean.valueOf(this.f39179c.a("firebase_performance_collection_enabled", true));
        }
        return null;
    }
}
