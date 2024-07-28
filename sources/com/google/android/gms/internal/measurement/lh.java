package com.google.android.gms.internal.measurement;

public final class lh implements li {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10867a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Boolean> f10868b;

    /* renamed from: c  reason: collision with root package name */
    private static final bd<Boolean> f10869c;

    /* renamed from: d  reason: collision with root package name */
    private static final bd<Boolean> f10870d;

    /* renamed from: e  reason: collision with root package name */
    private static final bd<Boolean> f10871e;

    /* renamed from: f  reason: collision with root package name */
    private static final bd<Boolean> f10872f;

    /* renamed from: g  reason: collision with root package name */
    private static final bd<Long> f10873g;

    /* renamed from: h  reason: collision with root package name */
    private static final bd<Boolean> f10874h;

    /* renamed from: i  reason: collision with root package name */
    private static final bd<Boolean> f10875i;

    public final boolean a() {
        return f10867a.c().booleanValue();
    }

    public final boolean b() {
        return f10868b.c().booleanValue();
    }

    public final boolean c() {
        return f10869c.c().booleanValue();
    }

    public final boolean d() {
        return f10870d.c().booleanValue();
    }

    public final boolean e() {
        return f10871e.c().booleanValue();
    }

    public final boolean f() {
        return f10872f.c().booleanValue();
    }

    public final boolean g() {
        return f10874h.c().booleanValue();
    }

    public final boolean h() {
        return f10875i.c().booleanValue();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10867a = bd.a(bjVar, "measurement.service.audience.scoped_filters_v27", false);
        f10868b = bd.a(bjVar, "measurement.service.audience.session_scoped_user_engagement", false);
        f10869c = bd.a(bjVar, "measurement.client.audience.scoped_engagement_removal_when_session_expired", true);
        f10870d = bd.a(bjVar, "measurement.service.audience.scoped_engagement_removal_when_session_expired", true);
        f10871e = bd.a(bjVar, "measurement.service.audience.session_scoped_event_aggregates", false);
        f10872f = bd.a(bjVar, "measurement.service.audience.use_bundle_timestamp_for_property_filters", false);
        f10873g = bd.a(bjVar, "measurement.id.scoped_audience_filters", 0);
        f10874h = bd.a(bjVar, "measurement.service.audience.fix_prepending_previous_sequence_timestamp", false);
        f10875i = bd.a(bjVar, "measurement.service.audience.remove_disabled_session_scoped_user_engagement", false);
    }
}
