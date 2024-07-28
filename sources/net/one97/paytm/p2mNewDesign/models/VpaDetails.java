package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class VpaDetails extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "defaultCredit")
    private BankAccountsV2 defaultCredit;
    @b(a = "defaultDebit")
    private BankAccountsV2 defaultDebit;
    @b(a = "name")
    private String name;
    @b(a = "primary")
    private boolean primary;

    public VpaDetails() {
        this((BankAccountsV2) null, (BankAccountsV2) null, (String) null, false, 15, (g) null);
    }

    public static /* synthetic */ VpaDetails copy$default(VpaDetails vpaDetails, BankAccountsV2 bankAccountsV2, BankAccountsV2 bankAccountsV22, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bankAccountsV2 = vpaDetails.defaultCredit;
        }
        if ((i2 & 2) != 0) {
            bankAccountsV22 = vpaDetails.defaultDebit;
        }
        if ((i2 & 4) != 0) {
            str = vpaDetails.name;
        }
        if ((i2 & 8) != 0) {
            z = vpaDetails.primary;
        }
        return vpaDetails.copy(bankAccountsV2, bankAccountsV22, str, z);
    }

    public final BankAccountsV2 component1() {
        return this.defaultCredit;
    }

    public final BankAccountsV2 component2() {
        return this.defaultDebit;
    }

    public final String component3() {
        return this.name;
    }

    public final boolean component4() {
        return this.primary;
    }

    public final VpaDetails copy(BankAccountsV2 bankAccountsV2, BankAccountsV2 bankAccountsV22, String str, boolean z) {
        return new VpaDetails(bankAccountsV2, bankAccountsV22, str, z);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof VpaDetails) {
                VpaDetails vpaDetails = (VpaDetails) obj;
                if (k.a((Object) this.defaultCredit, (Object) vpaDetails.defaultCredit) && k.a((Object) this.defaultDebit, (Object) vpaDetails.defaultDebit) && k.a((Object) this.name, (Object) vpaDetails.name)) {
                    if (this.primary == vpaDetails.primary) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        BankAccountsV2 bankAccountsV2 = this.defaultCredit;
        int i2 = 0;
        int hashCode = (bankAccountsV2 != null ? bankAccountsV2.hashCode() : 0) * 31;
        BankAccountsV2 bankAccountsV22 = this.defaultDebit;
        int hashCode2 = (hashCode + (bankAccountsV22 != null ? bankAccountsV22.hashCode() : 0)) * 31;
        String str = this.name;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.primary;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "VpaDetails(defaultCredit=" + this.defaultCredit + ", defaultDebit=" + this.defaultDebit + ", name=" + this.name + ", primary=" + this.primary + ")";
    }

    public final BankAccountsV2 getDefaultCredit() {
        return this.defaultCredit;
    }

    public final void setDefaultCredit(BankAccountsV2 bankAccountsV2) {
        this.defaultCredit = bankAccountsV2;
    }

    public final BankAccountsV2 getDefaultDebit() {
        return this.defaultDebit;
    }

    public final void setDefaultDebit(BankAccountsV2 bankAccountsV2) {
        this.defaultDebit = bankAccountsV2;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VpaDetails(BankAccountsV2 bankAccountsV2, BankAccountsV2 bankAccountsV22, String str, boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : bankAccountsV2, (i2 & 2) != 0 ? null : bankAccountsV22, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? false : z);
    }

    public final boolean getPrimary() {
        return this.primary;
    }

    public final void setPrimary(boolean z) {
        this.primary = z;
    }

    public VpaDetails(BankAccountsV2 bankAccountsV2, BankAccountsV2 bankAccountsV22, String str, boolean z) {
        this.defaultCredit = bankAccountsV2;
        this.defaultDebit = bankAccountsV22;
        this.name = str;
        this.primary = z;
    }
}
