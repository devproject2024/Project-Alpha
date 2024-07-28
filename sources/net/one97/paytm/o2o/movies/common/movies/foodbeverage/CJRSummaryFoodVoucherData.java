package net.one97.paytm.o2o.movies.common.movies.foodbeverage;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRSummaryFoodVoucherData implements IJRDataModel {
    @b(a = "expiry")
    private String expiry;
    @b(a = "itemDescription")
    private String itemDescription;
    @b(a = "itemImageUrl")
    private String itemImageUrl;
    @b(a = "itemName")
    private String itemName;
    @b(a = "quantity")
    private int quantity;
    @b(a = "term_condition_redeem_process")
    private String termConditionRedeemProcess;
    @b(a = "totalChargedPrice")
    private String totalChargedPrice;
    @b(a = "unitPrice")
    private String unitPrice;

    public CJRSummaryFoodVoucherData() {
        this((String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public static /* synthetic */ CJRSummaryFoodVoucherData copy$default(CJRSummaryFoodVoucherData cJRSummaryFoodVoucherData, String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7, int i3, Object obj) {
        CJRSummaryFoodVoucherData cJRSummaryFoodVoucherData2 = cJRSummaryFoodVoucherData;
        int i4 = i3;
        return cJRSummaryFoodVoucherData.copy((i4 & 1) != 0 ? cJRSummaryFoodVoucherData2.itemDescription : str, (i4 & 2) != 0 ? cJRSummaryFoodVoucherData2.itemName : str2, (i4 & 4) != 0 ? cJRSummaryFoodVoucherData2.totalChargedPrice : str3, (i4 & 8) != 0 ? cJRSummaryFoodVoucherData2.unitPrice : str4, (i4 & 16) != 0 ? cJRSummaryFoodVoucherData2.quantity : i2, (i4 & 32) != 0 ? cJRSummaryFoodVoucherData2.itemImageUrl : str5, (i4 & 64) != 0 ? cJRSummaryFoodVoucherData2.termConditionRedeemProcess : str6, (i4 & 128) != 0 ? cJRSummaryFoodVoucherData2.expiry : str7);
    }

    public final String component1() {
        return this.itemDescription;
    }

    public final String component2() {
        return this.itemName;
    }

    public final String component3() {
        return this.totalChargedPrice;
    }

    public final String component4() {
        return this.unitPrice;
    }

    public final int component5() {
        return this.quantity;
    }

    public final String component6() {
        return this.itemImageUrl;
    }

    public final String component7() {
        return this.termConditionRedeemProcess;
    }

    public final String component8() {
        return this.expiry;
    }

    public final CJRSummaryFoodVoucherData copy(String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7) {
        return new CJRSummaryFoodVoucherData(str, str2, str3, str4, i2, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRSummaryFoodVoucherData)) {
            return false;
        }
        CJRSummaryFoodVoucherData cJRSummaryFoodVoucherData = (CJRSummaryFoodVoucherData) obj;
        return k.a((Object) this.itemDescription, (Object) cJRSummaryFoodVoucherData.itemDescription) && k.a((Object) this.itemName, (Object) cJRSummaryFoodVoucherData.itemName) && k.a((Object) this.totalChargedPrice, (Object) cJRSummaryFoodVoucherData.totalChargedPrice) && k.a((Object) this.unitPrice, (Object) cJRSummaryFoodVoucherData.unitPrice) && this.quantity == cJRSummaryFoodVoucherData.quantity && k.a((Object) this.itemImageUrl, (Object) cJRSummaryFoodVoucherData.itemImageUrl) && k.a((Object) this.termConditionRedeemProcess, (Object) cJRSummaryFoodVoucherData.termConditionRedeemProcess) && k.a((Object) this.expiry, (Object) cJRSummaryFoodVoucherData.expiry);
    }

    public final int hashCode() {
        String str = this.itemDescription;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.itemName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.totalChargedPrice;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.unitPrice;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + Integer.valueOf(this.quantity).hashCode()) * 31;
        String str5 = this.itemImageUrl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.termConditionRedeemProcess;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.expiry;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "CJRSummaryFoodVoucherData(itemDescription=" + this.itemDescription + ", itemName=" + this.itemName + ", totalChargedPrice=" + this.totalChargedPrice + ", unitPrice=" + this.unitPrice + ", quantity=" + this.quantity + ", itemImageUrl=" + this.itemImageUrl + ", termConditionRedeemProcess=" + this.termConditionRedeemProcess + ", expiry=" + this.expiry + ")";
    }

    public CJRSummaryFoodVoucherData(String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7) {
        this.itemDescription = str;
        this.itemName = str2;
        this.totalChargedPrice = str3;
        this.unitPrice = str4;
        this.quantity = i2;
        this.itemImageUrl = str5;
        this.termConditionRedeemProcess = str6;
        this.expiry = str7;
    }

    public final String getItemDescription() {
        return this.itemDescription;
    }

    public final void setItemDescription(String str) {
        this.itemDescription = str;
    }

    public final String getItemName() {
        return this.itemName;
    }

    public final void setItemName(String str) {
        this.itemName = str;
    }

    public final String getTotalChargedPrice() {
        return this.totalChargedPrice;
    }

    public final void setTotalChargedPrice(String str) {
        this.totalChargedPrice = str;
    }

    public final String getUnitPrice() {
        return this.unitPrice;
    }

    public final void setUnitPrice(String str) {
        this.unitPrice = str;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final void setQuantity(int i2) {
        this.quantity = i2;
    }

    public final String getItemImageUrl() {
        return this.itemImageUrl;
    }

    public final void setItemImageUrl(String str) {
        this.itemImageUrl = str;
    }

    public final String getTermConditionRedeemProcess() {
        return this.termConditionRedeemProcess;
    }

    public final void setTermConditionRedeemProcess(String str) {
        this.termConditionRedeemProcess = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRSummaryFoodVoucherData(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.g.b.g r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = 0
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRSummaryFoodVoucherData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getExpiry() {
        return this.expiry;
    }

    public final void setExpiry(String str) {
        this.expiry = str;
    }
}
