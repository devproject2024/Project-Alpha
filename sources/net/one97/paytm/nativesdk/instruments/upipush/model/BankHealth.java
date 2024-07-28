package net.one97.paytm.nativesdk.instruments.upipush.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public final class BankHealth implements BaseDataModel {
    private String category;
    private String displayMsg;

    public static /* synthetic */ BankHealth copy$default(BankHealth bankHealth, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bankHealth.category;
        }
        if ((i2 & 2) != 0) {
            str2 = bankHealth.displayMsg;
        }
        return bankHealth.copy(str, str2);
    }

    public final String component1() {
        return this.category;
    }

    public final String component2() {
        return this.displayMsg;
    }

    public final BankHealth copy(String str, String str2) {
        return new BankHealth(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankHealth)) {
            return false;
        }
        BankHealth bankHealth = (BankHealth) obj;
        return k.a((Object) this.category, (Object) bankHealth.category) && k.a((Object) this.displayMsg, (Object) bankHealth.displayMsg);
    }

    public final int hashCode() {
        String str = this.category;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.displayMsg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "BankHealth(category=" + this.category + ", displayMsg=" + this.displayMsg + ")";
    }

    public BankHealth(String str, String str2) {
        this.category = str;
        this.displayMsg = str2;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final String getDisplayMsg() {
        return this.displayMsg;
    }

    public final void setDisplayMsg(String str) {
        this.displayMsg = str;
    }
}
