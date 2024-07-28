package net.one97.paytm.nativesdk.instruments.upipush.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public final class BankMetaData implements BaseDataModel {
    private BankHealth bankHealth;
    private String perTxnLimit;

    public static /* synthetic */ BankMetaData copy$default(BankMetaData bankMetaData, String str, BankHealth bankHealth2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bankMetaData.perTxnLimit;
        }
        if ((i2 & 2) != 0) {
            bankHealth2 = bankMetaData.bankHealth;
        }
        return bankMetaData.copy(str, bankHealth2);
    }

    public final String component1() {
        return this.perTxnLimit;
    }

    public final BankHealth component2() {
        return this.bankHealth;
    }

    public final BankMetaData copy(String str, BankHealth bankHealth2) {
        return new BankMetaData(str, bankHealth2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankMetaData)) {
            return false;
        }
        BankMetaData bankMetaData = (BankMetaData) obj;
        return k.a((Object) this.perTxnLimit, (Object) bankMetaData.perTxnLimit) && k.a((Object) this.bankHealth, (Object) bankMetaData.bankHealth);
    }

    public final int hashCode() {
        String str = this.perTxnLimit;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        BankHealth bankHealth2 = this.bankHealth;
        if (bankHealth2 != null) {
            i2 = bankHealth2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "BankMetaData(perTxnLimit=" + this.perTxnLimit + ", bankHealth=" + this.bankHealth + ")";
    }

    public BankMetaData(String str, BankHealth bankHealth2) {
        this.perTxnLimit = str;
        this.bankHealth = bankHealth2;
    }

    public final String getPerTxnLimit() {
        return this.perTxnLimit;
    }

    public final void setPerTxnLimit(String str) {
        this.perTxnLimit = str;
    }

    public final BankHealth getBankHealth() {
        return this.bankHealth;
    }

    public final void setBankHealth(BankHealth bankHealth2) {
        this.bankHealth = bankHealth2;
    }
}
