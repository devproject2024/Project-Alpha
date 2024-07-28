package net.one97.paytm.upi.profile.a;

import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.d;

public interface i {

    public interface a extends c {
        UpiProfileDefaultBank a();

        void b();
    }

    public interface b extends d<a> {
        void a();

        void a(String str, BankAccountDetails.BankAccount bankAccount, String str2);

        void b();
    }
}
