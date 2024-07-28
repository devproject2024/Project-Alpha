package net.one97.paytm.passbook.beans.mgv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MerchantLogoInfo extends IJRDataModel {
    @b(a = "merchantBusinessName")
    private String merchantBusinessName;
    @b(a = "merchantDisplayName")
    private String merchantDisplayName;
    @b(a = "merchantImageName")
    private String merchantImageName;
    @b(a = "paytmMid")
    private String paytmMid;

    public static /* synthetic */ MerchantLogoInfo copy$default(MerchantLogoInfo merchantLogoInfo, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = merchantLogoInfo.merchantBusinessName;
        }
        if ((i2 & 2) != 0) {
            str2 = merchantLogoInfo.merchantDisplayName;
        }
        if ((i2 & 4) != 0) {
            str3 = merchantLogoInfo.merchantImageName;
        }
        if ((i2 & 8) != 0) {
            str4 = merchantLogoInfo.paytmMid;
        }
        return merchantLogoInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.merchantBusinessName;
    }

    public final String component2() {
        return this.merchantDisplayName;
    }

    public final String component3() {
        return this.merchantImageName;
    }

    public final String component4() {
        return this.paytmMid;
    }

    public final MerchantLogoInfo copy(String str, String str2, String str3, String str4) {
        k.c(str, "merchantBusinessName");
        k.c(str2, "merchantDisplayName");
        k.c(str3, "merchantImageName");
        k.c(str4, "paytmMid");
        return new MerchantLogoInfo(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantLogoInfo)) {
            return false;
        }
        MerchantLogoInfo merchantLogoInfo = (MerchantLogoInfo) obj;
        return k.a((Object) this.merchantBusinessName, (Object) merchantLogoInfo.merchantBusinessName) && k.a((Object) this.merchantDisplayName, (Object) merchantLogoInfo.merchantDisplayName) && k.a((Object) this.merchantImageName, (Object) merchantLogoInfo.merchantImageName) && k.a((Object) this.paytmMid, (Object) merchantLogoInfo.paytmMid);
    }

    public final int hashCode() {
        String str = this.merchantBusinessName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merchantDisplayName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.merchantImageName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.paytmMid;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MerchantLogoInfo(merchantBusinessName=" + this.merchantBusinessName + ", merchantDisplayName=" + this.merchantDisplayName + ", merchantImageName=" + this.merchantImageName + ", paytmMid=" + this.paytmMid + ")";
    }

    public final String getMerchantBusinessName() {
        return this.merchantBusinessName;
    }

    public final void setMerchantBusinessName(String str) {
        k.c(str, "<set-?>");
        this.merchantBusinessName = str;
    }

    public final String getMerchantDisplayName() {
        return this.merchantDisplayName;
    }

    public final void setMerchantDisplayName(String str) {
        k.c(str, "<set-?>");
        this.merchantDisplayName = str;
    }

    public final String getMerchantImageName() {
        return this.merchantImageName;
    }

    public final void setMerchantImageName(String str) {
        k.c(str, "<set-?>");
        this.merchantImageName = str;
    }

    public final String getPaytmMid() {
        return this.paytmMid;
    }

    public final void setPaytmMid(String str) {
        k.c(str, "<set-?>");
        this.paytmMid = str;
    }

    public MerchantLogoInfo(String str, String str2, String str3, String str4) {
        k.c(str, "merchantBusinessName");
        k.c(str2, "merchantDisplayName");
        k.c(str3, "merchantImageName");
        k.c(str4, "paytmMid");
        this.merchantBusinessName = str;
        this.merchantDisplayName = str2;
        this.merchantImageName = str3;
        this.paytmMid = str4;
    }
}
