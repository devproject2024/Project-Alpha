package com.google.c;

import com.google.c.aa;
import com.google.c.bz;
import com.google.c.f;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class t extends s<aa.e> {
    t() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(at atVar) {
        return atVar instanceof aa.c;
    }

    /* access modifiers changed from: package-private */
    public final w<aa.e> a(Object obj) {
        return ((aa.c) obj).f37686a;
    }

    /* access modifiers changed from: package-private */
    public final w<aa.e> b(Object obj) {
        return ((aa.c) obj).a();
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB a(bk bkVar, Object obj, r rVar, w<aa.e> wVar, UB ub, bt<UT, UB> btVar) throws IOException {
        Object a2;
        ArrayList arrayList;
        aa.f fVar = (aa.f) obj;
        int i2 = fVar.f37693b.f37688b;
        if (!fVar.f37693b.f37690d || !fVar.f37693b.f37691e) {
            Object obj2 = null;
            if (fVar.f37693b.f37689c != bz.a.ENUM) {
                switch (fVar.f37693b.f37689c) {
                    case DOUBLE:
                        obj2 = Double.valueOf(bkVar.d());
                        break;
                    case FLOAT:
                        obj2 = Float.valueOf(bkVar.e());
                        break;
                    case INT64:
                        obj2 = Long.valueOf(bkVar.g());
                        break;
                    case UINT64:
                        obj2 = Long.valueOf(bkVar.f());
                        break;
                    case INT32:
                        obj2 = Integer.valueOf(bkVar.h());
                        break;
                    case FIXED64:
                        obj2 = Long.valueOf(bkVar.i());
                        break;
                    case FIXED32:
                        obj2 = Integer.valueOf(bkVar.j());
                        break;
                    case BOOL:
                        obj2 = Boolean.valueOf(bkVar.k());
                        break;
                    case UINT32:
                        obj2 = Integer.valueOf(bkVar.o());
                        break;
                    case SFIXED32:
                        obj2 = Integer.valueOf(bkVar.q());
                        break;
                    case SFIXED64:
                        obj2 = Long.valueOf(bkVar.r());
                        break;
                    case SINT32:
                        obj2 = Integer.valueOf(bkVar.s());
                        break;
                    case SINT64:
                        obj2 = Long.valueOf(bkVar.t());
                        break;
                    case ENUM:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case BYTES:
                        obj2 = bkVar.n();
                        break;
                    case STRING:
                        obj2 = bkVar.l();
                        break;
                    case GROUP:
                        obj2 = bkVar.b(fVar.f37692a.getClass(), rVar);
                        break;
                    case MESSAGE:
                        obj2 = bkVar.a(fVar.f37692a.getClass(), rVar);
                        break;
                }
            } else {
                int h2 = bkVar.h();
                if (fVar.f37693b.f37687a.a() == null) {
                    return bo.a(i2, h2, ub, btVar);
                }
                obj2 = Integer.valueOf(h2);
            }
            if (fVar.f37693b.f37690d) {
                wVar.b(fVar.f37693b, (Object) obj2);
            } else {
                int i3 = AnonymousClass1.f37911a[fVar.f37693b.f37689c.ordinal()];
                if ((i3 == 17 || i3 == 18) && (a2 = wVar.a(fVar.f37693b)) != null) {
                    obj2 = ac.a(a2, (Object) obj2);
                }
                wVar.a(fVar.f37693b, (Object) obj2);
            }
        } else {
            switch (fVar.f37693b.f37689c) {
                case DOUBLE:
                    arrayList = new ArrayList();
                    bkVar.a(arrayList);
                    break;
                case FLOAT:
                    arrayList = new ArrayList();
                    bkVar.b(arrayList);
                    break;
                case INT64:
                    arrayList = new ArrayList();
                    bkVar.d(arrayList);
                    break;
                case UINT64:
                    arrayList = new ArrayList();
                    bkVar.c(arrayList);
                    break;
                case INT32:
                    arrayList = new ArrayList();
                    bkVar.e(arrayList);
                    break;
                case FIXED64:
                    arrayList = new ArrayList();
                    bkVar.f(arrayList);
                    break;
                case FIXED32:
                    arrayList = new ArrayList();
                    bkVar.g(arrayList);
                    break;
                case BOOL:
                    arrayList = new ArrayList();
                    bkVar.h(arrayList);
                    break;
                case UINT32:
                    arrayList = new ArrayList();
                    bkVar.l(arrayList);
                    break;
                case SFIXED32:
                    arrayList = new ArrayList();
                    bkVar.n(arrayList);
                    break;
                case SFIXED64:
                    arrayList = new ArrayList();
                    bkVar.o(arrayList);
                    break;
                case SINT32:
                    arrayList = new ArrayList();
                    bkVar.p(arrayList);
                    break;
                case SINT64:
                    arrayList = new ArrayList();
                    bkVar.q(arrayList);
                    break;
                case ENUM:
                    arrayList = new ArrayList();
                    bkVar.m(arrayList);
                    ub = bo.a(i2, (List<Integer>) arrayList, fVar.f37693b.f37687a, ub, btVar);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + fVar.f37693b.f37689c);
            }
            wVar.a(fVar.f37693b, (Object) arrayList);
        }
        return ub;
    }

    /* access modifiers changed from: package-private */
    public final int a(Map.Entry<?, ?> entry) {
        return ((aa.e) entry.getKey()).f37688b;
    }

    /* access modifiers changed from: package-private */
    public final void a(ca caVar, Map.Entry<?, ?> entry) throws IOException {
        aa.e eVar = (aa.e) entry.getKey();
        if (eVar.f37690d) {
            switch (eVar.f37689c) {
                case DOUBLE:
                    bo.a(eVar.f37688b, (List<Double>) (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case FLOAT:
                    bo.b(eVar.f37688b, (List<Float>) (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case INT64:
                    bo.c(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case UINT64:
                    bo.d(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case INT32:
                    bo.h(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case FIXED64:
                    bo.f(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case FIXED32:
                    bo.k(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case BOOL:
                    bo.n(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case UINT32:
                    bo.i(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case SFIXED32:
                    bo.l(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case SFIXED64:
                    bo.g(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case SINT32:
                    bo.j(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case SINT64:
                    bo.e(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case ENUM:
                    bo.h(eVar.f37688b, (List) entry.getValue(), caVar, eVar.f37691e);
                    return;
                case BYTES:
                    bo.b(eVar.f37688b, (List<j>) (List) entry.getValue(), caVar);
                    return;
                case STRING:
                    bo.a(eVar.f37688b, (List<String>) (List) entry.getValue(), caVar);
                    return;
                case GROUP:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        bo.b(eVar.f37688b, (List<?>) (List) entry.getValue(), caVar, (bm) bg.a().a(list.get(0).getClass()));
                        return;
                    }
                    return;
                case MESSAGE:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        bo.a(eVar.f37688b, (List<?>) (List) entry.getValue(), caVar, (bm) bg.a().a(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (eVar.f37689c) {
                case DOUBLE:
                    caVar.a(eVar.f37688b, ((Double) entry.getValue()).doubleValue());
                    return;
                case FLOAT:
                    caVar.a(eVar.f37688b, ((Float) entry.getValue()).floatValue());
                    return;
                case INT64:
                    caVar.a(eVar.f37688b, ((Long) entry.getValue()).longValue());
                    return;
                case UINT64:
                    caVar.c(eVar.f37688b, ((Long) entry.getValue()).longValue());
                    return;
                case INT32:
                    caVar.c(eVar.f37688b, ((Integer) entry.getValue()).intValue());
                    return;
                case FIXED64:
                    caVar.d(eVar.f37688b, ((Long) entry.getValue()).longValue());
                    return;
                case FIXED32:
                    caVar.d(eVar.f37688b, ((Integer) entry.getValue()).intValue());
                    return;
                case BOOL:
                    caVar.a(eVar.f37688b, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case UINT32:
                    caVar.e(eVar.f37688b, ((Integer) entry.getValue()).intValue());
                    return;
                case SFIXED32:
                    caVar.a(eVar.f37688b, ((Integer) entry.getValue()).intValue());
                    return;
                case SFIXED64:
                    caVar.b(eVar.f37688b, ((Long) entry.getValue()).longValue());
                    return;
                case SINT32:
                    caVar.f(eVar.f37688b, ((Integer) entry.getValue()).intValue());
                    return;
                case SINT64:
                    caVar.e(eVar.f37688b, ((Long) entry.getValue()).longValue());
                    return;
                case ENUM:
                    caVar.c(eVar.f37688b, ((Integer) entry.getValue()).intValue());
                    return;
                case BYTES:
                    caVar.a(eVar.f37688b, (j) entry.getValue());
                    return;
                case STRING:
                    caVar.a(eVar.f37688b, (String) entry.getValue());
                    return;
                case GROUP:
                    caVar.b(eVar.f37688b, (Object) entry.getValue(), (bm) bg.a().a(entry.getValue().getClass()));
                    return;
                case MESSAGE:
                    caVar.a(eVar.f37688b, (Object) entry.getValue(), (bm) bg.a().a(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object a(r rVar, at atVar, int i2) {
        return rVar.a(atVar, i2);
    }

    /* access modifiers changed from: package-private */
    public final void a(bk bkVar, Object obj, r rVar, w<aa.e> wVar) throws IOException {
        aa.f fVar = (aa.f) obj;
        wVar.a(fVar.f37693b, (Object) bkVar.a(fVar.f37692a.getClass(), rVar));
    }

    /* access modifiers changed from: package-private */
    public final void a(j jVar, Object obj, r rVar, w<aa.e> wVar) throws IOException {
        aa.f fVar = (aa.f) obj;
        at b2 = fVar.f37692a.n().b();
        ByteBuffer wrap = ByteBuffer.wrap(jVar.toByteArray());
        if (wrap.hasArray()) {
            f.a aVar = new f.a(wrap);
            bg.a().a(b2).a(b2, aVar, rVar);
            wVar.a(fVar.f37693b, (Object) b2);
            if (aVar.a() != Integer.MAX_VALUE) {
                throw ad.invalidEndTag();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    /* access modifiers changed from: package-private */
    public final void c(Object obj) {
        ((aa.c) obj).f37686a.b();
    }
}
