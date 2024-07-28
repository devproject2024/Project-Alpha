package net.one97.paytm.upi.profile.a;

import java.util.List;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.d;
import net.one97.paytm.upi.util.UpiConstants;

public interface f {

    public interface a extends net.one97.paytm.upi.c {
        int a();

        void a(int i2, b bVar);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void a(BankAccountDetails.BankAccount bankAccount);

        void a(UpiProfileDefaultBank upiProfileDefaultBank, List<BankAccountDetails.BankAccount> list);

        void b();

        boolean c();

        void d();

        void g();
    }

    public interface b {
        void a(String str);

        void a(boolean z);

        void b(String str);
    }

    public interface c extends d<a> {
        void a();

        void a(int i2, int i3, BankAccountDetails.BankAccount bankAccount);

        void a(String str);

        void a(String str, boolean z, List<BankAccountDetails.BankAccount> list, UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type);

        void a(AccountProviderBody.AccountProvider accountProvider, String str);

        void a(BankAccountDetails.BankAccount bankAccount, String str);

        void a(UserUpiDetails userUpiDetails);

        void b();

        void b(String str);

        void c();

        void c(String str);

        void d();

        void d(String str);

        void e();
    }
}
