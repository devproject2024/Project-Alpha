package net.one97.paytm.upi.profile.a;

import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.d;

public interface e {

    public interface a extends c {
        void a();

        void a(AccountProviderBody.AccountProvider accountProvider);
    }

    public interface b extends d<a> {
        void a(AccountProviderBody.AccountProvider accountProvider, String str);

        void a(UserUpiDetails userUpiDetails);

        void b(UserUpiDetails userUpiDetails);
    }
}
