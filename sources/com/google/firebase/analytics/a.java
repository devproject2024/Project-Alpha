package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.c;
import com.google.android.gms.internal.measurement.e;
import com.google.android.gms.internal.measurement.f;
import com.google.android.gms.internal.measurement.g;
import com.google.android.gms.internal.measurement.h;
import com.google.android.gms.internal.measurement.i;
import com.google.android.gms.internal.measurement.it;
import com.google.android.gms.internal.measurement.k;
import com.google.android.gms.internal.measurement.l;
import com.google.android.gms.internal.measurement.mk;
import com.google.android.gms.internal.measurement.mm;
import com.google.android.gms.internal.measurement.n;
import com.google.android.gms.internal.measurement.o;
import com.google.android.gms.internal.measurement.p;
import com.google.android.gms.internal.measurement.q;
import com.google.android.gms.internal.measurement.s;
import com.google.android.gms.internal.measurement.t;
import com.google.android.gms.measurement.internal.gb;
import com.google.android.gms.measurement.internal.hd;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class a implements hd {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ mk f37959a;

    a(mk mkVar) {
        this.f37959a = mkVar;
    }

    public final void a(String str, String str2, Bundle bundle) {
        mk mkVar = this.f37959a;
        mkVar.a((mk.a) new s(mkVar, str, str2, bundle));
    }

    public final void a(String str, String str2, Object obj) {
        mk mkVar = this.f37959a;
        mkVar.a((mk.a) new q(mkVar, str, str2, obj));
    }

    public final void a(boolean z) {
        mk mkVar = this.f37959a;
        mkVar.a((mk.a) new p(mkVar, z));
    }

    public final Map<String, Object> a(String str, String str2, boolean z) {
        mk mkVar = this.f37959a;
        it itVar = new it();
        mkVar.a((mk.a) new k(mkVar, str, str2, z, itVar));
        Bundle b2 = itVar.b(5000);
        if (b2 == null || b2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(b2.size());
        for (String str3 : b2.keySet()) {
            Object obj = b2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void a(gb gbVar) {
        mk mkVar = this.f37959a;
        com.google.android.gms.common.internal.s.a(gbVar);
        mkVar.a((mk.a) new o(mkVar, gbVar));
    }

    public final String a() {
        mk mkVar = this.f37959a;
        it itVar = new it();
        mkVar.a((mk.a) new i(mkVar, itVar));
        return itVar.a(500);
    }

    public final String b() {
        mk mkVar = this.f37959a;
        it itVar = new it();
        mkVar.a((mk.a) new l(mkVar, itVar));
        return itVar.a(500);
    }

    public final String c() {
        mk mkVar = this.f37959a;
        it itVar = new it();
        mkVar.a((mk.a) new g(mkVar, itVar));
        return itVar.a(50);
    }

    public final String d() {
        mk mkVar = this.f37959a;
        it itVar = new it();
        mkVar.a((mk.a) new h(mkVar, itVar));
        return itVar.a(500);
    }

    public final long e() {
        return this.f37959a.a();
    }

    public final void a(String str) {
        mk mkVar = this.f37959a;
        mkVar.a((mk.a) new e(mkVar, str));
    }

    public final void b(String str) {
        mk mkVar = this.f37959a;
        mkVar.a((mk.a) new f(mkVar, str));
    }

    public final void a(Bundle bundle) {
        mk mkVar = this.f37959a;
        mkVar.a((mk.a) new t(mkVar, bundle));
    }

    public final void b(String str, String str2, Bundle bundle) {
        mk mkVar = this.f37959a;
        mkVar.a((mk.a) new mm(mkVar, str, str2, bundle));
    }

    public final List<Bundle> a(String str, String str2) {
        mk mkVar = this.f37959a;
        it itVar = new it();
        mkVar.a((mk.a) new c(mkVar, str, str2, itVar));
        List<Bundle> list = (List) it.a(itVar.b(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final int c(String str) {
        mk mkVar = this.f37959a;
        it itVar = new it();
        mkVar.a((mk.a) new n(mkVar, str, itVar));
        Integer num = (Integer) it.a(itVar.b(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }
}
