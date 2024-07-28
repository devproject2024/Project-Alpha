package net.one97.paytm.upi.profile.a;

import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.d;

public interface g {

    public interface a extends c {
        void a();

        void b();

        void c();

        void d();
    }

    public interface b extends d<a> {
        void a();

        void a(String str, String str2);

        void a(UpiCustomVolleyError upiCustomVolleyError, String str);

        void a(UserUpiDetails userUpiDetails);

        void a(boolean z);

        void b();

        void b(UpiCustomVolleyError upiCustomVolleyError, String str);

        void b(UserUpiDetails userUpiDetails);

        void c();

        void c(UpiCustomVolleyError upiCustomVolleyError, String str);

        void c(UserUpiDetails userUpiDetails);

        void d();

        void d(UpiCustomVolleyError upiCustomVolleyError, String str);

        void e();

        void f();

        void g();

        void h();

        void i();

        void j();
    }
}
