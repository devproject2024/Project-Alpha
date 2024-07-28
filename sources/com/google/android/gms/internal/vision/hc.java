package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.ej;
import java.io.IOException;

final class hc extends ha<hd, hd> {
    hc() {
    }

    private static void a(Object obj, hd hdVar) {
        ((ej) obj).zzwj = hdVar;
    }

    /* access modifiers changed from: package-private */
    public final void d(Object obj) {
        ((ej) obj).zzwj.f11210e = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int f(Object obj) {
        return ((hd) obj).c();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int e(Object obj) {
        hd hdVar = (hd) obj;
        int i2 = hdVar.f11209d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < hdVar.f11206a; i4++) {
            i3 += dr.d(hdVar.f11207b[i4] >>> 3, (cz) hdVar.f11208c[i4]);
        }
        hdVar.f11209d = i3;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object c(Object obj, Object obj2) {
        hd hdVar = (hd) obj;
        hd hdVar2 = (hd) obj2;
        if (hdVar2.equals(hd.a())) {
            return hdVar;
        }
        return hd.a(hdVar, hdVar2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, hx hxVar) throws IOException {
        hd hdVar = (hd) obj;
        if (hxVar.a() == ej.e.k) {
            for (int i2 = hdVar.f11206a - 1; i2 >= 0; i2--) {
                hxVar.a(hdVar.f11207b[i2] >>> 3, hdVar.f11208c[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < hdVar.f11206a; i3++) {
            hxVar.a(hdVar.f11207b[i3] >>> 3, hdVar.f11208c[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, hx hxVar) throws IOException {
        ((hd) obj).a(hxVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, Object obj2) {
        a(obj, (hd) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object c(Object obj) {
        hd hdVar = ((ej) obj).zzwj;
        if (hdVar != hd.a()) {
            return hdVar;
        }
        hd b2 = hd.b();
        a(obj, b2);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object b(Object obj) {
        return ((ej) obj).zzwj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, Object obj2) {
        a(obj, (hd) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(Object obj) {
        hd hdVar = (hd) obj;
        hdVar.f11210e = false;
        return hdVar;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a() {
        return hd.b();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, Object obj2) {
        ((hd) obj).a((i2 << 3) | 3, (Object) (hd) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, cz czVar) {
        ((hd) obj).a((i2 << 3) | 2, (Object) czVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, int i2, long j) {
        ((hd) obj).a((i2 << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, int i3) {
        ((hd) obj).a((i2 << 3) | 5, (Object) Integer.valueOf(i3));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, long j) {
        ((hd) obj).a(i2 << 3, (Object) Long.valueOf(j));
    }
}
