package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRPaymentOptionBody extends IJRPaytmDataModel {
    @b(a = "merchantPayOption")
    private CJRMerchantPayOption merchantPayOption;

    public CJRPaymentOptionBody() {
        this((CJRMerchantPayOption) null, 1, (g) null);
    }

    public static /* synthetic */ CJRPaymentOptionBody copy$default(CJRPaymentOptionBody cJRPaymentOptionBody, CJRMerchantPayOption cJRMerchantPayOption, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRMerchantPayOption = cJRPaymentOptionBody.merchantPayOption;
        }
        return cJRPaymentOptionBody.copy(cJRMerchantPayOption);
    }

    public final CJRMerchantPayOption component1() {
        return this.merchantPayOption;
    }

    public final CJRPaymentOptionBody copy(CJRMerchantPayOption cJRMerchantPayOption) {
        return new CJRPaymentOptionBody(cJRMerchantPayOption);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRPaymentOptionBody) && k.a((Object) this.merchantPayOption, (Object) ((CJRPaymentOptionBody) obj).merchantPayOption);
        }
        return true;
    }

    public final int hashCode() {
        CJRMerchantPayOption cJRMerchantPayOption = this.merchantPayOption;
        if (cJRMerchantPayOption != null) {
            return cJRMerchantPayOption.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRPaymentOptionBody(merchantPayOption=" + this.merchantPayOption + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRPaymentOptionBody(CJRMerchantPayOption cJRMerchantPayOption, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : cJRMerchantPayOption);
    }

    public final CJRMerchantPayOption getMerchantPayOption() {
        return this.merchantPayOption;
    }

    public final void setMerchantPayOption(CJRMerchantPayOption cJRMerchantPayOption) {
        this.merchantPayOption = cJRMerchantPayOption;
    }

    public CJRPaymentOptionBody(CJRMerchantPayOption cJRMerchantPayOption) {
        this.merchantPayOption = cJRMerchantPayOption;
    }
}
