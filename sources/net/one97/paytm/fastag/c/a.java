package net.one97.paytm.fastag.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f13558a;

    /* renamed from: b  reason: collision with root package name */
    public b f13559b;

    public static a a() {
        a aVar = f13558a;
        if (aVar != null) {
            return aVar;
        }
        throw new RuntimeException("getInstance() called before fastagImplProvider's init()");
    }
}
