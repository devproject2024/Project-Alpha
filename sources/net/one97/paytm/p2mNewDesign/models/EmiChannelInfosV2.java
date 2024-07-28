package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.p2mNewDesign.entity.a;
import net.one97.paytm.upi.util.UpiConstants;

public final class EmiChannelInfosV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "cardAcquiringMode")
    private final a cardAcquiringMode;
    @b(a = "emiAmount")
    private final MoneyV2 emiAmount;
    @b(a = "interestRate")
    private final String interestRate;
    @b(a = "maxAmount")
    private final MoneyV2 maxAmount;
    @b(a = "minAmount")
    private final MoneyV2 minAmount;
    @b(a = "ofMonths")
    private final String ofMonths;
    @b(a = "perInstallment")
    private final String perInstallment;
    @b(a = "planId")
    private final String planId;
    @b(a = "tenureId")
    private final String tenureId;
    @b(a = "totalAmount")
    private final MoneyV2 totalAmount;

    public EmiChannelInfosV2() {
        this((String) null, (String) null, (String) null, (String) null, (MoneyV2) null, (MoneyV2) null, (a) null, (String) null, (MoneyV2) null, (MoneyV2) null, 1023, (g) null);
    }

    public static /* synthetic */ EmiChannelInfosV2 copy$default(EmiChannelInfosV2 emiChannelInfosV2, String str, String str2, String str3, String str4, MoneyV2 moneyV2, MoneyV2 moneyV22, a aVar, String str5, MoneyV2 moneyV23, MoneyV2 moneyV24, int i2, Object obj) {
        EmiChannelInfosV2 emiChannelInfosV22 = emiChannelInfosV2;
        int i3 = i2;
        return emiChannelInfosV2.copy((i3 & 1) != 0 ? emiChannelInfosV22.planId : str, (i3 & 2) != 0 ? emiChannelInfosV22.tenureId : str2, (i3 & 4) != 0 ? emiChannelInfosV22.interestRate : str3, (i3 & 8) != 0 ? emiChannelInfosV22.ofMonths : str4, (i3 & 16) != 0 ? emiChannelInfosV22.minAmount : moneyV2, (i3 & 32) != 0 ? emiChannelInfosV22.maxAmount : moneyV22, (i3 & 64) != 0 ? emiChannelInfosV22.cardAcquiringMode : aVar, (i3 & 128) != 0 ? emiChannelInfosV22.perInstallment : str5, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? emiChannelInfosV22.emiAmount : moneyV23, (i3 & 512) != 0 ? emiChannelInfosV22.totalAmount : moneyV24);
    }

    public final String component1() {
        return this.planId;
    }

    public final MoneyV2 component10() {
        return this.totalAmount;
    }

    public final String component2() {
        return this.tenureId;
    }

    public final String component3() {
        return this.interestRate;
    }

    public final String component4() {
        return this.ofMonths;
    }

    public final MoneyV2 component5() {
        return this.minAmount;
    }

    public final MoneyV2 component6() {
        return this.maxAmount;
    }

    public final a component7() {
        return this.cardAcquiringMode;
    }

    public final String component8() {
        return this.perInstallment;
    }

    public final MoneyV2 component9() {
        return this.emiAmount;
    }

    public final EmiChannelInfosV2 copy(String str, String str2, String str3, String str4, MoneyV2 moneyV2, MoneyV2 moneyV22, a aVar, String str5, MoneyV2 moneyV23, MoneyV2 moneyV24) {
        return new EmiChannelInfosV2(str, str2, str3, str4, moneyV2, moneyV22, aVar, str5, moneyV23, moneyV24);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmiChannelInfosV2)) {
            return false;
        }
        EmiChannelInfosV2 emiChannelInfosV2 = (EmiChannelInfosV2) obj;
        return k.a((Object) this.planId, (Object) emiChannelInfosV2.planId) && k.a((Object) this.tenureId, (Object) emiChannelInfosV2.tenureId) && k.a((Object) this.interestRate, (Object) emiChannelInfosV2.interestRate) && k.a((Object) this.ofMonths, (Object) emiChannelInfosV2.ofMonths) && k.a((Object) this.minAmount, (Object) emiChannelInfosV2.minAmount) && k.a((Object) this.maxAmount, (Object) emiChannelInfosV2.maxAmount) && k.a((Object) this.cardAcquiringMode, (Object) emiChannelInfosV2.cardAcquiringMode) && k.a((Object) this.perInstallment, (Object) emiChannelInfosV2.perInstallment) && k.a((Object) this.emiAmount, (Object) emiChannelInfosV2.emiAmount) && k.a((Object) this.totalAmount, (Object) emiChannelInfosV2.totalAmount);
    }

    public final int hashCode() {
        String str = this.planId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tenureId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.interestRate;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ofMonths;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        MoneyV2 moneyV2 = this.minAmount;
        int hashCode5 = (hashCode4 + (moneyV2 != null ? moneyV2.hashCode() : 0)) * 31;
        MoneyV2 moneyV22 = this.maxAmount;
        int hashCode6 = (hashCode5 + (moneyV22 != null ? moneyV22.hashCode() : 0)) * 31;
        a aVar = this.cardAcquiringMode;
        int hashCode7 = (hashCode6 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str5 = this.perInstallment;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        MoneyV2 moneyV23 = this.emiAmount;
        int hashCode9 = (hashCode8 + (moneyV23 != null ? moneyV23.hashCode() : 0)) * 31;
        MoneyV2 moneyV24 = this.totalAmount;
        if (moneyV24 != null) {
            i2 = moneyV24.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "EmiChannelInfosV2(planId=" + this.planId + ", tenureId=" + this.tenureId + ", interestRate=" + this.interestRate + ", ofMonths=" + this.ofMonths + ", minAmount=" + this.minAmount + ", maxAmount=" + this.maxAmount + ", cardAcquiringMode=" + this.cardAcquiringMode + ", perInstallment=" + this.perInstallment + ", emiAmount=" + this.emiAmount + ", totalAmount=" + this.totalAmount + ")";
    }

    public EmiChannelInfosV2(String str, String str2, String str3, String str4, MoneyV2 moneyV2, MoneyV2 moneyV22, a aVar, String str5, MoneyV2 moneyV23, MoneyV2 moneyV24) {
        this.planId = str;
        this.tenureId = str2;
        this.interestRate = str3;
        this.ofMonths = str4;
        this.minAmount = moneyV2;
        this.maxAmount = moneyV22;
        this.cardAcquiringMode = aVar;
        this.perInstallment = str5;
        this.emiAmount = moneyV23;
        this.totalAmount = moneyV24;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EmiChannelInfosV2(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, net.one97.paytm.p2mNewDesign.models.MoneyV2 r16, net.one97.paytm.p2mNewDesign.models.MoneyV2 r17, net.one97.paytm.p2mNewDesign.entity.a r18, java.lang.String r19, net.one97.paytm.p2mNewDesign.models.MoneyV2 r20, net.one97.paytm.p2mNewDesign.models.MoneyV2 r21, int r22, kotlin.g.b.g r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r2
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r2
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r2 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.EmiChannelInfosV2.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.models.MoneyV2, net.one97.paytm.p2mNewDesign.models.MoneyV2, net.one97.paytm.p2mNewDesign.entity.a, java.lang.String, net.one97.paytm.p2mNewDesign.models.MoneyV2, net.one97.paytm.p2mNewDesign.models.MoneyV2, int, kotlin.g.b.g):void");
    }

    public final a getCardAcquiringMode() {
        return this.cardAcquiringMode;
    }

    public final MoneyV2 getEmiAmount() {
        return this.emiAmount;
    }

    public final String getInterestRate() {
        return this.interestRate;
    }

    public final MoneyV2 getMaxAmount() {
        return this.maxAmount;
    }

    public final MoneyV2 getMinAmount() {
        return this.minAmount;
    }

    public final String getOfMonths() {
        return this.ofMonths;
    }

    public final String getPerInstallment() {
        return this.perInstallment;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getTenureId() {
        return this.tenureId;
    }

    public final MoneyV2 getTotalAmount() {
        return this.totalAmount;
    }
}
