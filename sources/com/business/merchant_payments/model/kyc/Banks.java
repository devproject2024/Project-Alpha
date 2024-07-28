package com.business.merchant_payments.model.kyc;

import java.util.List;
import kotlin.g.b.k;

public final class Banks {
    public final List<BankDetails> bankDetailsList;

    public static /* synthetic */ Banks copy$default(Banks banks, List<BankDetails> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = banks.bankDetailsList;
        }
        return banks.copy(list);
    }

    public final List<BankDetails> component1() {
        return this.bankDetailsList;
    }

    public final Banks copy(List<BankDetails> list) {
        k.d(list, "bankDetailsList");
        return new Banks(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Banks) && k.a((Object) this.bankDetailsList, (Object) ((Banks) obj).bankDetailsList);
        }
        return true;
    }

    public final int hashCode() {
        List<BankDetails> list = this.bankDetailsList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Banks(bankDetailsList=" + this.bankDetailsList + ")";
    }

    public Banks(List<BankDetails> list) {
        k.d(list, "bankDetailsList");
        this.bankDetailsList = list;
    }

    public final List<BankDetails> getBankDetailsList() {
        return this.bankDetailsList;
    }
}
