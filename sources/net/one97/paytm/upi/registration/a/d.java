package net.one97.paytm.upi.registration.a;

import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UpiProfileModel;

public interface d {

    public interface a {
        void a(String str);

        void a(boolean z);
    }

    public interface b extends net.one97.paytm.upi.c {
        void a();

        void a(int i2);

        void a(String str, String str2);

        void a(boolean z, String str, String str2);

        void b();

        void c();

        void d();

        void g();

        void h();

        ArrayList<String> i();
    }

    public interface c extends net.one97.paytm.upi.d<b> {
        void a();

        void a(int i2, String str);

        void a(String str, String str2);

        void a(String str, UpiProfileModel.ProfileDetails profileDetails);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void a(AccountProviderBody.AccountProvider accountProvider, int i2, int i3, String str);

        void a(AccountProviderBody.AccountProvider accountProvider, int i2, String str);

        void a(boolean z);

        void b();

        void b(AccountProviderBody.AccountProvider accountProvider);

        void b(boolean z);

        void c();

        boolean d();

        void e();

        boolean f();

        void g();
    }
}
