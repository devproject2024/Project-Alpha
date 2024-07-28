package net.one97.paytm.upi.profile.a;

import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.d;
import net.one97.paytm.upi.profile.view.n;

public interface k {

    public interface a extends c {
        int a();

        void a(int i2);

        void a(int i2, n.a aVar);

        void a(int i2, boolean z);
    }

    public interface b extends d<a> {
        void a();

        void a(int i2);

        void a(BankAccountDetails.BankAccount bankAccount);

        void a(boolean z);

        void b(int i2);

        void b(boolean z);

        void c(int i2);

        void c(boolean z);
    }
}
