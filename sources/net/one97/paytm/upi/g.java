package net.one97.paytm.upi;

import android.app.Application;
import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.mandate.data.a.a;
import net.one97.paytm.upi.registration.b.a.b;
import net.one97.paytm.upi.requestmoney.b.a.a.c;

public final class g {
    public static b a(a aVar) {
        if (aVar == null) {
            d();
            aVar = a.a(d(), (a.C1347a) null);
        }
        Context d2 = d();
        return b.a((net.one97.paytm.upi.registration.b.a.a) net.one97.paytm.upi.registration.b.a.a.a.a(d2), (net.one97.paytm.upi.registration.b.a.a) net.one97.paytm.upi.registration.b.a.b.a.a(d2), aVar);
    }

    public static a a(a.C1347a aVar) {
        return a.a(d(), aVar);
    }

    public static net.one97.paytm.upi.profile.b.b a() {
        Context d2 = d();
        return net.one97.paytm.upi.profile.b.b.a(net.one97.paytm.upi.profile.b.b.a.a(d2), net.one97.paytm.upi.profile.b.a.a.a(d2), a(a.a(d(), (a.C1347a) null)));
    }

    public static net.one97.paytm.upi.passbook.b.a.b b() {
        Context d2 = d();
        return net.one97.paytm.upi.passbook.b.a.b.a(net.one97.paytm.upi.passbook.b.a.a.a.a(d2), net.one97.paytm.upi.passbook.b.a.b.a.a(d2));
    }

    public static net.one97.paytm.upi.requestmoney.b.a.b c() {
        Context d2 = d();
        return net.one97.paytm.upi.requestmoney.b.a.b.a((net.one97.paytm.upi.requestmoney.b.a.a) c.a(d2), (net.one97.paytm.upi.requestmoney.b.a.a) net.one97.paytm.upi.requestmoney.b.a.b.a.a(d2));
    }

    public static net.one97.paytm.upi.mandate.data.b a(Context context) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        a.C1356a aVar = net.one97.paytm.upi.mandate.data.a.a.f67121a;
        k.c(context, "context");
        if (net.one97.paytm.upi.mandate.data.a.a.f67122d == null) {
            net.one97.paytm.upi.mandate.data.a.a.f67122d = new net.one97.paytm.upi.mandate.data.a.a(context);
        }
        net.one97.paytm.upi.mandate.data.a.a a2 = net.one97.paytm.upi.mandate.data.a.a.f67122d;
        if (a2 == null) {
            k.a();
        }
        return a2;
    }

    public static Context d() {
        return i.a().m.c();
    }
}
