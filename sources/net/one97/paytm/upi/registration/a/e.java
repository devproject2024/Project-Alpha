package net.one97.paytm.upi.registration.a;

import android.content.Intent;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.d;

public interface e {

    public interface a extends c {
        void a();

        void a(int i2, int i3, Intent intent);

        void a(AccountProviderBody.AccountProvider accountProvider, int i2);
    }

    public interface b extends d<a> {
        void a();

        void a(int i2);

        void a(int i2, AccountProviderBody.AccountProvider accountProvider, int i3, AccountProviderBody.AccountProvider accountProvider2, int i4, AccountProviderBody.AccountProvider accountProvider3, int i5, AccountProviderBody.AccountProvider accountProvider4, int i6, AccountProviderBody.AccountProvider accountProvider5, int i7, AccountProviderBody.AccountProvider accountProvider6);

        void a(String str);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void a(boolean z);

        void b();

        void b(String str);
    }
}
