package com.google.android.gms.internal.measurement;

public final class id implements ia {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10756a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Long> f10757b;

    public final boolean a() {
        return f10756a.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10756a = bd.a(bjVar, "measurement.service.disable_install_state_reporting", false);
        f10757b = bd.a(bjVar, "measurement.id.service.disable_install_state_reporting", 0);
    }
}
