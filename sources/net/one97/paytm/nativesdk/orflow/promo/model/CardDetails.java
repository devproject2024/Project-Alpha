package net.one97.paytm.nativesdk.orflow.promo.model;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.HasLowSuccess;

public final class CardDetails implements Serializable {
    private String[] authModes;
    private BinDetails binDetail;
    private HasLowSuccess hasLowSuccessRate;
    private String iconUrl;
    private Boolean isEmiAvailable;
    private String subventionType;

    public CardDetails() {
        this((BinDetails) null, (String[]) null, (HasLowSuccess) null, (Boolean) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ CardDetails copy$default(CardDetails cardDetails, BinDetails binDetails, String[] strArr, HasLowSuccess hasLowSuccess, Boolean bool, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            binDetails = cardDetails.binDetail;
        }
        if ((i2 & 2) != 0) {
            strArr = cardDetails.authModes;
        }
        String[] strArr2 = strArr;
        if ((i2 & 4) != 0) {
            hasLowSuccess = cardDetails.hasLowSuccessRate;
        }
        HasLowSuccess hasLowSuccess2 = hasLowSuccess;
        if ((i2 & 8) != 0) {
            bool = cardDetails.isEmiAvailable;
        }
        Boolean bool2 = bool;
        if ((i2 & 16) != 0) {
            str = cardDetails.subventionType;
        }
        String str3 = str;
        if ((i2 & 32) != 0) {
            str2 = cardDetails.iconUrl;
        }
        return cardDetails.copy(binDetails, strArr2, hasLowSuccess2, bool2, str3, str2);
    }

    public final BinDetails component1() {
        return this.binDetail;
    }

    public final String[] component2() {
        return this.authModes;
    }

    public final HasLowSuccess component3() {
        return this.hasLowSuccessRate;
    }

    public final Boolean component4() {
        return this.isEmiAvailable;
    }

    public final String component5() {
        return this.subventionType;
    }

    public final String component6() {
        return this.iconUrl;
    }

    public final CardDetails copy(BinDetails binDetails, String[] strArr, HasLowSuccess hasLowSuccess, Boolean bool, String str, String str2) {
        return new CardDetails(binDetails, strArr, hasLowSuccess, bool, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardDetails)) {
            return false;
        }
        CardDetails cardDetails = (CardDetails) obj;
        return k.a((Object) this.binDetail, (Object) cardDetails.binDetail) && k.a((Object) this.authModes, (Object) cardDetails.authModes) && k.a((Object) this.hasLowSuccessRate, (Object) cardDetails.hasLowSuccessRate) && k.a((Object) this.isEmiAvailable, (Object) cardDetails.isEmiAvailable) && k.a((Object) this.subventionType, (Object) cardDetails.subventionType) && k.a((Object) this.iconUrl, (Object) cardDetails.iconUrl);
    }

    public final int hashCode() {
        BinDetails binDetails = this.binDetail;
        int i2 = 0;
        int hashCode = (binDetails != null ? binDetails.hashCode() : 0) * 31;
        String[] strArr = this.authModes;
        int hashCode2 = (hashCode + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        HasLowSuccess hasLowSuccess = this.hasLowSuccessRate;
        int hashCode3 = (hashCode2 + (hasLowSuccess != null ? hasLowSuccess.hashCode() : 0)) * 31;
        Boolean bool = this.isEmiAvailable;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str = this.subventionType;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.iconUrl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "CardDetails(binDetail=" + this.binDetail + ", authModes=" + Arrays.toString(this.authModes) + ", hasLowSuccessRate=" + this.hasLowSuccessRate + ", isEmiAvailable=" + this.isEmiAvailable + ", subventionType=" + this.subventionType + ", iconUrl=" + this.iconUrl + ")";
    }

    public CardDetails(BinDetails binDetails, String[] strArr, HasLowSuccess hasLowSuccess, Boolean bool, String str, String str2) {
        this.binDetail = binDetails;
        this.authModes = strArr;
        this.hasLowSuccessRate = hasLowSuccess;
        this.isEmiAvailable = bool;
        this.subventionType = str;
        this.iconUrl = str2;
    }

    public final BinDetails getBinDetail() {
        return this.binDetail;
    }

    public final void setBinDetail(BinDetails binDetails) {
        this.binDetail = binDetails;
    }

    public final String[] getAuthModes() {
        return this.authModes;
    }

    public final void setAuthModes(String[] strArr) {
        this.authModes = strArr;
    }

    public final HasLowSuccess getHasLowSuccessRate() {
        return this.hasLowSuccessRate;
    }

    public final void setHasLowSuccessRate(HasLowSuccess hasLowSuccess) {
        this.hasLowSuccessRate = hasLowSuccess;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardDetails(net.one97.paytm.nativesdk.orflow.promo.model.BinDetails r6, java.lang.String[] r7, net.one97.paytm.nativesdk.common.model.HasLowSuccess r8, java.lang.Boolean r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
        L_0x001c:
            r3 = r9
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.model.CardDetails.<init>(net.one97.paytm.nativesdk.orflow.promo.model.BinDetails, java.lang.String[], net.one97.paytm.nativesdk.common.model.HasLowSuccess, java.lang.Boolean, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final Boolean isEmiAvailable() {
        return this.isEmiAvailable;
    }

    public final void setEmiAvailable(Boolean bool) {
        this.isEmiAvailable = bool;
    }

    public final String getSubventionType() {
        return this.subventionType;
    }

    public final void setSubventionType(String str) {
        this.subventionType = str;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }
}
