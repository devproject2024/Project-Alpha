package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.gg;

final class he implements ij {

    /* renamed from: b  reason: collision with root package name */
    private static final ho f9955b = new hd();

    /* renamed from: a  reason: collision with root package name */
    private final ho f9956a;

    public he() {
        this(new hg(gh.a(), a()));
    }

    private he(ho hoVar) {
        this.f9956a = (ho) gk.a(hoVar, "messageInfoFactory");
    }

    public final <T> ig<T> a(Class<T> cls) {
        ii.a((Class<?>) cls);
        hl b2 = this.f9956a.b(cls);
        if (b2.b()) {
            if (gg.class.isAssignableFrom(cls)) {
                return ht.a(ii.c(), ga.a(), b2.c());
            }
            return ht.a(ii.a(), ga.b(), b2.c());
        } else if (gg.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return hr.a(b2, hw.b(), gy.b(), ii.c(), ga.a(), hm.b());
            }
            return hr.a(b2, hw.b(), gy.b(), ii.c(), (fy<?>) null, hm.b());
        } else if (a(b2)) {
            return hr.a(b2, hw.a(), gy.a(), ii.a(), ga.b(), hm.a());
        } else {
            return hr.a(b2, hw.a(), gy.a(), ii.b(), (fy<?>) null, hm.a());
        }
    }

    private static boolean a(hl hlVar) {
        return hlVar.a() == gg.e.f9929h;
    }

    private static ho a() {
        try {
            return (ho) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f9955b;
        }
    }
}
