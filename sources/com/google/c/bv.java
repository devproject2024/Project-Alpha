package com.google.c;

import com.google.c.ca;
import java.io.IOException;

final class bv extends bt<bu, bu> {
    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        bu buVar = (bu) obj;
        buVar.f37809e = false;
        return buVar;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, int i3) {
        ((bu) obj).a(bz.a(i2, 5), (Object) Integer.valueOf(i3));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void a(Object obj, int i2, long j) {
        ((bu) obj).a(bz.a(i2, 0), (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void a(Object obj, int i2, j jVar) {
        ((bu) obj).a(bz.a(i2, 2), (Object) jVar);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void a(Object obj, int i2, Object obj2) {
        ((bu) obj).a(bz.a(i2, 3), (Object) (bu) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void a(Object obj, ca caVar) throws IOException {
        ((bu) obj).a(caVar);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
        a(obj, (bu) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, int i2, long j) {
        ((bu) obj).a(bz.a(i2, 1), (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, ca caVar) throws IOException {
        bu buVar = (bu) obj;
        if (caVar.a() == ca.a.DESCENDING) {
            for (int i2 = buVar.f37805a - 1; i2 >= 0; i2--) {
                caVar.a(bz.b(buVar.f37806b[i2]), buVar.f37807c[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < buVar.f37805a; i3++) {
            caVar.a(bz.b(buVar.f37806b[i3]), buVar.f37807c[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b(Object obj, Object obj2) {
        a(obj, (bu) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object c(Object obj, Object obj2) {
        bu buVar = (bu) obj;
        bu buVar2 = (bu) obj2;
        if (buVar2.equals(bu.a())) {
            return buVar;
        }
        return bu.a(buVar, buVar2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int e(Object obj) {
        bu buVar = (bu) obj;
        int i2 = buVar.f37808d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < buVar.f37805a; i4++) {
            i3 += m.d(bz.b(buVar.f37806b[i4]), (j) buVar.f37807c[i4]);
        }
        buVar.f37808d = i3;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int f(Object obj) {
        return ((bu) obj).c();
    }

    bv() {
    }

    private static void a(Object obj, bu buVar) {
        ((aa) obj).f37680e = buVar;
    }

    /* access modifiers changed from: package-private */
    public final void d(Object obj) {
        ((aa) obj).f37680e.f37809e = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object c(Object obj) {
        bu buVar = ((aa) obj).f37680e;
        if (buVar != bu.a()) {
            return buVar;
        }
        bu b2 = bu.b();
        a(obj, b2);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object b(Object obj) {
        return ((aa) obj).f37680e;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a() {
        return bu.b();
    }
}
