package net.one97.paytm.p2b.a;

import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;

public final class b {

    public interface a extends net.one97.paytm.p2b.a {
        void a(double d2);

        void a(double d2, double d3, double d4, double d5, double d6);

        void a(String str, String str2, String str3, boolean z, String str4, String str5);

        double b();

        double c();

        double d();

        double e();

        double f();

        String g();

        String h();

        String i();

        void j();

        String k();

        String l();
    }

    /* renamed from: net.one97.paytm.p2b.a.b$b  reason: collision with other inner class name */
    public interface C1058b {
        void a(NetworkCustomError networkCustomError);

        void a(CJRP2BStatus cJRP2BStatus);

        void b();

        void c();
    }
}
