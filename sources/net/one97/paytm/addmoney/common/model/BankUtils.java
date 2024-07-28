package net.one97.paytm.addmoney.common.model;

import android.content.Context;
import android.content.Intent;
import net.one97.paytm.helper.a;

public class BankUtils {
    public static Intent getAddMoneyBankActivityIntent(Context context) {
        return a.b().i(context);
    }

    public static boolean isUserPasscodeSet(Context context) {
        return a.b().h(context);
    }

    public static boolean isBankAccountIssued(Context context) {
        return a.b().g(context);
    }

    public static boolean isPPBCustomer(Context context) {
        return a.b().f(context);
    }

    public static boolean isPaymentBankUser(Context context) {
        return a.b().b(context);
    }

    public static void setBankAccStatusNotApplied(Context context) {
        a.b().c(context);
    }

    public static void setBankAccStatusProcessing(Context context) {
        a.b().d(context);
    }

    public static void setBankAccStatusIssued(Context context) {
        a.b().e(context);
    }

    public static void setBankAccStatus(Context context, int i2) {
        a.b().b(context, i2);
    }
}
