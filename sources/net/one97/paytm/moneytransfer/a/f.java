package net.one97.paytm.moneytransfer.a;

import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;

public interface f {

    public interface a {
        void a(String str);

        void a(String str, String str2);

        void a(MoneyTransferV3Activity.b bVar);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void a(BaseUpiResponse baseUpiResponse);

        void a(boolean z);

        void b(String str);

        void b(UpiCustomVolleyError upiCustomVolleyError);

        void b(BaseUpiResponse baseUpiResponse);

        void b_(int i2);

        void c();

        void c(UpiCustomVolleyError upiCustomVolleyError);

        void d();
    }

    public interface b extends c {
    }
}
