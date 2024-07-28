package net.one97.paytm.upi.profile.a;

import java.util.List;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UserUpiDetails;

public interface d {

    public enum a {
        INVALID_CARDNUM,
        INVALID_MONTH,
        INVALID_DATE,
        INVALID_YEAR
    }

    public interface b extends net.one97.paytm.upi.c {
        void a();

        void a(String str);

        void a(String str, String str2, String str3);

        void a(List<GetCredentialsResponse> list, String str);

        void b();

        void c();
    }

    public interface c extends net.one97.paytm.upi.d<b> {
        void a();

        void a(String str);

        void a(List<GetCredentialsResponse> list, String str);

        void a(UpiCustomVolleyError upiCustomVolleyError, String str);

        void a(UpiCustomVolleyError upiCustomVolleyError, String str, String str2);

        void a(BankAccountDetails.BankAccount bankAccount);

        void a(UserUpiDetails userUpiDetails);

        void a(a aVar);

        void b();

        void b(UpiCustomVolleyError upiCustomVolleyError, String str);

        void b(UserUpiDetails userUpiDetails);

        void c();

        void c(UpiCustomVolleyError upiCustomVolleyError, String str);

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();

        void j();

        void k();

        void l();

        void m();

        void n();
    }
}
