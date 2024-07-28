package net.one97.paytm.upi.profile.a;

import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.d;

public interface h {

    public interface a extends c {
        void a();

        void a(int i2);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void a(boolean z);
    }

    public interface b extends d<a> {
        void a();

        void a(int i2);

        void a(String str);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(AccountProviderBody.AccountProvider accountProvider, String str);

        void a(UpiProfileModel.ProfileDetails profileDetails);

        void b();

        void c();

        void d();

        void e();
    }
}
