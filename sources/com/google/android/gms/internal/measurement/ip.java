package com.google.android.gms.internal.measurement;

public final class ip implements im {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10770a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Boolean> f10771b;

    /* renamed from: c  reason: collision with root package name */
    private static final bd<Boolean> f10772c;

    /* renamed from: d  reason: collision with root package name */
    private static final bd<Long> f10773d;

    public final boolean a() {
        return f10770a.c().booleanValue();
    }

    public final boolean b() {
        return f10772c.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10770a = bd.a(bjVar, "measurement.sdk.dynamite.allow_remote_dynamite", false);
        f10771b = bd.a(bjVar, "measurement.collection.init_params_control_enabled", true);
        f10772c = bd.a(bjVar, "measurement.sdk.dynamite.use_dynamite2", false);
        f10773d = bd.a(bjVar, "measurement.id.sdk.dynamite.use_dynamite", 0);
    }
}
