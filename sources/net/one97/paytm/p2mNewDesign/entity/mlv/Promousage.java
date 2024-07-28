package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class Promousage extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "amount")
    private Double amount;
    @b(a = "campaign")
    private String campaign;
    @b(a = "created_at")
    private String createdAt;
    @b(a = "flags")
    private Integer flags;
    @b(a = "fraud1")
    private String fraud1;
    @b(a = "fulfillment_status")
    private Integer fulfillmentStatus;
    @b(a = "fulfillment_time")
    private String fulfillmentTime;
    @b(a = "promocode_id")
    private String promocodeId;
    @b(a = "redemption_type")
    private String redemptionType;
    @b(a = "site_id")
    private Integer siteId;
    @b(a = "status")
    private Integer status;
    @b(a = "user_id")
    private Integer userId;

    public Promousage() {
        this((Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (Integer) null, (Double) null, 4095, (g) null);
    }

    public static /* synthetic */ Promousage copy$default(Promousage promousage, Integer num, Integer num2, String str, String str2, String str3, Integer num3, String str4, Integer num4, String str5, String str6, Integer num5, Double d2, int i2, Object obj) {
        Promousage promousage2 = promousage;
        int i3 = i2;
        return promousage.copy((i3 & 1) != 0 ? promousage2.siteId : num, (i3 & 2) != 0 ? promousage2.userId : num2, (i3 & 4) != 0 ? promousage2.promocodeId : str, (i3 & 8) != 0 ? promousage2.campaign : str2, (i3 & 16) != 0 ? promousage2.fulfillmentTime : str3, (i3 & 32) != 0 ? promousage2.fulfillmentStatus : num3, (i3 & 64) != 0 ? promousage2.redemptionType : str4, (i3 & 128) != 0 ? promousage2.status : num4, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? promousage2.fraud1 : str5, (i3 & 512) != 0 ? promousage2.createdAt : str6, (i3 & TarConstants.EOF_BLOCK) != 0 ? promousage2.flags : num5, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? promousage2.amount : d2);
    }

    public final Integer component1() {
        return this.siteId;
    }

    public final String component10() {
        return this.createdAt;
    }

    public final Integer component11() {
        return this.flags;
    }

    public final Double component12() {
        return this.amount;
    }

    public final Integer component2() {
        return this.userId;
    }

    public final String component3() {
        return this.promocodeId;
    }

    public final String component4() {
        return this.campaign;
    }

    public final String component5() {
        return this.fulfillmentTime;
    }

    public final Integer component6() {
        return this.fulfillmentStatus;
    }

    public final String component7() {
        return this.redemptionType;
    }

    public final Integer component8() {
        return this.status;
    }

    public final String component9() {
        return this.fraud1;
    }

    public final Promousage copy(Integer num, Integer num2, String str, String str2, String str3, Integer num3, String str4, Integer num4, String str5, String str6, Integer num5, Double d2) {
        return new Promousage(num, num2, str, str2, str3, num3, str4, num4, str5, str6, num5, d2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Promousage)) {
            return false;
        }
        Promousage promousage = (Promousage) obj;
        return k.a((Object) this.siteId, (Object) promousage.siteId) && k.a((Object) this.userId, (Object) promousage.userId) && k.a((Object) this.promocodeId, (Object) promousage.promocodeId) && k.a((Object) this.campaign, (Object) promousage.campaign) && k.a((Object) this.fulfillmentTime, (Object) promousage.fulfillmentTime) && k.a((Object) this.fulfillmentStatus, (Object) promousage.fulfillmentStatus) && k.a((Object) this.redemptionType, (Object) promousage.redemptionType) && k.a((Object) this.status, (Object) promousage.status) && k.a((Object) this.fraud1, (Object) promousage.fraud1) && k.a((Object) this.createdAt, (Object) promousage.createdAt) && k.a((Object) this.flags, (Object) promousage.flags) && k.a((Object) this.amount, (Object) promousage.amount);
    }

    public final int hashCode() {
        Integer num = this.siteId;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.userId;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str = this.promocodeId;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.campaign;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fulfillmentTime;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num3 = this.fulfillmentStatus;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 31;
        String str4 = this.redemptionType;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num4 = this.status;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 31;
        String str5 = this.fraud1;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.createdAt;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num5 = this.flags;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Double d2 = this.amount;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        return hashCode11 + i2;
    }

    public final String toString() {
        return "Promousage(siteId=" + this.siteId + ", userId=" + this.userId + ", promocodeId=" + this.promocodeId + ", campaign=" + this.campaign + ", fulfillmentTime=" + this.fulfillmentTime + ", fulfillmentStatus=" + this.fulfillmentStatus + ", redemptionType=" + this.redemptionType + ", status=" + this.status + ", fraud1=" + this.fraud1 + ", createdAt=" + this.createdAt + ", flags=" + this.flags + ", amount=" + this.amount + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getCampaign() {
        return this.campaign;
    }

    public final Integer getFulfillmentStatus() {
        return this.fulfillmentStatus;
    }

    public final String getFulfillmentTime() {
        return this.fulfillmentTime;
    }

    public final String getPromocodeId() {
        return this.promocodeId;
    }

    public final String getRedemptionType() {
        return this.redemptionType;
    }

    public final Integer getSiteId() {
        return this.siteId;
    }

    public final Integer getUserId() {
        return this.userId;
    }

    public final void setCampaign(String str) {
        this.campaign = str;
    }

    public final void setFulfillmentStatus(Integer num) {
        this.fulfillmentStatus = num;
    }

    public final void setFulfillmentTime(String str) {
        this.fulfillmentTime = str;
    }

    public final void setPromocodeId(String str) {
        this.promocodeId = str;
    }

    public final void setRedemptionType(String str) {
        this.redemptionType = str;
    }

    public final void setSiteId(Integer num) {
        this.siteId = num;
    }

    public final void setUserId(Integer num) {
        this.userId = num;
    }

    public Promousage(Integer num, Integer num2, String str, String str2, String str3, Integer num3, String str4, Integer num4, String str5, String str6, Integer num5, Double d2) {
        this.siteId = num;
        this.userId = num2;
        this.promocodeId = str;
        this.campaign = str2;
        this.fulfillmentTime = str3;
        this.fulfillmentStatus = num3;
        this.redemptionType = str4;
        this.status = num4;
        this.fraud1 = str5;
        this.createdAt = str6;
        this.flags = num5;
        this.amount = d2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Promousage(java.lang.Integer r14, java.lang.Integer r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.Integer r19, java.lang.String r20, java.lang.Integer r21, java.lang.String r22, java.lang.String r23, java.lang.Integer r24, java.lang.Double r25, int r26, kotlin.g.b.g r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r21
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r22
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r23
        L_0x0051:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0057
            r12 = r2
            goto L_0x0059
        L_0x0057:
            r12 = r24
        L_0x0059:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r2 = r25
        L_0x0060:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.Promousage.<init>(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Double, int, kotlin.g.b.g):void");
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final Integer getFlags() {
        return this.flags;
    }

    public final String getFraud1() {
        return this.fraud1;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setAmount(Double d2) {
        this.amount = d2;
    }

    public final void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public final void setFlags(Integer num) {
        this.flags = num;
    }

    public final void setFraud1(String str) {
        this.fraud1 = str;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }
}
