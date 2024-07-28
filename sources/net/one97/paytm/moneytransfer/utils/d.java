package net.one97.paytm.moneytransfer.utils;

import com.paytm.network.a;
import com.paytm.network.b;
import kotlin.g.b.k;
import net.one97.paytm.moneytransfer.d.d;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f54161a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a() {
            b bVar = new b();
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            b c2 = bVar.a(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a()).a(a.C0715a.GET).a(a.c.MONEYTRANSFER).a(a.b.SILENT).c("MoneyTransfer");
            k.a((Object) c2, "networkCallBuilder");
            return c2;
        }
    }

    public static final b a() {
        b bVar = new b();
        d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
        b c2 = bVar.a(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a()).a(a.C0715a.POST).a(a.c.MONEYTRANSFER).a(a.b.SILENT).c("MoneyTransfer");
        k.a((Object) c2, "networkCallBuilder");
        return c2;
    }
}
