package com.google.android.gms.internal.measurement;

public final class ji implements jf {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10795a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Long> f10796b;

    public final boolean a() {
        return f10795a.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10795a = bd.a(bjVar, "measurement.service.fix_gmp_version", false);
        f10796b = bd.a(bjVar, "measurement.id.service.fix_gmp_version", 0);
    }
}
