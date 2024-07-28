package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.gg;
import java.io.IOException;

final class iz extends ix<ja, ja> {
    iz() {
    }

    /* access modifiers changed from: package-private */
    public final void b(Object obj) {
        ((gg) obj).zzclj.f10025e = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int d(Object obj) {
        return ((ja) obj).b();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int c(Object obj) {
        ja jaVar = (ja) obj;
        int i2 = jaVar.f10024d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < jaVar.f10021a; i4++) {
            i3 += ft.d(jaVar.f10022b[i4] >>> 3, (fh) jaVar.f10023c[i4]);
        }
        jaVar.f10024d = i3;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object b(Object obj, Object obj2) {
        ja jaVar = (ja) obj;
        ja jaVar2 = (ja) obj2;
        if (jaVar2.equals(ja.a())) {
            return jaVar;
        }
        return ja.a(jaVar, jaVar2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, s sVar) throws IOException {
        ja jaVar = (ja) obj;
        if (sVar.a() == gg.e.k) {
            for (int i2 = jaVar.f10021a - 1; i2 >= 0; i2--) {
                sVar.a(jaVar.f10022b[i2] >>> 3, jaVar.f10023c[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < jaVar.f10021a; i3++) {
            sVar.a(jaVar.f10022b[i3] >>> 3, jaVar.f10023c[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, s sVar) throws IOException {
        ((ja) obj).a(sVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(Object obj) {
        return ((gg) obj).zzclj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, Object obj2) {
        ((gg) obj).zzclj = (ja) obj2;
    }
}
