package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.bv;
import java.io.IOException;

final class ek extends ei<el, el> {
    ek() {
    }

    /* access modifiers changed from: package-private */
    public final void b(Object obj) {
        ((bv) obj).zzjt.f10208e = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int d(Object obj) {
        return ((el) obj).b();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int c(Object obj) {
        el elVar = (el) obj;
        int i2 = elVar.f10207d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < elVar.f10204a; i4++) {
            i3 += bf.d(elVar.f10205b[i4] >>> 3, (at) elVar.f10206c[i4]);
        }
        elVar.f10207d = i3;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object b(Object obj, Object obj2) {
        el elVar = (el) obj;
        el elVar2 = (el) obj2;
        if (elVar2.equals(el.a())) {
            return elVar;
        }
        return el.a(elVar, elVar2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, fc fcVar) throws IOException {
        el elVar = (el) obj;
        if (fcVar.a() == bv.c.k) {
            for (int i2 = elVar.f10204a - 1; i2 >= 0; i2--) {
                fcVar.a(elVar.f10205b[i2] >>> 3, elVar.f10206c[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < elVar.f10204a; i3++) {
            fcVar.a(elVar.f10205b[i3] >>> 3, elVar.f10206c[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, fc fcVar) throws IOException {
        ((el) obj).a(fcVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(Object obj) {
        return ((bv) obj).zzjt;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, Object obj2) {
        ((bv) obj).zzjt = (el) obj2;
    }
}
