package net.one97.paytm.recharge.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRPromoCode extends IJRPaytmDataModel {
    @b(a = "campaignType")
    private String campaignType;
    @b(a = "code")
    private String code;
    @b(a = "gratifications")
    private ArrayList<CJRPromoGratification> gratifications;
    @b(a = "offer")
    private CJRPromoOffer offer;
    @b(a = "offerText")
    private String offerText;
    @b(a = "paymentFilters")
    private CJRPaymentFilters paymentFilters;
    @b(a = "terms")
    private String terms;
    @b(a = "terms_title")
    private String termsTitle;
    @b(a = "totalSaving")
    private Integer totalSaving;
    @b(a = "valid_from")
    private String validFrom;
    @b(a = "valid_upto")
    private String validUpto;
    @b(a = "visible_from")
    private String visibleFrom;
    @b(a = "visible_upto")
    private String visibleUpto;

    public CJRPromoCode() {
        this((String) null, (String) null, (String) null, (CJRPromoOffer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (CJRPaymentFilters) null, 8191, (g) null);
    }

    public static /* synthetic */ CJRPromoCode copy$default(CJRPromoCode cJRPromoCode, String str, String str2, String str3, CJRPromoOffer cJRPromoOffer, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, ArrayList arrayList, CJRPaymentFilters cJRPaymentFilters, int i2, Object obj) {
        CJRPromoCode cJRPromoCode2 = cJRPromoCode;
        int i3 = i2;
        return cJRPromoCode.copy((i3 & 1) != 0 ? cJRPromoCode2.code : str, (i3 & 2) != 0 ? cJRPromoCode2.offerText : str2, (i3 & 4) != 0 ? cJRPromoCode2.terms : str3, (i3 & 8) != 0 ? cJRPromoCode2.offer : cJRPromoOffer, (i3 & 16) != 0 ? cJRPromoCode2.totalSaving : num, (i3 & 32) != 0 ? cJRPromoCode2.campaignType : str4, (i3 & 64) != 0 ? cJRPromoCode2.visibleFrom : str5, (i3 & 128) != 0 ? cJRPromoCode2.visibleUpto : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRPromoCode2.validFrom : str7, (i3 & 512) != 0 ? cJRPromoCode2.validUpto : str8, (i3 & TarConstants.EOF_BLOCK) != 0 ? cJRPromoCode2.termsTitle : str9, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRPromoCode2.gratifications : arrayList, (i3 & 4096) != 0 ? cJRPromoCode2.paymentFilters : cJRPaymentFilters);
    }

    public final String component1() {
        return this.code;
    }

    public final String component10() {
        return this.validUpto;
    }

    public final String component11() {
        return this.termsTitle;
    }

    public final ArrayList<CJRPromoGratification> component12() {
        return this.gratifications;
    }

    public final CJRPaymentFilters component13() {
        return this.paymentFilters;
    }

    public final String component2() {
        return this.offerText;
    }

    public final String component3() {
        return this.terms;
    }

    public final CJRPromoOffer component4() {
        return this.offer;
    }

    public final Integer component5() {
        return this.totalSaving;
    }

    public final String component6() {
        return this.campaignType;
    }

    public final String component7() {
        return this.visibleFrom;
    }

    public final String component8() {
        return this.visibleUpto;
    }

    public final String component9() {
        return this.validFrom;
    }

    public final CJRPromoCode copy(String str, String str2, String str3, CJRPromoOffer cJRPromoOffer, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, ArrayList<CJRPromoGratification> arrayList, CJRPaymentFilters cJRPaymentFilters) {
        return new CJRPromoCode(str, str2, str3, cJRPromoOffer, num, str4, str5, str6, str7, str8, str9, arrayList, cJRPaymentFilters);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRPromoCode)) {
            return false;
        }
        CJRPromoCode cJRPromoCode = (CJRPromoCode) obj;
        return k.a((Object) this.code, (Object) cJRPromoCode.code) && k.a((Object) this.offerText, (Object) cJRPromoCode.offerText) && k.a((Object) this.terms, (Object) cJRPromoCode.terms) && k.a((Object) this.offer, (Object) cJRPromoCode.offer) && k.a((Object) this.totalSaving, (Object) cJRPromoCode.totalSaving) && k.a((Object) this.campaignType, (Object) cJRPromoCode.campaignType) && k.a((Object) this.visibleFrom, (Object) cJRPromoCode.visibleFrom) && k.a((Object) this.visibleUpto, (Object) cJRPromoCode.visibleUpto) && k.a((Object) this.validFrom, (Object) cJRPromoCode.validFrom) && k.a((Object) this.validUpto, (Object) cJRPromoCode.validUpto) && k.a((Object) this.termsTitle, (Object) cJRPromoCode.termsTitle) && k.a((Object) this.gratifications, (Object) cJRPromoCode.gratifications) && k.a((Object) this.paymentFilters, (Object) cJRPromoCode.paymentFilters);
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.offerText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.terms;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        CJRPromoOffer cJRPromoOffer = this.offer;
        int hashCode4 = (hashCode3 + (cJRPromoOffer != null ? cJRPromoOffer.hashCode() : 0)) * 31;
        Integer num = this.totalSaving;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        String str4 = this.campaignType;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.visibleFrom;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.visibleUpto;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.validFrom;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.validUpto;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.termsTitle;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        ArrayList<CJRPromoGratification> arrayList = this.gratifications;
        int hashCode12 = (hashCode11 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        CJRPaymentFilters cJRPaymentFilters = this.paymentFilters;
        if (cJRPaymentFilters != null) {
            i2 = cJRPaymentFilters.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "CJRPromoCode(code=" + this.code + ", offerText=" + this.offerText + ", terms=" + this.terms + ", offer=" + this.offer + ", totalSaving=" + this.totalSaving + ", campaignType=" + this.campaignType + ", visibleFrom=" + this.visibleFrom + ", visibleUpto=" + this.visibleUpto + ", validFrom=" + this.validFrom + ", validUpto=" + this.validUpto + ", termsTitle=" + this.termsTitle + ", gratifications=" + this.gratifications + ", paymentFilters=" + this.paymentFilters + ")";
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final void setOfferText(String str) {
        this.offerText = str;
    }

    public final String getTerms() {
        return this.terms;
    }

    public final void setTerms(String str) {
        this.terms = str;
    }

    public final CJRPromoOffer getOffer() {
        return this.offer;
    }

    public final void setOffer(CJRPromoOffer cJRPromoOffer) {
        this.offer = cJRPromoOffer;
    }

    public final Integer getTotalSaving() {
        return this.totalSaving;
    }

    public final void setTotalSaving(Integer num) {
        this.totalSaving = num;
    }

    public final String getCampaignType() {
        return this.campaignType;
    }

    public final void setCampaignType(String str) {
        this.campaignType = str;
    }

    public final String getVisibleFrom() {
        return this.visibleFrom;
    }

    public final void setVisibleFrom(String str) {
        this.visibleFrom = str;
    }

    public final String getVisibleUpto() {
        return this.visibleUpto;
    }

    public final void setVisibleUpto(String str) {
        this.visibleUpto = str;
    }

    public final String getValidFrom() {
        return this.validFrom;
    }

    public final void setValidFrom(String str) {
        this.validFrom = str;
    }

    public final String getValidUpto() {
        return this.validUpto;
    }

    public final void setValidUpto(String str) {
        this.validUpto = str;
    }

    public final String getTermsTitle() {
        return this.termsTitle;
    }

    public final void setTermsTitle(String str) {
        this.termsTitle = str;
    }

    public final ArrayList<CJRPromoGratification> getGratifications() {
        return this.gratifications;
    }

    public final void setGratifications(ArrayList<CJRPromoGratification> arrayList) {
        this.gratifications = arrayList;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRPromoCode(java.lang.String r15, java.lang.String r16, java.lang.String r17, net.one97.paytm.recharge.model.CJRPromoOffer r18, java.lang.Integer r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.util.ArrayList r26, net.one97.paytm.recharge.model.CJRPaymentFilters r27, int r28, kotlin.g.b.g r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r20
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r22
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r23
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = r2
            goto L_0x0062
        L_0x0060:
            r13 = r26
        L_0x0062:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r2 = r27
        L_0x0069:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.CJRPromoCode.<init>(java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.recharge.model.CJRPromoOffer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, net.one97.paytm.recharge.model.CJRPaymentFilters, int, kotlin.g.b.g):void");
    }

    public final CJRPaymentFilters getPaymentFilters() {
        return this.paymentFilters;
    }

    public final void setPaymentFilters(CJRPaymentFilters cJRPaymentFilters) {
        this.paymentFilters = cJRPaymentFilters;
    }

    public CJRPromoCode(String str, String str2, String str3, CJRPromoOffer cJRPromoOffer, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, ArrayList<CJRPromoGratification> arrayList, CJRPaymentFilters cJRPaymentFilters) {
        this.code = str;
        this.offerText = str2;
        this.terms = str3;
        this.offer = cJRPromoOffer;
        this.totalSaving = num;
        this.campaignType = str4;
        this.visibleFrom = str5;
        this.visibleUpto = str6;
        this.validFrom = str7;
        this.validUpto = str8;
        this.termsTitle = str9;
        this.gratifications = arrayList;
        this.paymentFilters = cJRPaymentFilters;
    }
}
