package net.one97.paytm.recharge.domain.entities;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRSubscriptionInfo implements IJRDataModel {
    @b(a = "mandateType")
    private String mandateType;
    @b(a = "subscriptionAmountType")
    private String subscriptionAmountType;
    @b(a = "subscriptionEnableRetry")
    private String subscriptionEnableRetry;
    @b(a = "subscriptionExpiryDate")
    private String subscriptionExpiryDate;
    @b(a = "subscriptionFrequency")
    private String subscriptionFrequency;
    @b(a = "subscriptionFrequencyUnit")
    private String subscriptionFrequencyUnit;
    @b(a = "subscriptionGraceDays")
    private String subscriptionGraceDays;
    @b(a = "subscriptionMaxAmount")
    private String subscriptionMaxAmount;
    @b(a = "subscriptionPaymentMode")
    private String subscriptionPaymentMode;
    @b(a = "subscriptionRetryCount")
    private String subscriptionRetryCount;
    @b(a = "subscriptionStartDate")
    private String subscriptionStartDate;

    public CJRSubscriptionInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2047, (g) null);
    }

    public static /* synthetic */ CJRSubscriptionInfo copy$default(CJRSubscriptionInfo cJRSubscriptionInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, Object obj) {
        CJRSubscriptionInfo cJRSubscriptionInfo2 = cJRSubscriptionInfo;
        int i3 = i2;
        return cJRSubscriptionInfo.copy((i3 & 1) != 0 ? cJRSubscriptionInfo2.subscriptionAmountType : str, (i3 & 2) != 0 ? cJRSubscriptionInfo2.subscriptionMaxAmount : str2, (i3 & 4) != 0 ? cJRSubscriptionInfo2.subscriptionFrequency : str3, (i3 & 8) != 0 ? cJRSubscriptionInfo2.subscriptionFrequencyUnit : str4, (i3 & 16) != 0 ? cJRSubscriptionInfo2.subscriptionStartDate : str5, (i3 & 32) != 0 ? cJRSubscriptionInfo2.subscriptionExpiryDate : str6, (i3 & 64) != 0 ? cJRSubscriptionInfo2.subscriptionPaymentMode : str7, (i3 & 128) != 0 ? cJRSubscriptionInfo2.subscriptionGraceDays : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRSubscriptionInfo2.subscriptionEnableRetry : str9, (i3 & 512) != 0 ? cJRSubscriptionInfo2.subscriptionRetryCount : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? cJRSubscriptionInfo2.mandateType : str11);
    }

    public final String component1() {
        return this.subscriptionAmountType;
    }

    public final String component10() {
        return this.subscriptionRetryCount;
    }

    public final String component11() {
        return this.mandateType;
    }

    public final String component2() {
        return this.subscriptionMaxAmount;
    }

    public final String component3() {
        return this.subscriptionFrequency;
    }

    public final String component4() {
        return this.subscriptionFrequencyUnit;
    }

    public final String component5() {
        return this.subscriptionStartDate;
    }

    public final String component6() {
        return this.subscriptionExpiryDate;
    }

    public final String component7() {
        return this.subscriptionPaymentMode;
    }

    public final String component8() {
        return this.subscriptionGraceDays;
    }

    public final String component9() {
        return this.subscriptionEnableRetry;
    }

    public final CJRSubscriptionInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        return new CJRSubscriptionInfo(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRSubscriptionInfo)) {
            return false;
        }
        CJRSubscriptionInfo cJRSubscriptionInfo = (CJRSubscriptionInfo) obj;
        return k.a((Object) this.subscriptionAmountType, (Object) cJRSubscriptionInfo.subscriptionAmountType) && k.a((Object) this.subscriptionMaxAmount, (Object) cJRSubscriptionInfo.subscriptionMaxAmount) && k.a((Object) this.subscriptionFrequency, (Object) cJRSubscriptionInfo.subscriptionFrequency) && k.a((Object) this.subscriptionFrequencyUnit, (Object) cJRSubscriptionInfo.subscriptionFrequencyUnit) && k.a((Object) this.subscriptionStartDate, (Object) cJRSubscriptionInfo.subscriptionStartDate) && k.a((Object) this.subscriptionExpiryDate, (Object) cJRSubscriptionInfo.subscriptionExpiryDate) && k.a((Object) this.subscriptionPaymentMode, (Object) cJRSubscriptionInfo.subscriptionPaymentMode) && k.a((Object) this.subscriptionGraceDays, (Object) cJRSubscriptionInfo.subscriptionGraceDays) && k.a((Object) this.subscriptionEnableRetry, (Object) cJRSubscriptionInfo.subscriptionEnableRetry) && k.a((Object) this.subscriptionRetryCount, (Object) cJRSubscriptionInfo.subscriptionRetryCount) && k.a((Object) this.mandateType, (Object) cJRSubscriptionInfo.mandateType);
    }

    public final int hashCode() {
        String str = this.subscriptionAmountType;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subscriptionMaxAmount;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subscriptionFrequency;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.subscriptionFrequencyUnit;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.subscriptionStartDate;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.subscriptionExpiryDate;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.subscriptionPaymentMode;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.subscriptionGraceDays;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.subscriptionEnableRetry;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.subscriptionRetryCount;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.mandateType;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode10 + i2;
    }

    public final String toString() {
        return "CJRSubscriptionInfo(subscriptionAmountType=" + this.subscriptionAmountType + ", subscriptionMaxAmount=" + this.subscriptionMaxAmount + ", subscriptionFrequency=" + this.subscriptionFrequency + ", subscriptionFrequencyUnit=" + this.subscriptionFrequencyUnit + ", subscriptionStartDate=" + this.subscriptionStartDate + ", subscriptionExpiryDate=" + this.subscriptionExpiryDate + ", subscriptionPaymentMode=" + this.subscriptionPaymentMode + ", subscriptionGraceDays=" + this.subscriptionGraceDays + ", subscriptionEnableRetry=" + this.subscriptionEnableRetry + ", subscriptionRetryCount=" + this.subscriptionRetryCount + ", mandateType=" + this.mandateType + ")";
    }

    public CJRSubscriptionInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.subscriptionAmountType = str;
        this.subscriptionMaxAmount = str2;
        this.subscriptionFrequency = str3;
        this.subscriptionFrequencyUnit = str4;
        this.subscriptionStartDate = str5;
        this.subscriptionExpiryDate = str6;
        this.subscriptionPaymentMode = str7;
        this.subscriptionGraceDays = str8;
        this.subscriptionEnableRetry = str9;
        this.subscriptionRetryCount = str10;
        this.mandateType = str11;
    }

    public final String getSubscriptionAmountType() {
        return this.subscriptionAmountType;
    }

    public final void setSubscriptionAmountType(String str) {
        this.subscriptionAmountType = str;
    }

    public final String getSubscriptionMaxAmount() {
        return this.subscriptionMaxAmount;
    }

    public final void setSubscriptionMaxAmount(String str) {
        this.subscriptionMaxAmount = str;
    }

    public final String getSubscriptionFrequency() {
        return this.subscriptionFrequency;
    }

    public final void setSubscriptionFrequency(String str) {
        this.subscriptionFrequency = str;
    }

    public final String getSubscriptionFrequencyUnit() {
        return this.subscriptionFrequencyUnit;
    }

    public final void setSubscriptionFrequencyUnit(String str) {
        this.subscriptionFrequencyUnit = str;
    }

    public final String getSubscriptionStartDate() {
        return this.subscriptionStartDate;
    }

    public final void setSubscriptionStartDate(String str) {
        this.subscriptionStartDate = str;
    }

    public final String getSubscriptionExpiryDate() {
        return this.subscriptionExpiryDate;
    }

    public final void setSubscriptionExpiryDate(String str) {
        this.subscriptionExpiryDate = str;
    }

    public final String getSubscriptionPaymentMode() {
        return this.subscriptionPaymentMode;
    }

    public final void setSubscriptionPaymentMode(String str) {
        this.subscriptionPaymentMode = str;
    }

    public final String getSubscriptionGraceDays() {
        return this.subscriptionGraceDays;
    }

    public final void setSubscriptionGraceDays(String str) {
        this.subscriptionGraceDays = str;
    }

    public final String getSubscriptionEnableRetry() {
        return this.subscriptionEnableRetry;
    }

    public final void setSubscriptionEnableRetry(String str) {
        this.subscriptionEnableRetry = str;
    }

    public final String getSubscriptionRetryCount() {
        return this.subscriptionRetryCount;
    }

    public final void setSubscriptionRetryCount(String str) {
        this.subscriptionRetryCount = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRSubscriptionInfo(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, int r24, kotlin.g.b.g r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r14
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r15
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x0020
        L_0x001e:
            r5 = r16
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0028
        L_0x0026:
            r6 = r17
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002e
            r7 = r2
            goto L_0x0030
        L_0x002e:
            r7 = r18
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            r8 = r2
            goto L_0x0038
        L_0x0036:
            r8 = r19
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003e
            r9 = r2
            goto L_0x0040
        L_0x003e:
            r9 = r20
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r2
            goto L_0x0048
        L_0x0046:
            r10 = r21
        L_0x0048:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004e
            r11 = r2
            goto L_0x0050
        L_0x004e:
            r11 = r22
        L_0x0050:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r2 = r23
        L_0x0057:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.domain.entities.CJRSubscriptionInfo.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getMandateType() {
        return this.mandateType;
    }

    public final void setMandateType(String str) {
        this.mandateType = str;
    }
}
