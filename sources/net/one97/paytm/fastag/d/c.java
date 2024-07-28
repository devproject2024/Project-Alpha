package net.one97.paytm.fastag.d;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f13564a;

    public static c a() {
        if (f13564a == null) {
            synchronized (c.class.getName()) {
                if (f13564a == null) {
                    f13564a = new c();
                }
            }
        }
        return f13564a;
    }

    public static void a(e eVar) {
        if (eVar instanceof a) {
            ((a) eVar).f13560a.a();
        } else if (eVar instanceof b) {
            ((b) eVar).f13562a.a();
        }
    }
}
