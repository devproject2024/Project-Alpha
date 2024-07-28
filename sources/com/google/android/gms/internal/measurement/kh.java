package com.google.android.gms.internal.measurement;

public final class kh implements ke {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10828a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Boolean> f10829b;

    /* renamed from: c  reason: collision with root package name */
    private static final bd<Boolean> f10830c;

    /* renamed from: d  reason: collision with root package name */
    private static final bd<Boolean> f10831d;

    /* renamed from: e  reason: collision with root package name */
    private static final bd<Long> f10832e;

    public final boolean a() {
        return f10828a.c().booleanValue();
    }

    public final boolean b() {
        return f10829b.c().booleanValue();
    }

    public final boolean c() {
        return f10830c.c().booleanValue();
    }

    public final boolean d() {
        return f10831d.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10828a = bd.a(bjVar, "measurement.sdk.collection.last_deep_link_referrer", false);
        f10829b = bd.a(bjVar, "measurement.sdk.collection.last_deep_link_referrer_campaign", false);
        f10830c = bd.a(bjVar, "measurement.sdk.collection.last_gclid_from_referrer", false);
        f10831d = bd.a(bjVar, "measurement.sdk.collection.worker_thread_referrer", true);
        f10832e = bd.a(bjVar, "measurement.id.sdk.collection.last_deep_link_referrer", 0);
    }
}
