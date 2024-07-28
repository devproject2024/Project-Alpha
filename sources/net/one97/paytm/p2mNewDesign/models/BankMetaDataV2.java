package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.network.CJRWalletDataModel;

public final class BankMetaDataV2 extends CJRWalletDataModel {
    @b(a = "bankHealth")
    private BankHealthV2 bankHealth;
    @b(a = "perTxnLimit")
    private String perTxnLimit;

    public BankMetaDataV2() {
        this((BankHealthV2) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ BankMetaDataV2 copy$default(BankMetaDataV2 bankMetaDataV2, BankHealthV2 bankHealthV2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bankHealthV2 = bankMetaDataV2.bankHealth;
        }
        if ((i2 & 2) != 0) {
            str = bankMetaDataV2.perTxnLimit;
        }
        return bankMetaDataV2.copy(bankHealthV2, str);
    }

    public final BankHealthV2 component1() {
        return this.bankHealth;
    }

    public final String component2() {
        return this.perTxnLimit;
    }

    public final BankMetaDataV2 copy(BankHealthV2 bankHealthV2, String str) {
        return new BankMetaDataV2(bankHealthV2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankMetaDataV2)) {
            return false;
        }
        BankMetaDataV2 bankMetaDataV2 = (BankMetaDataV2) obj;
        return k.a((Object) this.bankHealth, (Object) bankMetaDataV2.bankHealth) && k.a((Object) this.perTxnLimit, (Object) bankMetaDataV2.perTxnLimit);
    }

    public final int hashCode() {
        BankHealthV2 bankHealthV2 = this.bankHealth;
        int i2 = 0;
        int hashCode = (bankHealthV2 != null ? bankHealthV2.hashCode() : 0) * 31;
        String str = this.perTxnLimit;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "BankMetaDataV2(bankHealth=" + this.bankHealth + ", perTxnLimit=" + this.perTxnLimit + ")";
    }

    public BankMetaDataV2(BankHealthV2 bankHealthV2, String str) {
        this.bankHealth = bankHealthV2;
        this.perTxnLimit = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BankMetaDataV2(BankHealthV2 bankHealthV2, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : bankHealthV2, (i2 & 2) != 0 ? null : str);
    }

    public final BankHealthV2 getBankHealth() {
        return this.bankHealth;
    }

    public final String getPerTxnLimit() {
        return this.perTxnLimit;
    }

    public final void setBankHealth(BankHealthV2 bankHealthV2) {
        this.bankHealth = bankHealthV2;
    }

    public final void setPerTxnLimit(String str) {
        this.perTxnLimit = str;
    }
}
