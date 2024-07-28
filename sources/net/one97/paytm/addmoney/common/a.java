package net.one97.paytm.addmoney.common;

import com.paytm.network.a;
import com.paytm.network.b;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0848a f48418a = new C0848a((byte) 0);

    public static final b a() {
        return C0848a.a();
    }

    public static final b b() {
        return C0848a.b();
    }

    /* renamed from: net.one97.paytm.addmoney.common.a$a  reason: collision with other inner class name */
    public static final class C0848a {
        private C0848a() {
        }

        public /* synthetic */ C0848a(byte b2) {
            this();
        }

        public static b a() {
            b c2 = new b().a(net.one97.paytm.helper.a.f50546a.a().j()).a(a.C0715a.GET).a(a.c.ADDMONEY).a(a.b.SILENT).c("AddMoney");
            k.a((Object) c2, "networkCallBuilder");
            return c2;
        }

        public static b b() {
            b c2 = new b().a(net.one97.paytm.helper.a.f50546a.a().j()).a(a.C0715a.POST).a(a.c.ADDMONEY).a(a.b.SILENT).c("AddMoney");
            k.a((Object) c2, "networkCallBuilder");
            return c2;
        }

        public static b c() {
            b c2 = new b().a(net.one97.paytm.helper.a.f50546a.a().j()).a(a.C0715a.PUT).a(a.c.ADDMONEY).a(a.b.SILENT).c("AddMoney");
            k.a((Object) c2, "networkCallBuilder");
            return c2;
        }
    }
}
