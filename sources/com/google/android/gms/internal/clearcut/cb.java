package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;

final class cb implements df {

    /* renamed from: b  reason: collision with root package name */
    private static final cl f9237b = new cc();

    /* renamed from: a  reason: collision with root package name */
    private final cl f9238a;

    public cb() {
        this(new cd(be.a(), a()));
    }

    private cb(cl clVar) {
        this.f9238a = (cl) bh.a(clVar, "messageInfoFactory");
    }

    private static cl a() {
        try {
            return (cl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return f9237b;
        }
    }

    private static boolean a(ck ckVar) {
        return ckVar.a() == bf.g.f9203h;
    }

    public final <T> de<T> a(Class<T> cls) {
        dg.a((Class<?>) cls);
        ck b2 = this.f9238a.b(cls);
        if (b2.b()) {
            return bf.class.isAssignableFrom(cls) ? cs.a(dg.c(), av.a(), b2.c()) : cs.a(dg.a(), av.b(), b2.c());
        }
        if (bf.class.isAssignableFrom(cls)) {
            boolean a2 = a(b2);
            cu b3 = cw.b();
            bw b4 = bw.b();
            dv<?, ?> c2 = dg.c();
            return a2 ? cq.a(b2, b3, b4, c2, av.a(), cj.b()) : cq.a(b2, b3, b4, c2, (as<?>) null, cj.b());
        }
        boolean a3 = a(b2);
        cu a4 = cw.a();
        bw a5 = bw.a();
        return a3 ? cq.a(b2, a4, a5, dg.a(), av.b(), cj.a()) : cq.a(b2, a4, a5, dg.b(), (as<?>) null, cj.a());
    }
}
