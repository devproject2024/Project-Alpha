package net.one97.paytm.addmoney.togv.b;

import net.one97.paytm.addmoney.f;
import net.one97.paytm.addmoney.g;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;

public interface a {

    /* renamed from: net.one97.paytm.addmoney.togv.b.a$a  reason: collision with other inner class name */
    public interface C0856a extends f {
        void a(double d2, String str, boolean z);

        void a(String str);

        void a(boolean z);
    }

    public interface b extends g<C0856a> {
        void a(String str);

        void a(String str, String str2);

        void a(CJRRechargePayment cJRRechargePayment);

        void b(String str);

        void b(String str, String str2);

        double c();

        String d();

        String e();

        void f();

        void g();
    }
}
