package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-perf.gi  reason: invalid package */
final class gi extends gg<gf, gf> {
    gi() {
    }

    /* access modifiers changed from: package-private */
    public final void b(Object obj) {
        ((dq) obj).zzqw.f9668e = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int d(Object obj) {
        return ((gf) obj).b();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int c(Object obj) {
        gf gfVar = (gf) obj;
        int i2 = gfVar.f9667d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < gfVar.f9664a; i4++) {
            i3 += da.d(gfVar.f9665b[i4] >>> 3, (co) gfVar.f9666c[i4]);
        }
        gfVar.f9667d = i3;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object b(Object obj, Object obj2) {
        gf gfVar = (gf) obj;
        gf gfVar2 = (gf) obj2;
        if (gfVar2.equals(gf.a())) {
            return gfVar;
        }
        return gf.a(gfVar, gfVar2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, ha haVar) throws IOException {
        gf gfVar = (gf) obj;
        if (haVar.a() == dq.d.k) {
            for (int i2 = gfVar.f9664a - 1; i2 >= 0; i2--) {
                haVar.a(gfVar.f9665b[i2] >>> 3, gfVar.f9666c[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < gfVar.f9664a; i3++) {
            haVar.a(gfVar.f9665b[i3] >>> 3, gfVar.f9666c[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, ha haVar) throws IOException {
        ((gf) obj).a(haVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(Object obj) {
        return ((dq) obj).zzqw;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, Object obj2) {
        ((dq) obj).zzqw = (gf) obj2;
    }
}
