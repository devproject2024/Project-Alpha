package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.bv;

final class ct implements du {

    /* renamed from: b  reason: collision with root package name */
    private static final da f10142b = new cs();

    /* renamed from: a  reason: collision with root package name */
    private final da f10143a;

    public ct() {
        this(new cv(bw.a(), a()));
    }

    private ct(da daVar) {
        this.f10143a = (da) bx.a(daVar, "messageInfoFactory");
    }

    public final <T> dr<T> a(Class<T> cls) {
        dt.a((Class<?>) cls);
        db b2 = this.f10143a.b(cls);
        if (b2.b()) {
            if (bv.class.isAssignableFrom(cls)) {
                return dh.a(dt.c(), bn.a(), b2.c());
            }
            return dh.a(dt.a(), bn.b(), b2.c());
        } else if (bv.class.isAssignableFrom(cls)) {
            if (a(b2)) {
                return di.a(b2, dl.b(), cn.b(), dt.c(), bn.a(), cy.b());
            }
            return di.a(b2, dl.b(), cn.b(), dt.c(), (bl<?>) null, cy.b());
        } else if (a(b2)) {
            return di.a(b2, dl.a(), cn.a(), dt.a(), bn.b(), cy.a());
        } else {
            return di.a(b2, dl.a(), cn.a(), dt.b(), (bl<?>) null, cy.a());
        }
    }

    private static boolean a(db dbVar) {
        return dbVar.a() == bv.c.f10116h;
    }

    private static da a() {
        try {
            return (da) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f10142b;
        }
    }
}
