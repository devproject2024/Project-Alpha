package net.one97.paytm.moneytransfer.a;

import java.util.ArrayList;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.d;

public interface c {

    public interface a extends net.one97.paytm.upi.c {
        void a();

        void a(String str, String str2, boolean z);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void a(BankAccountDetails.BankAccount bankAccount);

        boolean b();

        void c();

        int d();
    }

    public interface b extends d<a> {
        void a();

        void a(String str);

        void a(String str, String str2, String str3);

        void a(ArrayList<BeneficiaryEntity> arrayList);

        void a(ArrayList<BankAccountDetails.BankAccount> arrayList, String str);

        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(UpiCustomVolleyError upiCustomVolleyError, String str);

        void a(AccountProviderBody.AccountProvider accountProvider);

        void a(boolean z);

        void b();

        void b(boolean z);

        void c();

        void c(boolean z);

        void d();

        void d(boolean z);

        String e();

        void f();
    }
}
