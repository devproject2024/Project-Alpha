package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.dv;
import java.io.IOException;

final class go extends gm<gp, gp> {
    go() {
    }

    private static void a(Object obj, gp gpVar) {
        ((dv) obj).zzb = gpVar;
    }

    /* access modifiers changed from: package-private */
    public final void d(Object obj) {
        ((dv) obj).zzb.f10704e = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int f(Object obj) {
        return ((gp) obj).c();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int e(Object obj) {
        gp gpVar = (gp) obj;
        int i2 = gpVar.f10703d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < gpVar.f10700a; i4++) {
            i3 += de.d(gpVar.f10701b[i4] >>> 3, (cm) gpVar.f10702c[i4]);
        }
        gpVar.f10703d = i3;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object c(Object obj, Object obj2) {
        gp gpVar = (gp) obj;
        gp gpVar2 = (gp) obj2;
        if (gpVar2.equals(gp.a())) {
            return gpVar;
        }
        return gp.a(gpVar, gpVar2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, hk hkVar) throws IOException {
        gp gpVar = (gp) obj;
        if (hkVar.a() == dv.d.k) {
            for (int i2 = gpVar.f10700a - 1; i2 >= 0; i2--) {
                hkVar.a(gpVar.f10701b[i2] >>> 3, gpVar.f10702c[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < gpVar.f10700a; i3++) {
            hkVar.a(gpVar.f10701b[i3] >>> 3, gpVar.f10702c[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, hk hkVar) throws IOException {
        ((gp) obj).a(hkVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, Object obj2) {
        a(obj, (gp) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object c(Object obj) {
        gp gpVar = ((dv) obj).zzb;
        if (gpVar != gp.a()) {
            return gpVar;
        }
        gp b2 = gp.b();
        a(obj, b2);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object b(Object obj) {
        return ((dv) obj).zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        a(obj, (gp) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(Object obj) {
        gp gpVar = (gp) obj;
        gpVar.f10704e = false;
        return gpVar;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a() {
        return gp.b();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, Object obj2) {
        ((gp) obj).a((i2 << 3) | 3, (Object) (gp) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, cm cmVar) {
        ((gp) obj).a((i2 << 3) | 2, (Object) cmVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, int i2, long j) {
        ((gp) obj).a((i2 << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, int i3) {
        ((gp) obj).a((i2 << 3) | 5, (Object) Integer.valueOf(i3));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, long j) {
        ((gp) obj).a(i2 << 3, (Object) Long.valueOf(j));
    }
}
