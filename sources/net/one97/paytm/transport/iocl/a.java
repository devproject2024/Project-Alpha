package net.one97.paytm.transport.iocl;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f14208a;

    /* renamed from: b  reason: collision with root package name */
    public b f14209b;

    /* renamed from: c  reason: collision with root package name */
    public c f14210c;

    public static a a() {
        a aVar = f14208a;
        if (aVar == null) {
            return null;
        }
        return aVar;
    }

    public static b b() {
        if (a() == null || a().f14209b == null) {
            new d();
            d.a();
        }
        return a().f14209b;
    }

    public static c c() {
        if (a() == null || a().f14210c == null) {
            new d();
            d.a();
        }
        return a().f14210c;
    }
}
