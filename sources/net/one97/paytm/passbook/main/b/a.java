package net.one97.paytm.passbook.main.b;

import net.one97.paytm.passbook.beans.upi.AccountProviderBody;
import net.one97.paytm.passbook.c;

public final class a {

    public interface b extends c {
        void a();

        void a(String str);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void setFavoriteBanks(int i2, AccountProviderBody.AccountProvider accountProvider, int i3, AccountProviderBody.AccountProvider accountProvider2, int i4, AccountProviderBody.AccountProvider accountProvider3, int i5, AccountProviderBody.AccountProvider accountProvider4);
    }

    /* renamed from: net.one97.paytm.passbook.main.b.a$a  reason: collision with other inner class name */
    public static abstract class C1098a extends net.one97.paytm.passbook.a<b> {
        public C1098a(b bVar) {
            super(bVar);
        }
    }
}
