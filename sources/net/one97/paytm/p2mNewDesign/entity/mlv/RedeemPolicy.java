package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class RedeemPolicy extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "policyText")
    private String policyText;
    @b(a = "policyValue")
    private String policyValue;

    public RedeemPolicy() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ RedeemPolicy copy$default(RedeemPolicy redeemPolicy, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = redeemPolicy.policyText;
        }
        if ((i2 & 2) != 0) {
            str2 = redeemPolicy.policyValue;
        }
        return redeemPolicy.copy(str, str2);
    }

    public final String component1() {
        return this.policyText;
    }

    public final String component2() {
        return this.policyValue;
    }

    public final RedeemPolicy copy(String str, String str2) {
        return new RedeemPolicy(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemPolicy)) {
            return false;
        }
        RedeemPolicy redeemPolicy = (RedeemPolicy) obj;
        return k.a((Object) this.policyText, (Object) redeemPolicy.policyText) && k.a((Object) this.policyValue, (Object) redeemPolicy.policyValue);
    }

    public final int hashCode() {
        String str = this.policyText;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.policyValue;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "RedeemPolicy(policyText=" + this.policyText + ", policyValue=" + this.policyValue + ")";
    }

    public RedeemPolicy(String str, String str2) {
        this.policyText = str;
        this.policyValue = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemPolicy(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getPolicyText() {
        return this.policyText;
    }

    public final String getPolicyValue() {
        return this.policyValue;
    }

    public final void setPolicyText(String str) {
        this.policyText = str;
    }

    public final void setPolicyValue(String str) {
        this.policyValue = str;
    }
}
