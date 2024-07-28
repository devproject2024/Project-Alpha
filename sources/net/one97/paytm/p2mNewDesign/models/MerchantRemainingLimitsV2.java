package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class MerchantRemainingLimitsV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "limitType")
    private String limitType;

    public MerchantRemainingLimitsV2() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ MerchantRemainingLimitsV2 copy$default(MerchantRemainingLimitsV2 merchantRemainingLimitsV2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = merchantRemainingLimitsV2.amount;
        }
        if ((i2 & 2) != 0) {
            str2 = merchantRemainingLimitsV2.limitType;
        }
        return merchantRemainingLimitsV2.copy(str, str2);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component2() {
        return this.limitType;
    }

    public final MerchantRemainingLimitsV2 copy(String str, String str2) {
        return new MerchantRemainingLimitsV2(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantRemainingLimitsV2)) {
            return false;
        }
        MerchantRemainingLimitsV2 merchantRemainingLimitsV2 = (MerchantRemainingLimitsV2) obj;
        return k.a((Object) this.amount, (Object) merchantRemainingLimitsV2.amount) && k.a((Object) this.limitType, (Object) merchantRemainingLimitsV2.limitType);
    }

    public final int hashCode() {
        String str = this.amount;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.limitType;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MerchantRemainingLimitsV2(amount=" + this.amount + ", limitType=" + this.limitType + ")";
    }

    public MerchantRemainingLimitsV2(String str, String str2) {
        this.amount = str;
        this.limitType = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantRemainingLimitsV2(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getLimitType() {
        return this.limitType;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final void setLimitType(String str) {
        this.limitType = str;
    }
}
