package net.one97.paytm.upi.mandate.c;

import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

final class c extends l implements b<UpiProfileDefaultBank, String> {
    public static final c INSTANCE = new c();

    c() {
        super(1);
    }

    public final String invoke(UpiProfileDefaultBank upiProfileDefaultBank) {
        k.c(upiProfileDefaultBank, "it");
        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
        k.a((Object) debitBank, "it.debitBank");
        String bankName = debitBank.getBankName();
        k.a((Object) bankName, "it.debitBank.bankName");
        return bankName;
    }
}
