package com.google.android.gms.internal.measurement;

public final class ln implements lo {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10883a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Boolean> f10884b;

    /* renamed from: c  reason: collision with root package name */
    private static final bd<Boolean> f10885c;

    /* renamed from: d  reason: collision with root package name */
    private static final bd<Boolean> f10886d;

    public final boolean a() {
        return f10883a.c().booleanValue();
    }

    public final boolean b() {
        return f10885c.c().booleanValue();
    }

    public final boolean c() {
        return f10886d.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10883a = bd.a(bjVar, "measurement.client.sessions.background_sessions_enabled", true);
        f10884b = bd.a(bjVar, "measurement.client.sessions.immediate_start_enabled_foreground", true);
        f10885c = bd.a(bjVar, "measurement.client.sessions.remove_expired_session_properties_enabled", true);
        f10886d = bd.a(bjVar, "measurement.client.sessions.session_id_enabled", true);
    }
}
