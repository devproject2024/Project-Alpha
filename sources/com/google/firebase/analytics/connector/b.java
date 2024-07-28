package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzkl;
import com.google.firebase.a;
import com.google.firebase.a.d;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f37969b;

    /* renamed from: a  reason: collision with root package name */
    final Map<String, Object> f37970a = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final AppMeasurement f37971c;

    private b(AppMeasurement appMeasurement) {
        s.a(appMeasurement);
        this.f37971c = appMeasurement;
    }

    public static a a(c cVar, Context context, d dVar) {
        s.a(cVar);
        s.a(context);
        s.a(dVar);
        s.a(context.getApplicationContext());
        if (f37969b == null) {
            synchronized (b.class) {
                if (f37969b == null) {
                    Bundle bundle = new Bundle(1);
                    if (cVar.g()) {
                        dVar.a(a.class, d.f37975a, c.f37974a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", cVar.f());
                    }
                    f37969b = new b(AppMeasurement.a(context, bundle));
                }
            }
        }
        return f37969b;
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.google.firebase.analytics.connector.internal.c.a(str) && com.google.firebase.analytics.connector.internal.c.a(str2, bundle) && com.google.firebase.analytics.connector.internal.c.a(str, str2, bundle)) {
            this.f37971c.logEventInternal(str, str2, bundle);
        }
    }

    public final void a(String str, String str2, Object obj) {
        if (com.google.firebase.analytics.connector.internal.c.a(str) && com.google.firebase.analytics.connector.internal.c.a(str, str2)) {
            AppMeasurement appMeasurement = this.f37971c;
            s.a(str);
            if (appMeasurement.f11674c) {
                appMeasurement.f11673b.a(str, str2, obj);
            } else {
                appMeasurement.f11672a.d().a(str, str2, obj);
            }
        }
    }

    public final Map<String, Object> a() {
        AppMeasurement appMeasurement = this.f37971c;
        if (appMeasurement.f11674c) {
            return appMeasurement.f11673b.a((String) null, (String) null, false);
        }
        List<zzkl> A = appMeasurement.f11672a.d().A();
        androidx.a.a aVar = new androidx.a.a(A.size());
        for (zzkl next : A) {
            aVar.put(next.f12372a, next.a());
        }
        return aVar;
    }

    public final a.C0624a a(final String str, a.b bVar) {
        Object obj;
        s.a(bVar);
        if (!com.google.firebase.analytics.connector.internal.c.a(str)) {
            return null;
        }
        if (!str.isEmpty() && this.f37970a.containsKey(str) && this.f37970a.get(str) != null) {
            return null;
        }
        AppMeasurement appMeasurement = this.f37971c;
        if ("fiam".equals(str)) {
            obj = new com.google.firebase.analytics.connector.internal.b(appMeasurement, bVar);
        } else {
            obj = "crash".equals(str) ? new com.google.firebase.analytics.connector.internal.d(appMeasurement, bVar) : null;
        }
        if (obj == null) {
            return null;
        }
        this.f37970a.put(str, obj);
        return new a.C0624a() {
        };
    }

    public final void a(a.c cVar) {
        if (com.google.firebase.analytics.connector.internal.c.a(cVar)) {
            this.f37971c.setConditionalUserProperty(com.google.firebase.analytics.connector.internal.c.b(cVar));
        }
    }

    public final void a(String str) {
        this.f37971c.clearConditionalUserProperty(str, (String) null, (Bundle) null);
    }

    public final List<a.c> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (AppMeasurement.ConditionalUserProperty a2 : this.f37971c.getConditionalUserProperties(str, str2)) {
            arrayList.add(com.google.firebase.analytics.connector.internal.c.a(a2));
        }
        return arrayList;
    }

    public final int b(String str) {
        return this.f37971c.getMaxUserProperties(str);
    }

    static final /* synthetic */ void a(com.google.firebase.a.a aVar) {
        boolean z = ((com.google.firebase.a) aVar.f37938b).f37936a;
        synchronized (b.class) {
            AppMeasurement appMeasurement = ((b) f37969b).f37971c;
            if (appMeasurement.f11674c) {
                appMeasurement.f11673b.a(z);
            } else {
                appMeasurement.f11672a.d().b(z);
            }
        }
    }
}
