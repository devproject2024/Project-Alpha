package net.one97.paytm.upi.mandate.confirmation;

import kotlin.g.b.k;
import kotlin.g.b.l;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

final class b extends l implements kotlin.g.a.b<UpiProfileDefaultBank, String> {
    public static final b INSTANCE = new b();

    b() {
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
