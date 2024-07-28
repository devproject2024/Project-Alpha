package com.google.android.gms.internal.measurement;

public final class ik implements il {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10764a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Long> f10765b;

    public final boolean a() {
        return f10764a.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10764a = bd.a(bjVar, "measurement.upload_dsid_enabled", true);
        f10765b = bd.a(bjVar, "measurement.id.upload_dsid_enabled", 0);
    }
}
