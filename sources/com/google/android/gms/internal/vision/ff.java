package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.ej;

final class ff implements gl {

    /* renamed from: b  reason: collision with root package name */
    private static final fp f11132b = new fi();

    /* renamed from: a  reason: collision with root package name */
    private final fp f11133a;

    public ff() {
        this(new fh(eh.a(), a()));
    }

    private ff(fp fpVar) {
        this.f11133a = (fp) ek.a(fpVar, "messageInfoFactory");
    }

    public final <T> gi<T> a(Class<T> cls) {
        gk.a((Class<?>) cls);
        fr b2 = this.f11133a.b(cls);
        if (b2.b()) {
            if (ej.class.isAssignableFrom(cls)) {
                return fz.a(gk.c(), ea.a(), b2.c());
            }
            return fz.a(gk.a(), ea.b(), b2.c());
        } else if (ej.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return fx.a(b2, gd.b(), fc.b(), gk.c(), ea.a(), fn.b());
            }
            return fx.a(b2, gd.b(), fc.b(), gk.c(), (dw<?>) null, fn.b());
        } else if (a(b2)) {
            return fx.a(b2, gd.a(), fc.a(), gk.a(), ea.b(), fn.a());
        } else {
            return fx.a(b2, gd.a(), fc.a(), gk.b(), (dw<?>) null, fn.a());
        }
    }

    private static boolean a(fr frVar) {
        return frVar.a() == ej.e.f11107h;
    }

    private static fp a() {
        try {
            return (fp) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f11132b;
        }
    }
}
