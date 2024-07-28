package net.one97.paytm.upi.i;

import android.content.Context;
import net.one97.paytm.upi.common.upi.BankAccountDetails;

public interface a {
    void a(Context context);

    void a(BankAccountDetails.BankAccount bankAccount);

    void a(BankAccountDetails.BankAccount bankAccount, int i2);

    void b(BankAccountDetails.BankAccount bankAccount);

    void b(BankAccountDetails.BankAccount bankAccount, int i2);

    void c(BankAccountDetails.BankAccount bankAccount, int i2);
}
