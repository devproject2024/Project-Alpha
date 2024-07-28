package net.one97.paytm.addmoney.common.a;

import net.one97.paytm.upi.common.upi.AccountProviderBody;

public final class c {

    public interface b extends b {
        void a();

        void a(String str);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void setFavoriteBanks(int i2, AccountProviderBody.AccountProvider accountProvider, int i3, AccountProviderBody.AccountProvider accountProvider2, int i4, AccountProviderBody.AccountProvider accountProvider3, int i5, AccountProviderBody.AccountProvider accountProvider4);
    }

    public static abstract class a extends net.one97.paytm.addmoney.common.c.b<b> {
        public a(b bVar) {
            super(bVar);
        }
    }
}
