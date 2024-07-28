package net.one97.paytm.nativesdk.orflow.promo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public final class PromoListItem implements Parcelable {
    public static final Parcelable.Creator<PromoListItem> CREATOR = new PromoListItem$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((g) null);
    private String campaignType;
    private String code;
    private int freebieListId;
    private String freebieListUrl;
    private List<? extends Freebie> freebies;
    private List<Gratification> gratifications;
    private boolean isFlashSale;
    private Offer offer;
    private String offerText;
    private Object paymentFilters;
    private String promoErrorMsg;
    private String redemptionType;
    private String terms;
    private String termsUrl;
    private String validUpto;

    public PromoListItem() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Offer) null, (List) null, (Object) null, false, 0, (String) null, (List) null, (String) null, (String) null, 16383, (g) null);
    }

    public static /* synthetic */ PromoListItem copy$default(PromoListItem promoListItem, String str, String str2, String str3, String str4, String str5, Offer offer2, List list, Object obj, boolean z, int i2, String str6, List list2, String str7, String str8, int i3, Object obj2) {
        PromoListItem promoListItem2 = promoListItem;
        int i4 = i3;
        return promoListItem.copy((i4 & 1) != 0 ? promoListItem2.code : str, (i4 & 2) != 0 ? promoListItem2.redemptionType : str2, (i4 & 4) != 0 ? promoListItem2.terms : str3, (i4 & 8) != 0 ? promoListItem2.offerText : str4, (i4 & 16) != 0 ? promoListItem2.validUpto : str5, (i4 & 32) != 0 ? promoListItem2.offer : offer2, (i4 & 64) != 0 ? promoListItem2.gratifications : list, (i4 & 128) != 0 ? promoListItem2.paymentFilters : obj, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? promoListItem2.isFlashSale : z, (i4 & 512) != 0 ? promoListItem2.freebieListId : i2, (i4 & TarConstants.EOF_BLOCK) != 0 ? promoListItem2.freebieListUrl : str6, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? promoListItem2.freebies : list2, (i4 & 4096) != 0 ? promoListItem2.campaignType : str7, (i4 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? promoListItem2.termsUrl : str8);
    }

    public final String component1() {
        return this.code;
    }

    public final int component10() {
        return this.freebieListId;
    }

    public final String component11() {
        return this.freebieListUrl;
    }

    public final List<Freebie> component12() {
        return this.freebies;
    }

    public final String component13() {
        return this.campaignType;
    }

    public final String component14() {
        return this.termsUrl;
    }

    public final String component2() {
        return this.redemptionType;
    }

    public final String component3() {
        return this.terms;
    }

    public final String component4() {
        return this.offerText;
    }

    public final String component5() {
        return this.validUpto;
    }

    public final Offer component6() {
        return this.offer;
    }

    public final List<Gratification> component7() {
        return this.gratifications;
    }

    public final Object component8() {
        return this.paymentFilters;
    }

    public final boolean component9() {
        return this.isFlashSale;
    }

    public final PromoListItem copy(String str, String str2, String str3, String str4, String str5, Offer offer2, List<Gratification> list, Object obj, boolean z, int i2, String str6, List<? extends Freebie> list2, String str7, String str8) {
        return new PromoListItem(str, str2, str3, str4, str5, offer2, list, obj, z, i2, str6, list2, str7, str8);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromoListItem)) {
            return false;
        }
        PromoListItem promoListItem = (PromoListItem) obj;
        return k.a((Object) this.code, (Object) promoListItem.code) && k.a((Object) this.redemptionType, (Object) promoListItem.redemptionType) && k.a((Object) this.terms, (Object) promoListItem.terms) && k.a((Object) this.offerText, (Object) promoListItem.offerText) && k.a((Object) this.validUpto, (Object) promoListItem.validUpto) && k.a((Object) this.offer, (Object) promoListItem.offer) && k.a((Object) this.gratifications, (Object) promoListItem.gratifications) && k.a(this.paymentFilters, promoListItem.paymentFilters) && this.isFlashSale == promoListItem.isFlashSale && this.freebieListId == promoListItem.freebieListId && k.a((Object) this.freebieListUrl, (Object) promoListItem.freebieListUrl) && k.a((Object) this.freebies, (Object) promoListItem.freebies) && k.a((Object) this.campaignType, (Object) promoListItem.campaignType) && k.a((Object) this.termsUrl, (Object) promoListItem.termsUrl);
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.redemptionType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.terms;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.offerText;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.validUpto;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Offer offer2 = this.offer;
        int hashCode6 = (hashCode5 + (offer2 != null ? offer2.hashCode() : 0)) * 31;
        List<Gratification> list = this.gratifications;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        Object obj = this.paymentFilters;
        int hashCode8 = (hashCode7 + (obj != null ? obj.hashCode() : 0)) * 31;
        boolean z = this.isFlashSale;
        if (z) {
            z = true;
        }
        int i3 = (((hashCode8 + (z ? 1 : 0)) * 31) + this.freebieListId) * 31;
        String str6 = this.freebieListUrl;
        int hashCode9 = (i3 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<? extends Freebie> list2 = this.freebies;
        int hashCode10 = (hashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str7 = this.campaignType;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.termsUrl;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode11 + i2;
    }

    public final String toString() {
        return "PromoListItem(code=" + this.code + ", redemptionType=" + this.redemptionType + ", terms=" + this.terms + ", offerText=" + this.offerText + ", validUpto=" + this.validUpto + ", offer=" + this.offer + ", gratifications=" + this.gratifications + ", paymentFilters=" + this.paymentFilters + ", isFlashSale=" + this.isFlashSale + ", freebieListId=" + this.freebieListId + ", freebieListUrl=" + this.freebieListUrl + ", freebies=" + this.freebies + ", campaignType=" + this.campaignType + ", termsUrl=" + this.termsUrl + ")";
    }

    public PromoListItem(String str, String str2, String str3, String str4, String str5, Offer offer2, List<Gratification> list, Object obj, boolean z, int i2, String str6, List<? extends Freebie> list2, String str7, String str8) {
        this.code = str;
        this.redemptionType = str2;
        this.terms = str3;
        this.offerText = str4;
        this.validUpto = str5;
        this.offer = offer2;
        this.gratifications = list;
        this.paymentFilters = obj;
        this.isFlashSale = z;
        this.freebieListId = i2;
        this.freebieListUrl = str6;
        this.freebies = list2;
        this.campaignType = str7;
        this.termsUrl = str8;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final String getRedemptionType() {
        return this.redemptionType;
    }

    public final void setRedemptionType(String str) {
        this.redemptionType = str;
    }

    public final String getTerms() {
        return this.terms;
    }

    public final void setTerms(String str) {
        this.terms = str;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final void setOfferText(String str) {
        this.offerText = str;
    }

    public final String getValidUpto() {
        return this.validUpto;
    }

    public final void setValidUpto(String str) {
        this.validUpto = str;
    }

    public final Offer getOffer() {
        return this.offer;
    }

    public final void setOffer(Offer offer2) {
        this.offer = offer2;
    }

    public final List<Gratification> getGratifications() {
        return this.gratifications;
    }

    public final void setGratifications(List<Gratification> list) {
        this.gratifications = list;
    }

    public final Object getPaymentFilters() {
        return this.paymentFilters;
    }

    public final void setPaymentFilters(Object obj) {
        this.paymentFilters = obj;
    }

    public final boolean isFlashSale() {
        return this.isFlashSale;
    }

    public final void setFlashSale(boolean z) {
        this.isFlashSale = z;
    }

    public final int getFreebieListId() {
        return this.freebieListId;
    }

    public final void setFreebieListId(int i2) {
        this.freebieListId = i2;
    }

    public final String getFreebieListUrl() {
        return this.freebieListUrl;
    }

    public final void setFreebieListUrl(String str) {
        this.freebieListUrl = str;
    }

    public final List<Freebie> getFreebies() {
        return this.freebies;
    }

    public final void setFreebies(List<? extends Freebie> list) {
        this.freebies = list;
    }

    public final String getCampaignType() {
        return this.campaignType;
    }

    public final void setCampaignType(String str) {
        this.campaignType = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PromoListItem(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, net.one97.paytm.nativesdk.orflow.promo.model.Offer r21, java.util.List r22, java.lang.Object r23, boolean r24, int r25, java.lang.String r26, java.util.List r27, java.lang.String r28, java.lang.String r29, int r30, kotlin.g.b.g r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r19
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r21
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r22
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r23
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = 0
            goto L_0x004b
        L_0x0049:
            r10 = r24
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = -1
            goto L_0x0053
        L_0x0051:
            r11 = r25
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r26
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r27
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r28
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r29
        L_0x0072:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.nativesdk.orflow.promo.model.Offer, java.util.List, java.lang.Object, boolean, int, java.lang.String, java.util.List, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getTermsUrl() {
        return this.termsUrl;
    }

    public final void setTermsUrl(String str) {
        this.termsUrl = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PromoListItem(android.os.Parcel r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = "source"
            kotlin.g.b.k.c(r0, r1)
            java.lang.String r3 = r18.readString()
            java.lang.String r4 = r18.readString()
            java.lang.String r5 = r18.readString()
            java.lang.String r6 = r18.readString()
            java.lang.String r7 = r18.readString()
            java.lang.Class<net.one97.paytm.nativesdk.orflow.promo.model.Offer> r1 = net.one97.paytm.nativesdk.orflow.promo.model.Offer.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r0.readParcelable(r1)
            r8 = r1
            net.one97.paytm.nativesdk.orflow.promo.model.Offer r8 = (net.one97.paytm.nativesdk.orflow.promo.model.Offer) r8
            net.one97.paytm.nativesdk.orflow.promo.model.Gratification$CREATOR r1 = net.one97.paytm.nativesdk.orflow.promo.model.Gratification.CREATOR
            android.os.Parcelable$Creator r1 = (android.os.Parcelable.Creator) r1
            java.util.ArrayList r1 = r0.createTypedArrayList(r1)
            r9 = r1
            java.util.List r9 = (java.util.List) r9
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r10 = r0.readValue(r1)
            int r1 = r18.readInt()
            r2 = 1
            if (r1 != r2) goto L_0x0047
            r11 = 1
            goto L_0x0049
        L_0x0047:
            r1 = 0
            r11 = 0
        L_0x0049:
            int r12 = r18.readInt()
            java.lang.String r13 = r18.readString()
            android.os.Parcelable$Creator<net.one97.paytm.nativesdk.orflow.promo.model.Freebie> r1 = net.one97.paytm.nativesdk.orflow.promo.model.Freebie.CREATOR
            java.util.ArrayList r1 = r0.createTypedArrayList(r1)
            r14 = r1
            java.util.List r14 = (java.util.List) r14
            java.lang.String r15 = r18.readString()
            java.lang.String r16 = r18.readString()
            r2 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.model.PromoListItem.<init>(android.os.Parcel):void");
    }

    public final String getPromoErrorMsg() {
        return this.promoErrorMsg;
    }

    public final void setPromoErrorMsg(String str) {
        this.promoErrorMsg = str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "dest");
        parcel.writeString(this.code);
        parcel.writeString(this.redemptionType);
        parcel.writeString(this.terms);
        parcel.writeString(this.offerText);
        parcel.writeString(this.validUpto);
        parcel.writeParcelable(this.offer, 0);
        parcel.writeTypedList(this.gratifications);
        parcel.writeValue(this.paymentFilters);
        parcel.writeInt(this.isFlashSale ? 1 : 0);
        parcel.writeInt(this.freebieListId);
        parcel.writeString(this.freebieListUrl);
        parcel.writeTypedList(this.freebies);
        parcel.writeString(this.campaignType);
        parcel.writeString(this.termsUrl);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoListItem create(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            if (jSONObject2 == null) {
                return null;
            }
            PromoListItem promoListItem = r1;
            PromoListItem promoListItem2 = new PromoListItem((String) null, (String) null, (String) null, (String) null, (String) null, (Offer) null, (List) null, (Object) null, false, 0, (String) null, (List) null, (String) null, (String) null, 16383, (g) null);
            PromoListItem promoListItem3 = promoListItem;
            promoListItem3.setCode(jSONObject2.optString("code"));
            promoListItem3.setRedemptionType(jSONObject2.optString("redemptionType"));
            promoListItem3.setOffer(Offer.Companion.create(jSONObject2.optJSONObject("offer")));
            promoListItem3.setGratifications(Gratification.CREATOR.createGratificationArray(jSONObject2.optJSONArray("gratifications")));
            promoListItem3.setPaymentFilters(JsonUtils.INSTANCE.getObject(jSONObject2, "paymentFilters"));
            promoListItem3.setTerms(jSONObject2.optString("terms"));
            promoListItem3.setOfferText(jSONObject2.optString("offerText"));
            promoListItem3.setValidUpto(jSONObject2.optString("valid_upto"));
            promoListItem3.setFlashSale(jSONObject2.optBoolean("isFlashCode"));
            promoListItem3.setFreebieListId(jSONObject2.optInt("freebieList"));
            promoListItem3.setFreebieListUrl(jSONObject2.optString("freebieListUrl"));
            promoListItem3.setCampaignType(jSONObject2.optString("campaignType"));
            promoListItem3.setTermsUrl(jSONObject2.optString("termsUrl"));
            return promoListItem3;
        }

        public final ArrayList<PromoListItem> createPromoArray(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList<PromoListItem> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(create(jSONArray.getJSONObject(i2)));
            }
            return arrayList;
        }
    }
}
