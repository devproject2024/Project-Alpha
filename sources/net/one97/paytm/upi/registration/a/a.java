package net.one97.paytm.upi.registration.a;

import java.util.List;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.d;

public interface a {

    /* renamed from: net.one97.paytm.upi.registration.a.a$a  reason: collision with other inner class name */
    public interface C1387a extends c {
        void a();

        void a(int i2);

        void a(String str);
    }

    public interface b extends d<C1387a> {
        void a();

        void a(List<UpiBaseDataModel> list);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void b();

        void b(List<AccountProviderBody.AccountProvider> list);

        void c(List<UpiBaseDataModel> list);

        boolean c();
    }
}
