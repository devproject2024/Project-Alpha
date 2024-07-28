package net.one97.paytm.upi.profile.a;

import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.c;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.d;

public interface b {

    public interface a extends c {
        void a(ArrayList<String> arrayList);
    }

    /* renamed from: net.one97.paytm.upi.profile.a.b$b  reason: collision with other inner class name */
    public interface C1381b extends d<a> {
        void a();

        void a(String str);

        void a(List<BankAccountDetails.BankAccount> list);

        void a(UserUpiDetails userUpiDetails);

        void b(String str);

        void b(UserUpiDetails userUpiDetails);

        void c(UserUpiDetails userUpiDetails);
    }
}
