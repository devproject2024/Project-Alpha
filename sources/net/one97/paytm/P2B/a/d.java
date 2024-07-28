package net.one97.paytm.p2b.a;

import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.wallet.CJRP2BStatus;

public final class d {

    public interface a extends net.one97.paytm.p2b.a {
        String a(String str);

        void a(CJRP2BStatus cJRP2BStatus);

        double b();

        void b(String str);

        double c();

        void c(String str);

        double d();

        boolean d(String str);

        double e();

        double f();

        boolean g();

        void h();
    }

    public interface b {
        void a();

        void a(NetworkCustomError networkCustomError);

        void a(String str);

        void a(String str, String str2);

        void a(CJRP2BStatus cJRP2BStatus);

        void b();

        void b(String str);

        String c();

        void d();
    }
}
