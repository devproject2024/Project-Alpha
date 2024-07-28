package com.google.android.gms.internal.measurement;

public final class kn implements kk {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10841a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Boolean> f10842b;

    public final boolean a() {
        return f10841a.c().booleanValue();
    }

    public final boolean b() {
        return f10842b.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10841a = bd.a(bjVar, "measurement.personalized_ads_signals_collection_enabled", true);
        f10842b = bd.a(bjVar, "measurement.personalized_ads_property_translation_enabled", true);
    }
}
