package net.one97.paytm.upi.registration.a;

import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.d;
import net.one97.paytm.upi.registration.view.f;
import net.one97.paytm.upi.util.UpiConstants;

public interface g {

    public interface a extends c {
        void a();

        void a(int i2);

        void a(int i2, f.a aVar);

        void a(String str, String str2);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void a(BankAccountDetails.BankAccount bankAccount);

        int b();

        void b(int i2);

        void b(int i2, f.a aVar);

        void c();

        void c(int i2);

        void d();

        void d(int i2);

        void e(int i2);

        void g();
    }

    public interface b extends d<a> {
        void a(int i2);

        void a(String str);

        void a(ArrayList<BankAccountDetails.BankAccount> arrayList);

        void a(List<AccountProviderBody.AccountProvider> list);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(UpiCustomVolleyError upiCustomVolleyError, String str);

        void a(AccountProviderBody.AccountProvider accountProvider, String str);

        void a(BankAccountDetails.BankAccount bankAccount);

        void a(UpiProfileDefaultBank upiProfileDefaultBank);

        void a(UserUpiDetails userUpiDetails, UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type);

        void a(boolean z);

        void a(boolean z, String str);

        void b(ArrayList<BankAccountDetails.BankAccount> arrayList);

        void b(UpiCustomVolleyError upiCustomVolleyError, String str);

        void b(BankAccountDetails.BankAccount bankAccount);

        void c();

        void c(BankAccountDetails.BankAccount bankAccount);

        void d();

        void e();

        void f();

        void g();

        void h();

        boolean i();

        String j();
    }
}
