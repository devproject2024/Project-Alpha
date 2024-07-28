package com.google.android.gms.internal.measurement;

public final class hr implements ht {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10733a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Long> f10734b;

    public final boolean a() {
        return f10733a.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10733a = bd.a(bjVar, "measurement.app_launch.event_ordering_fix", false);
        f10734b = bd.a(bjVar, "measurement.id.app_launch.event_ordering_fix", 0);
    }
}
