package com.google.android.gms.internal.measurement;

public final class ki implements kj {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10833a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Boolean> f10834b;

    /* renamed from: c  reason: collision with root package name */
    private static final bd<Boolean> f10835c;

    /* renamed from: d  reason: collision with root package name */
    private static final bd<Long> f10836d;

    public final boolean a() {
        return f10833a.c().booleanValue();
    }

    public final boolean b() {
        return f10834b.c().booleanValue();
    }

    public final boolean c() {
        return f10835c.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10833a = bd.a(bjVar, "measurement.lifecycle.app_backgrounded_engagement", false);
        f10834b = bd.a(bjVar, "measurement.lifecycle.app_backgrounded_tracking", false);
        f10835c = bd.a(bjVar, "measurement.lifecycle.app_in_background_parameter", false);
        f10836d = bd.a(bjVar, "measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }
}
