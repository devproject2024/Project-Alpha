package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class CFSVoucherMerchantLogoInfo {
    @c(a = "merchantBusinessName")
    private final String merchantBusinessName;
    @c(a = "merchantDisplayName")
    private final String merchantDisplayName;
    @c(a = "merchantImageName")
    private final String merchantImageName;
    @c(a = "paytmMid")
    private final String paytmMid;

    public static /* synthetic */ CFSVoucherMerchantLogoInfo copy$default(CFSVoucherMerchantLogoInfo cFSVoucherMerchantLogoInfo, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cFSVoucherMerchantLogoInfo.merchantBusinessName;
        }
        if ((i2 & 2) != 0) {
            str2 = cFSVoucherMerchantLogoInfo.merchantDisplayName;
        }
        if ((i2 & 4) != 0) {
            str3 = cFSVoucherMerchantLogoInfo.merchantImageName;
        }
        if ((i2 & 8) != 0) {
            str4 = cFSVoucherMerchantLogoInfo.paytmMid;
        }
        return cFSVoucherMerchantLogoInfo.copy(str, str2, str3, str4);
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

    public final CFSVoucherMerchantLogoInfo copy(String str, String str2, String str3, String str4) {
        return new CFSVoucherMerchantLogoInfo(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CFSVoucherMerchantLogoInfo)) {
            return false;
        }
        CFSVoucherMerchantLogoInfo cFSVoucherMerchantLogoInfo = (CFSVoucherMerchantLogoInfo) obj;
        return k.a((Object) this.merchantBusinessName, (Object) cFSVoucherMerchantLogoInfo.merchantBusinessName) && k.a((Object) this.merchantDisplayName, (Object) cFSVoucherMerchantLogoInfo.merchantDisplayName) && k.a((Object) this.merchantImageName, (Object) cFSVoucherMerchantLogoInfo.merchantImageName) && k.a((Object) this.paytmMid, (Object) cFSVoucherMerchantLogoInfo.paytmMid);
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
        return "CFSVoucherMerchantLogoInfo(merchantBusinessName=" + this.merchantBusinessName + ", merchantDisplayName=" + this.merchantDisplayName + ", merchantImageName=" + this.merchantImageName + ", paytmMid=" + this.paytmMid + ")";
    }

    public CFSVoucherMerchantLogoInfo(String str, String str2, String str3, String str4) {
        this.merchantBusinessName = str;
        this.merchantDisplayName = str2;
        this.merchantImageName = str3;
        this.paytmMid = str4;
    }

    public final String getMerchantBusinessName() {
        return this.merchantBusinessName;
    }

    public final String getMerchantDisplayName() {
        return this.merchantDisplayName;
    }

    public final String getMerchantImageName() {
        return this.merchantImageName;
    }

    public final String getPaytmMid() {
        return this.paytmMid;
    }
}
