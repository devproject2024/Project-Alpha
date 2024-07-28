package net.one97.paytm.p2mNewDesign.g;

import java.io.Serializable;
import kotlin.g.b.k;

public final class c implements Serializable {
    private String bonusPoint;
    private String bonusText;
    private String context;
    private boolean isChecked;
    private String merchantName;
    private String policyText;
    private String redeemablePercentage;
    private String totalAvailableBalance;

    public static /* synthetic */ c copy$default(c cVar, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, int i2, Object obj) {
        c cVar2 = cVar;
        int i3 = i2;
        return cVar.copy((i3 & 1) != 0 ? cVar2.merchantName : str, (i3 & 2) != 0 ? cVar2.totalAvailableBalance : str2, (i3 & 4) != 0 ? cVar2.redeemablePercentage : str3, (i3 & 8) != 0 ? cVar2.isChecked : z, (i3 & 16) != 0 ? cVar2.policyText : str4, (i3 & 32) != 0 ? cVar2.context : str5, (i3 & 64) != 0 ? cVar2.bonusText : str6, (i3 & 128) != 0 ? cVar2.bonusPoint : str7);
    }

    public final String component1() {
        return this.merchantName;
    }

    public final String component2() {
        return this.totalAvailableBalance;
    }

    public final String component3() {
        return this.redeemablePercentage;
    }

    public final boolean component4() {
        return this.isChecked;
    }

    public final String component5() {
        return this.policyText;
    }

    public final String component6() {
        return this.context;
    }

    public final String component7() {
        return this.bonusText;
    }

    public final String component8() {
        return this.bonusPoint;
    }

    public final c copy(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7) {
        k.c(str, "merchantName");
        k.c(str4, "policyText");
        return new c(str, str2, str3, z, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (k.a((Object) this.merchantName, (Object) cVar.merchantName) && k.a((Object) this.totalAvailableBalance, (Object) cVar.totalAvailableBalance) && k.a((Object) this.redeemablePercentage, (Object) cVar.redeemablePercentage)) {
                    if (!(this.isChecked == cVar.isChecked) || !k.a((Object) this.policyText, (Object) cVar.policyText) || !k.a((Object) this.context, (Object) cVar.context) || !k.a((Object) this.bonusText, (Object) cVar.bonusText) || !k.a((Object) this.bonusPoint, (Object) cVar.bonusPoint)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.merchantName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.totalAvailableBalance;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.redeemablePercentage;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.isChecked;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        String str4 = this.policyText;
        int hashCode4 = (i3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.context;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.bonusText;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.bonusPoint;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "MLVItem(merchantName=" + this.merchantName + ", totalAvailableBalance=" + this.totalAvailableBalance + ", redeemablePercentage=" + this.redeemablePercentage + ", isChecked=" + this.isChecked + ", policyText=" + this.policyText + ", context=" + this.context + ", bonusText=" + this.bonusText + ", bonusPoint=" + this.bonusPoint + ")";
    }

    public c(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7) {
        k.c(str, "merchantName");
        k.c(str4, "policyText");
        this.merchantName = str;
        this.totalAvailableBalance = str2;
        this.redeemablePercentage = str3;
        this.isChecked = z;
        this.policyText = str4;
        this.context = str5;
        this.bonusText = str6;
        this.bonusPoint = str7;
    }

    public final String getBonusPoint() {
        return this.bonusPoint;
    }

    public final String getBonusText() {
        return this.bonusText;
    }

    public final String getContext() {
        return this.context;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final String getPolicyText() {
        return this.policyText;
    }

    public final String getRedeemablePercentage() {
        return this.redeemablePercentage;
    }

    public final String getTotalAvailableBalance() {
        return this.totalAvailableBalance;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setBonusPoint(String str) {
        this.bonusPoint = str;
    }

    public final void setBonusText(String str) {
        this.bonusText = str;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public final void setContext(String str) {
        this.context = str;
    }

    public final void setMerchantName(String str) {
        k.c(str, "<set-?>");
        this.merchantName = str;
    }

    public final void setPolicyText(String str) {
        k.c(str, "<set-?>");
        this.policyText = str;
    }

    public final void setRedeemablePercentage(String str) {
        this.redeemablePercentage = str;
    }

    public final void setTotalAvailableBalance(String str) {
        this.totalAvailableBalance = str;
    }
}
