package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import net.one97.paytm.network.CJRWalletDataModel;

public final class VpaDetailsV2 extends CJRWalletDataModel {
    @b(a = "defaultCreditAccRefId")
    private String defaultCreditAccRefId;
    @b(a = "defaultDebitAccRefId")
    private String defaultDebitAccRefId;
    @b(a = "name")
    private String name;
    @b(a = "primary")
    private Boolean primary;

    public VpaDetailsV2() {
        this((String) null, (String) null, (String) null, (Boolean) null, 15, (g) null);
    }

    public VpaDetailsV2(String str, String str2, String str3, Boolean bool) {
        this.defaultCreditAccRefId = str;
        this.name = str2;
        this.defaultDebitAccRefId = str3;
        this.primary = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VpaDetailsV2(String str, String str2, String str3, Boolean bool, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? Boolean.FALSE : bool);
    }

    public final String getDefaultCreditAccRefId() {
        return this.defaultCreditAccRefId;
    }

    public final String getDefaultDebitAccRefId() {
        return this.defaultDebitAccRefId;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getPrimary() {
        return this.primary;
    }

    public final void setDefaultCreditAccRefId(String str) {
        this.defaultCreditAccRefId = str;
    }

    public final void setDefaultDebitAccRefId(String str) {
        this.defaultDebitAccRefId = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPrimary(Boolean bool) {
        this.primary = bool;
    }
}
