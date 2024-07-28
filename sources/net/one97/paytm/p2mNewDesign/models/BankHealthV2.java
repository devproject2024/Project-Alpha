package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.network.CJRWalletDataModel;

public final class BankHealthV2 extends CJRWalletDataModel {
    @b(a = "category")
    private String category;
    @b(a = "displayMsg")
    private String displayMsg;

    public BankHealthV2() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ BankHealthV2 copy$default(BankHealthV2 bankHealthV2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bankHealthV2.displayMsg;
        }
        if ((i2 & 2) != 0) {
            str2 = bankHealthV2.category;
        }
        return bankHealthV2.copy(str, str2);
    }

    public final String component1() {
        return this.displayMsg;
    }

    public final String component2() {
        return this.category;
    }

    public final BankHealthV2 copy(String str, String str2) {
        return new BankHealthV2(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankHealthV2)) {
            return false;
        }
        BankHealthV2 bankHealthV2 = (BankHealthV2) obj;
        return k.a((Object) this.displayMsg, (Object) bankHealthV2.displayMsg) && k.a((Object) this.category, (Object) bankHealthV2.category);
    }

    public final int hashCode() {
        String str = this.displayMsg;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.category;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "BankHealthV2(displayMsg=" + this.displayMsg + ", category=" + this.category + ")";
    }

    public BankHealthV2(String str, String str2) {
        this.displayMsg = str;
        this.category = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BankHealthV2(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getDisplayMsg() {
        return this.displayMsg;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final void setDisplayMsg(String str) {
        this.displayMsg = str;
    }
}
