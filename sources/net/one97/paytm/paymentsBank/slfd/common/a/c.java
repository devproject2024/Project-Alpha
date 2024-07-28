package net.one97.paytm.paymentsBank.slfd.common.a;

import java.util.HashMap;
import net.one97.paytm.paymentsBank.model.slfd.SlfdModel;
import net.one97.paytm.paymentsBank.slfd.common.view.f;

public interface c {

    public interface a extends net.one97.paytm.paymentsBank.slfd.a {
        void a(int i2);

        void a(HashMap<String, Double> hashMap);

        void a(f.a aVar, int i2);

        int c();

        void d();

        void e();
    }

    public interface b extends net.one97.paytm.paymentsBank.slfd.b<a> {
        void a();

        void a(int i2, int i3);

        void a(String str);

        void a(String str, double d2, boolean z, boolean z2, SlfdModel slfdModel);

        void a(String str, long j, String str2, String str3, boolean z, boolean z2, SlfdModel slfdModel);

        void b();

        void c();

        void d();

        void e();
    }
}
