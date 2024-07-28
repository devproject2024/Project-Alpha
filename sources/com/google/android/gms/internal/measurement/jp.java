package com.google.android.gms.internal.measurement;

public final class jp implements jq {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10803a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Boolean> f10804b;

    /* renamed from: c  reason: collision with root package name */
    private static final bd<Boolean> f10805c;

    public final boolean a() {
        return f10803a.c().booleanValue();
    }

    public final boolean b() {
        return f10804b.c().booleanValue();
    }

    public final boolean c() {
        return f10805c.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10803a = bd.a(bjVar, "measurement.client.sessions.check_on_reset_and_enable", false);
        f10804b = bd.a(bjVar, "measurement.client.sessions.check_on_startup", true);
        f10805c = bd.a(bjVar, "measurement.client.sessions.start_session_before_view_screen", true);
    }
}
