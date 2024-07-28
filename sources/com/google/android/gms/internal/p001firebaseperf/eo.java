package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;

/* renamed from: com.google.android.gms.internal.firebase-perf.eo  reason: invalid package */
final class eo implements fo {

    /* renamed from: b  reason: collision with root package name */
    private static final ey f9601b = new en();

    /* renamed from: a  reason: collision with root package name */
    private final ey f9602a;

    public eo() {
        this(new eq(Cdo.a(), a()));
    }

    private eo(ey eyVar) {
        this.f9602a = (ey) dt.a(eyVar, "messageInfoFactory");
    }

    public final <T> fp<T> a(Class<T> cls) {
        fr.a((Class<?>) cls);
        ev b2 = this.f9602a.b(cls);
        if (b2.b()) {
            if (dq.class.isAssignableFrom(cls)) {
                return ff.a(fr.c(), dj.a(), b2.c());
            }
            return ff.a(fr.a(), dj.b(), b2.c());
        } else if (dq.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return fc.a(b2, fj.b(), ei.b(), fr.c(), dj.a(), ew.b());
            }
            return fc.a(b2, fj.b(), ei.b(), fr.c(), (dh<?>) null, ew.b());
        } else if (a(b2)) {
            return fc.a(b2, fj.a(), ei.a(), fr.a(), dj.b(), ew.a());
        } else {
            return fc.a(b2, fj.a(), ei.a(), fr.b(), (dh<?>) null, ew.a());
        }
    }

    private static boolean a(ev evVar) {
        return evVar.a() == dq.d.f9576h;
    }

    private static ey a() {
        try {
            return (ey) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f9601b;
        }
    }
}
