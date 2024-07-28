package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class MerchantPaymodesLimits extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "limit")
    private String limit;
    @b(a = "msg")
    private String msg;
    @b(a = "payMode")
    private String payMode;
    @b(a = "showPopUp")
    private boolean showPopUp;

    public MerchantPaymodesLimits() {
        this((String) null, (String) null, (String) null, false, 15, (g) null);
    }

    public static /* synthetic */ MerchantPaymodesLimits copy$default(MerchantPaymodesLimits merchantPaymodesLimits, String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = merchantPaymodesLimits.msg;
        }
        if ((i2 & 2) != 0) {
            str2 = merchantPaymodesLimits.payMode;
        }
        if ((i2 & 4) != 0) {
            str3 = merchantPaymodesLimits.limit;
        }
        if ((i2 & 8) != 0) {
            z = merchantPaymodesLimits.showPopUp;
        }
        return merchantPaymodesLimits.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.msg;
    }

    public final String component2() {
        return this.payMode;
    }

    public final String component3() {
        return this.limit;
    }

    public final boolean component4() {
        return this.showPopUp;
    }

    public final MerchantPaymodesLimits copy(String str, String str2, String str3, boolean z) {
        return new MerchantPaymodesLimits(str, str2, str3, z);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof MerchantPaymodesLimits) {
                MerchantPaymodesLimits merchantPaymodesLimits = (MerchantPaymodesLimits) obj;
                if (k.a((Object) this.msg, (Object) merchantPaymodesLimits.msg) && k.a((Object) this.payMode, (Object) merchantPaymodesLimits.payMode) && k.a((Object) this.limit, (Object) merchantPaymodesLimits.limit)) {
                    if (this.showPopUp == merchantPaymodesLimits.showPopUp) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.msg;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.payMode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.limit;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.showPopUp;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "MerchantPaymodesLimits(msg=" + this.msg + ", payMode=" + this.payMode + ", limit=" + this.limit + ", showPopUp=" + this.showPopUp + ")";
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public final String getPayMode() {
        return this.payMode;
    }

    public final void setPayMode(String str) {
        this.payMode = str;
    }

    public final String getLimit() {
        return this.limit;
    }

    public final void setLimit(String str) {
        this.limit = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MerchantPaymodesLimits(String str, String str2, String str3, boolean z, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? false : z);
    }

    public final boolean getShowPopUp() {
        return this.showPopUp;
    }

    public final void setShowPopUp(boolean z) {
        this.showPopUp = z;
    }

    public MerchantPaymodesLimits(String str, String str2, String str3, boolean z) {
        this.msg = str;
        this.payMode = str2;
        this.limit = str3;
        this.showPopUp = z;
    }
}
