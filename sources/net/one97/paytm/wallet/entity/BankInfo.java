package net.one97.paytm.wallet.entity;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class BankInfo extends IJRPaytmDataModel {
    private String bankLogoURL;
    private String bankName;
    private final boolean isAddBank;
    private boolean isPrimary;

    public static /* synthetic */ BankInfo copy$default(BankInfo bankInfo, boolean z, boolean z2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = bankInfo.isAddBank;
        }
        if ((i2 & 2) != 0) {
            z2 = bankInfo.isPrimary;
        }
        if ((i2 & 4) != 0) {
            str = bankInfo.bankName;
        }
        if ((i2 & 8) != 0) {
            str2 = bankInfo.bankLogoURL;
        }
        return bankInfo.copy(z, z2, str, str2);
    }

    public final boolean component1() {
        return this.isAddBank;
    }

    public final boolean component2() {
        return this.isPrimary;
    }

    public final String component3() {
        return this.bankName;
    }

    public final String component4() {
        return this.bankLogoURL;
    }

    public final BankInfo copy(boolean z, boolean z2, String str, String str2) {
        return new BankInfo(z, z2, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BankInfo) {
                BankInfo bankInfo = (BankInfo) obj;
                if (this.isAddBank == bankInfo.isAddBank) {
                    if (!(this.isPrimary == bankInfo.isPrimary) || !k.a((Object) this.bankName, (Object) bankInfo.bankName) || !k.a((Object) this.bankLogoURL, (Object) bankInfo.bankLogoURL)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.isAddBank;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.isPrimary;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        String str = this.bankName;
        int i4 = 0;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.bankLogoURL;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return hashCode + i4;
    }

    public final String toString() {
        return "BankInfo(isAddBank=" + this.isAddBank + ", isPrimary=" + this.isPrimary + ", bankName=" + this.bankName + ", bankLogoURL=" + this.bankLogoURL + ")";
    }

    public BankInfo(boolean z, boolean z2, String str, String str2) {
        this.isAddBank = z;
        this.isPrimary = z2;
        this.bankName = str;
        this.bankLogoURL = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BankInfo(boolean z, boolean z2, String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, str, str2);
    }

    public final String getBankLogoURL() {
        return this.bankLogoURL;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final boolean isAddBank() {
        return this.isAddBank;
    }

    public final boolean isPrimary() {
        return this.isPrimary;
    }

    public final void setBankLogoURL(String str) {
        this.bankLogoURL = str;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final void setPrimary(boolean z) {
        this.isPrimary = z;
    }
}
