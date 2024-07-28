package net.one97.paytm.recharge.automatic.e;

import com.paytm.network.a;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f60279a;

    public static d a() {
        if (f60279a == null) {
            synchronized (d.class.getName()) {
                if (f60279a == null) {
                    f60279a = new d();
                }
            }
        }
        return f60279a;
    }

    public static void a(a aVar) {
        a aVar2;
        if (aVar instanceof b) {
            a aVar3 = ((b) aVar).f60274a;
            if (aVar3 != null) {
                aVar3.a();
            }
        } else if ((aVar instanceof c) && (aVar2 = ((c) aVar).f60276a) != null) {
            aVar2.a();
        }
    }
}
