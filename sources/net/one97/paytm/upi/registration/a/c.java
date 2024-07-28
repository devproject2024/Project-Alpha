package net.one97.paytm.upi.registration.a;

import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.d;

public interface c {

    public interface a extends net.one97.paytm.upi.c {
        void a();
    }

    public interface b extends d<a> {
        void a(int i2, String str);

        void a(AccountProviderBody.AccountProvider accountProvider, int i2, int i3, String str);
    }
}
