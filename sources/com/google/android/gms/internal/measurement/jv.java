package com.google.android.gms.internal.measurement;

public final class jv implements jr {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10810a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Boolean> f10811b;

    public final boolean a() {
        return f10810a.c().booleanValue();
    }

    public final boolean b() {
        return f10811b.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10810a = bd.a(bjVar, "measurement.collection.efficient_engagement_reporting_enabled", false);
        f10811b = bd.a(bjVar, "measurement.collection.redundant_engagement_removal_enabled", false);
    }
}
