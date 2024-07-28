package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;
import java.io.IOException;

final class dx extends dv<dw, dw> {
    dx() {
    }

    private static void a(Object obj, dw dwVar) {
        ((bf) obj).zzjp = dwVar;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a() {
        return dw.b();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(Object obj) {
        return ((bf) obj).zzjp;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, long j) {
        ((dw) obj).a(i2 << 3, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, ab abVar) {
        ((dw) obj).a((i2 << 3) | 2, (Object) abVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, ep epVar) throws IOException {
        ((dw) obj).a(epVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, Object obj2) {
        a(obj, (dw) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, Object obj2) {
        a(obj, (dw) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object c(Object obj, Object obj2) {
        dw dwVar = (dw) obj;
        dw dwVar2 = (dw) obj2;
        return dwVar2.equals(dw.a()) ? dwVar : dw.a(dwVar, dwVar2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int d(Object obj) {
        return ((dw) obj).c();
    }

    /* access modifiers changed from: package-private */
    public final void b(Object obj) {
        ((bf) obj).zzjp.f9313e = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int c(Object obj) {
        dw dwVar = (dw) obj;
        int i2 = dwVar.f9312d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < dwVar.f9309a; i4++) {
            i3 += am.d(dwVar.f9310b[i4] >>> 3, (ab) dwVar.f9311c[i4]);
        }
        dwVar.f9312d = i3;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, ep epVar) throws IOException {
        dw dwVar = (dw) obj;
        if (epVar.a() == bf.g.k) {
            for (int i2 = dwVar.f9309a - 1; i2 >= 0; i2--) {
                epVar.a(dwVar.f9310b[i2] >>> 3, dwVar.f9311c[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < dwVar.f9309a; i3++) {
            epVar.a(dwVar.f9310b[i3] >>> 3, dwVar.f9311c[i3]);
        }
    }
}
