package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.ej;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class dy extends dw<ej.c> {
    dy() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ft ftVar) {
        return ftVar instanceof ej.d;
    }

    /* access modifiers changed from: package-private */
    public final dz<ej.c> a(Object obj) {
        return ((ej.d) obj).zzwq;
    }

    /* access modifiers changed from: package-private */
    public final dz<ej.c> b(Object obj) {
        return ((ej.d) obj).a();
    }

    /* access modifiers changed from: package-private */
    public final void c(Object obj) {
        a(obj).b();
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB a(gj gjVar, Object obj, du duVar, dz<ej.c> dzVar, UB ub, ha<UT, UB> haVar) throws IOException {
        Object a2;
        ArrayList arrayList;
        ej.f fVar = (ej.f) obj;
        int i2 = fVar.f11110b.f11096b;
        if (!fVar.f11110b.f11098d || !fVar.f11110b.f11099e) {
            Object obj2 = null;
            if (fVar.f11110b.f11097c != hs.ENUM) {
                switch (dx.f11073a[fVar.f11110b.f11097c.ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(gjVar.d());
                        break;
                    case 2:
                        obj2 = Float.valueOf(gjVar.e());
                        break;
                    case 3:
                        obj2 = Long.valueOf(gjVar.g());
                        break;
                    case 4:
                        obj2 = Long.valueOf(gjVar.f());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(gjVar.h());
                        break;
                    case 6:
                        obj2 = Long.valueOf(gjVar.i());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(gjVar.j());
                        break;
                    case 8:
                        obj2 = Boolean.valueOf(gjVar.k());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(gjVar.o());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(gjVar.q());
                        break;
                    case 11:
                        obj2 = Long.valueOf(gjVar.r());
                        break;
                    case 12:
                        obj2 = Integer.valueOf(gjVar.s());
                        break;
                    case 13:
                        obj2 = Long.valueOf(gjVar.t());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj2 = gjVar.n();
                        break;
                    case 16:
                        obj2 = gjVar.l();
                        break;
                    case 17:
                        obj2 = gjVar.b(fVar.f11109a.getClass(), duVar);
                        break;
                    case 18:
                        obj2 = gjVar.a(fVar.f11109a.getClass(), duVar);
                        break;
                }
            } else {
                int h2 = gjVar.h();
                if (fVar.f11110b.f11095a.a(h2) == null) {
                    return gk.a(i2, h2, ub, haVar);
                }
                obj2 = Integer.valueOf(h2);
            }
            if (fVar.f11110b.f11098d) {
                dzVar.b(fVar.f11110b, (Object) obj2);
            } else {
                int i3 = dx.f11073a[fVar.f11110b.f11097c.ordinal()];
                if ((i3 == 17 || i3 == 18) && (a2 = dzVar.a(fVar.f11110b)) != null) {
                    obj2 = ek.a(a2, (Object) obj2);
                }
                dzVar.a(fVar.f11110b, (Object) obj2);
            }
        } else {
            switch (dx.f11073a[fVar.f11110b.f11097c.ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    gjVar.a(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    gjVar.b(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    gjVar.d(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    gjVar.c(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    gjVar.e(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    gjVar.f(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    gjVar.g(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    gjVar.h(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    gjVar.l(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    gjVar.n(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    gjVar.o(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    gjVar.p(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    gjVar.q(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    gjVar.m(arrayList);
                    ub = gk.a(i2, (List<Integer>) arrayList, fVar.f11110b.f11095a, ub, haVar);
                    break;
                default:
                    String valueOf = String.valueOf(fVar.f11110b.f11097c);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                    sb.append("Type cannot be packed: ");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
            }
            dzVar.a(fVar.f11110b, (Object) arrayList);
        }
        return ub;
    }

    /* access modifiers changed from: package-private */
    public final int a(Map.Entry<?, ?> entry) {
        return ((ej.c) entry.getKey()).f11096b;
    }

    /* access modifiers changed from: package-private */
    public final void a(hx hxVar, Map.Entry<?, ?> entry) throws IOException {
        ej.c cVar = (ej.c) entry.getKey();
        if (cVar.f11098d) {
            switch (dx.f11073a[cVar.f11097c.ordinal()]) {
                case 1:
                    gk.a(cVar.f11096b, (List<Double>) (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 2:
                    gk.b(cVar.f11096b, (List<Float>) (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 3:
                    gk.c(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 4:
                    gk.d(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 5:
                    gk.h(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 6:
                    gk.f(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 7:
                    gk.k(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 8:
                    gk.n(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 9:
                    gk.i(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 10:
                    gk.l(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 11:
                    gk.g(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 12:
                    gk.j(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 13:
                    gk.e(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 14:
                    gk.h(cVar.f11096b, (List) entry.getValue(), hxVar, cVar.f11099e);
                    return;
                case 15:
                    gk.b(cVar.f11096b, (List<cz>) (List) entry.getValue(), hxVar);
                    return;
                case 16:
                    gk.a(cVar.f11096b, (List<String>) (List) entry.getValue(), hxVar);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        gk.b(cVar.f11096b, (List<?>) (List) entry.getValue(), hxVar, (gi) ge.a().a(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        gk.a(cVar.f11096b, (List<?>) (List) entry.getValue(), hxVar, (gi) ge.a().a(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (dx.f11073a[cVar.f11097c.ordinal()]) {
                case 1:
                    hxVar.a(cVar.f11096b, ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    hxVar.a(cVar.f11096b, ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    hxVar.a(cVar.f11096b, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    hxVar.c(cVar.f11096b, ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    hxVar.c(cVar.f11096b, ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    hxVar.d(cVar.f11096b, ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    hxVar.d(cVar.f11096b, ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    hxVar.a(cVar.f11096b, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    hxVar.e(cVar.f11096b, ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    hxVar.a(cVar.f11096b, ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    hxVar.b(cVar.f11096b, ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    hxVar.f(cVar.f11096b, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    hxVar.e(cVar.f11096b, ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    hxVar.c(cVar.f11096b, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    hxVar.a(cVar.f11096b, (cz) entry.getValue());
                    return;
                case 16:
                    hxVar.a(cVar.f11096b, (String) entry.getValue());
                    return;
                case 17:
                    hxVar.b(cVar.f11096b, (Object) entry.getValue(), (gi) ge.a().a(entry.getValue().getClass()));
                    return;
                case 18:
                    hxVar.a(cVar.f11096b, (Object) entry.getValue(), (gi) ge.a().a(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object a(du duVar, ft ftVar, int i2) {
        return duVar.a(ftVar, i2);
    }

    /* access modifiers changed from: package-private */
    public final void a(gj gjVar, Object obj, du duVar, dz<ej.c> dzVar) throws IOException {
        ej.f fVar = (ej.f) obj;
        dzVar.a(fVar.f11110b, (Object) gjVar.a(fVar.f11109a.getClass(), duVar));
    }

    /* access modifiers changed from: package-private */
    public final void a(cz czVar, Object obj, du duVar, dz<ej.c> dzVar) throws IOException {
        byte[] bArr;
        ej.f fVar = (ej.f) obj;
        ft c2 = fVar.f11109a.j().c();
        int size = czVar.size();
        if (size == 0) {
            bArr = ek.f11112b;
        } else {
            byte[] bArr2 = new byte[size];
            czVar.zza(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            cy cyVar = new cy(wrap);
            ge.a().a(c2).a(c2, cyVar, duVar);
            dzVar.a(fVar.f11110b, (Object) c2);
            if (cyVar.a() != Integer.MAX_VALUE) {
                throw eu.zzgq();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
