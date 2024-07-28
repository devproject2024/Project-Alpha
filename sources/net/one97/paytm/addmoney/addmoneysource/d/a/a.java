package net.one97.paytm.addmoney.addmoneysource.d.a;

import java.util.HashMap;
import net.one97.paytm.addmoney.addmoneysource.d.d.b;
import net.one97.paytm.addmoney.f;
import net.one97.paytm.addmoney.g;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

public interface a {

    /* renamed from: net.one97.paytm.addmoney.addmoneysource.d.a.a$a  reason: collision with other inner class name */
    public interface C0842a extends f {
        void a(int i2);

        void a(int i2, b.a aVar);

        void a(String str, double d2);

        void b(int i2);

        int c();

        int d();

        void e();

        int f();
    }

    public interface b extends g<C0842a> {
        void a();

        void a(int i2);

        void a(String str);

        void a(HashMap<String, String> hashMap);

        void a(UpiProfileDefaultBank upiProfileDefaultBank);

        void b();

        void b(int i2);

        void b(boolean z);

        void c();

        void c(int i2);

        void c(boolean z);

        double d();

        void d(boolean z);
    }
}
