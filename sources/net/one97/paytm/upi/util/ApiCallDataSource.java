package net.one97.paytm.upi.util;

import com.paytm.network.a;
import com.paytm.network.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.h;
import net.one97.paytm.upi.i;

public final class ApiCallDataSource {
    public static final Companion Companion = new Companion((g) null);

    public static final b getRequestCommonNetworkCallBuilder() {
        return Companion.getRequestCommonNetworkCallBuilder();
    }

    public static final b postRequestCommonNetworkCallBuilder() {
        return Companion.postRequestCommonNetworkCallBuilder();
    }

    public static final b putRequestCommonNetworkCallBuilder() {
        return Companion.putRequestCommonNetworkCallBuilder();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final b getRequestCommonNetworkCallBuilder() {
            b bVar = new b();
            i a2 = i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            h c2 = a2.c();
            k.a((Object) c2, "PaytmUpiSdk.getInstance().onLoadActivityListener");
            b c3 = bVar.a(c2.c()).a(a.C0715a.GET).a(a.c.MONEYTRANSFER).a(a.b.SILENT).c("UPI");
            k.a((Object) c3, "networkCallBuilder");
            return c3;
        }

        public final b postRequestCommonNetworkCallBuilder() {
            b bVar = new b();
            i a2 = i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            h c2 = a2.c();
            k.a((Object) c2, "PaytmUpiSdk.getInstance().onLoadActivityListener");
            b c3 = bVar.a(c2.c()).a(a.C0715a.POST).a(a.c.MONEYTRANSFER).a(a.b.SILENT).c("UPI");
            k.a((Object) c3, "networkCallBuilder");
            return c3;
        }

        public final b putRequestCommonNetworkCallBuilder() {
            b bVar = new b();
            i a2 = i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            h c2 = a2.c();
            k.a((Object) c2, "PaytmUpiSdk.getInstance().onLoadActivityListener");
            b c3 = bVar.a(c2.c()).a(a.C0715a.PUT).a(a.c.MONEYTRANSFER).a(a.b.SILENT).c("UPI");
            k.a((Object) c3, "networkCallBuilder");
            return c3;
        }
    }
}
