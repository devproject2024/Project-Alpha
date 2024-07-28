package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.dv;

final class es implements fy {

    /* renamed from: b  reason: collision with root package name */
    private static final fc f10628b = new ev();

    /* renamed from: a  reason: collision with root package name */
    private final fc f10629a;

    public es() {
        this(new eu(dw.a(), a()));
    }

    private es(fc fcVar) {
        this.f10629a = (fc) dx.a(fcVar, "messageInfoFactory");
    }

    public final <T> fv<T> a(Class<T> cls) {
        fx.a((Class<?>) cls);
        fd b2 = this.f10629a.b(cls);
        if (b2.b()) {
            if (dv.class.isAssignableFrom(cls)) {
                return fl.a(fx.c(), dk.a(), b2.c());
            }
            return fl.a(fx.a(), dk.b(), b2.c());
        } else if (dv.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return fj.a(b2, fp.b(), eo.b(), fx.c(), dk.a(), fa.b());
            }
            return fj.a(b2, fp.b(), eo.b(), fx.c(), (dj<?>) null, fa.b());
        } else if (a(b2)) {
            return fj.a(b2, fp.a(), eo.a(), fx.a(), dk.b(), fa.a());
        } else {
            return fj.a(b2, fp.a(), eo.a(), fx.b(), (dj<?>) null, fa.a());
        }
    }

    private static boolean a(fd fdVar) {
        return fdVar.a() == dv.d.f10603h;
    }

    private static fc a() {
        try {
            return (fc) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f10628b;
        }
    }
}
