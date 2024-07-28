package net.one97.paytm.upi.registration.a;

import java.util.List;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.d;

public interface f {

    public interface a extends c {
        void a();

        void a(int i2);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void a(boolean z);
    }

    public interface b extends d<a> {
        void a();

        void a(int i2);

        void a(String str, String str2);

        void a(List<UpiProfileDefaultBank> list, List<BankAccountDetails.BankAccount> list2);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(AccountProviderBody.AccountProvider accountProvider, String str);

        void b();

        void c();

        void d();
    }
}
