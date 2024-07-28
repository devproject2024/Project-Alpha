package com.google.android.gms.internal.measurement;

public final class lm implements lj {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10880a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Boolean> f10881b;

    /* renamed from: c  reason: collision with root package name */
    private static final bd<Boolean> f10882c;

    public final boolean a() {
        return f10880a.c().booleanValue();
    }

    public final boolean b() {
        return f10881b.c().booleanValue();
    }

    public final boolean c() {
        return f10882c.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10880a = bd.a(bjVar, "measurement.service.sessions.remove_disabled_session_number", true);
        f10881b = bd.a(bjVar, "measurement.service.sessions.session_number_enabled", true);
        f10882c = bd.a(bjVar, "measurement.service.sessions.session_number_backfill_enabled", true);
    }
}
