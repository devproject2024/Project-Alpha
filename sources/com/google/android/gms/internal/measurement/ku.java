package com.google.android.gms.internal.measurement;

public final class ku implements kw {

    /* renamed from: a  reason: collision with root package name */
    private static final bd<Boolean> f10849a;

    /* renamed from: b  reason: collision with root package name */
    private static final bd<Double> f10850b;

    /* renamed from: c  reason: collision with root package name */
    private static final bd<Long> f10851c;

    /* renamed from: d  reason: collision with root package name */
    private static final bd<Long> f10852d;

    /* renamed from: e  reason: collision with root package name */
    private static final bd<String> f10853e;

    public final boolean a() {
        return f10849a.c().booleanValue();
    }

    public final double b() {
        return f10850b.c().doubleValue();
    }

    public final long c() {
        return f10851c.c().longValue();
    }

    public final long d() {
        return f10852d.c().longValue();
    }

    public final String e() {
        return f10853e.c();
    }

    static {
        bj bjVar = new bj(be.a("com.google.android.gms.measurement"));
        f10849a = bd.a(bjVar, "measurement.test.boolean_flag", false);
        f10850b = bd.a(bjVar, "measurement.test.double_flag");
        f10851c = bd.a(bjVar, "measurement.test.int_flag", -2);
        f10852d = bd.a(bjVar, "measurement.test.long_flag", -1);
        f10853e = bd.a(bjVar, "measurement.test.string_flag", "---");
    }
}
