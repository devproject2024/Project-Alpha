package net.one97.paytm.recharge.model.v4;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.m.p;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRAggsItem implements IJRDataModel {
    @b(a = "aggKey")
    private final String aggKey;
    @b(a = "aggs")
    private final List<CJRAggsItem> aggs;
    @b(a = "bank_code")
    private String bankCode;
    @b(a = "bbpsLogoUrl")
    private String bbpsLogoUrl;
    @b(a = "bgImageUrl")
    private final String bgImageUrl;
    @b(a = "custom_int_4")
    private final String customInt4;
    @b(a = "displayValue")
    private String displayValue;
    @b(a = "gas_agency_address")
    private final String gasAgencyAddress;
    @b(a = "gas_agency_name")
    private final String gasAgencyName;
    @b(a = "image")
    private final String image;
    @b(a = "imageUrl")
    private final String imageUrl;
    @b(a = "isDefaultSelected")
    private final String isDefaultSelected;
    @b(a = "is_paytm_first_card")
    private String isPaytmFirst;
    private final String label;
    @b(a = "min_android_version")
    private final String minAndroidVersion;
    private final String operator;
    @b(a = "operator_alert")
    private final String operatorAlert;
    @b(a = "operator_desc")
    private final String operatorDesc;
    @b(a = "productList")
    private final List<CJRProductsItem> productList;
    @b(a = "regEx")
    private final String regEx;
    @b(a = "sample_bill")
    private final String sampleBill;
    private String schedulable;
    private boolean shouldExpand;
    private String tempDisplayValue;
    private String tempFileterValue;
    private boolean tempItemSelected;
    @b(a = "value")
    private final String value;
    private String viewType;

    public CJRAggsItem() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, 16777215, (g) null);
    }

    public static /* synthetic */ CJRAggsItem copy$default(CJRAggsItem cJRAggsItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, List list, String str17, String str18, List list2, String str19, String str20, String str21, String str22, int i2, Object obj) {
        CJRAggsItem cJRAggsItem2 = cJRAggsItem;
        int i3 = i2;
        return cJRAggsItem.copy((i3 & 1) != 0 ? cJRAggsItem2.bbpsLogoUrl : str, (i3 & 2) != 0 ? cJRAggsItem2.imageUrl : str2, (i3 & 4) != 0 ? cJRAggsItem2.image : str3, (i3 & 8) != 0 ? cJRAggsItem2.value : str4, (i3 & 16) != 0 ? cJRAggsItem2.displayValue : str5, (i3 & 32) != 0 ? cJRAggsItem2.bankCode : str6, (i3 & 64) != 0 ? cJRAggsItem2.isPaytmFirst : str7, (i3 & 128) != 0 ? cJRAggsItem2.label : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRAggsItem2.operator : str9, (i3 & 512) != 0 ? cJRAggsItem2.operatorDesc : str10, (i3 & TarConstants.EOF_BLOCK) != 0 ? cJRAggsItem2.operatorAlert : str11, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? cJRAggsItem2.sampleBill : str12, (i3 & 4096) != 0 ? cJRAggsItem2.customInt4 : str13, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? cJRAggsItem2.gasAgencyName : str14, (i3 & 16384) != 0 ? cJRAggsItem2.gasAgencyAddress : str15, (i3 & 32768) != 0 ? cJRAggsItem2.aggKey : str16, (i3 & 65536) != 0 ? cJRAggsItem2.aggs : list, (i3 & 131072) != 0 ? cJRAggsItem2.schedulable : str17, (i3 & 262144) != 0 ? cJRAggsItem2.minAndroidVersion : str18, (i3 & 524288) != 0 ? cJRAggsItem2.productList : list2, (i3 & 1048576) != 0 ? cJRAggsItem2.regEx : str19, (i3 & 2097152) != 0 ? cJRAggsItem2.bgImageUrl : str20, (i3 & 4194304) != 0 ? cJRAggsItem2.isDefaultSelected : str21, (i3 & 8388608) != 0 ? cJRAggsItem2.viewType : str22);
    }

    public final String component1() {
        return this.bbpsLogoUrl;
    }

    public final String component10() {
        return this.operatorDesc;
    }

    public final String component11() {
        return this.operatorAlert;
    }

    public final String component12() {
        return this.sampleBill;
    }

    public final String component13() {
        return this.customInt4;
    }

    public final String component14() {
        return this.gasAgencyName;
    }

    public final String component15() {
        return this.gasAgencyAddress;
    }

    public final String component16() {
        return this.aggKey;
    }

    public final List<CJRAggsItem> component17() {
        return this.aggs;
    }

    public final String component18() {
        return this.schedulable;
    }

    public final String component19() {
        return this.minAndroidVersion;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final List<CJRProductsItem> component20() {
        return this.productList;
    }

    public final String component21() {
        return this.regEx;
    }

    public final String component22() {
        return this.bgImageUrl;
    }

    public final String component23() {
        return this.isDefaultSelected;
    }

    public final String component24() {
        return this.viewType;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.value;
    }

    public final String component5() {
        return this.displayValue;
    }

    public final String component6() {
        return this.bankCode;
    }

    public final String component7() {
        return this.isPaytmFirst;
    }

    public final String component8() {
        return this.label;
    }

    public final String component9() {
        return this.operator;
    }

    public final CJRAggsItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, List<CJRAggsItem> list, String str17, String str18, List<CJRProductsItem> list2, String str19, String str20, String str21, String str22) {
        return new CJRAggsItem(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, list, str17, str18, list2, str19, str20, str21, str22);
    }

    public final String toString() {
        return "CJRAggsItem(bbpsLogoUrl=" + this.bbpsLogoUrl + ", imageUrl=" + this.imageUrl + ", image=" + this.image + ", value=" + this.value + ", displayValue=" + this.displayValue + ", bankCode=" + this.bankCode + ", isPaytmFirst=" + this.isPaytmFirst + ", label=" + this.label + ", operator=" + this.operator + ", operatorDesc=" + this.operatorDesc + ", operatorAlert=" + this.operatorAlert + ", sampleBill=" + this.sampleBill + ", customInt4=" + this.customInt4 + ", gasAgencyName=" + this.gasAgencyName + ", gasAgencyAddress=" + this.gasAgencyAddress + ", aggKey=" + this.aggKey + ", aggs=" + this.aggs + ", schedulable=" + this.schedulable + ", minAndroidVersion=" + this.minAndroidVersion + ", productList=" + this.productList + ", regEx=" + this.regEx + ", bgImageUrl=" + this.bgImageUrl + ", isDefaultSelected=" + this.isDefaultSelected + ", viewType=" + this.viewType + ")";
    }

    public CJRAggsItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, List<CJRAggsItem> list, String str17, String str18, List<CJRProductsItem> list2, String str19, String str20, String str21, String str22) {
        this.bbpsLogoUrl = str;
        this.imageUrl = str2;
        this.image = str3;
        this.value = str4;
        this.displayValue = str5;
        this.bankCode = str6;
        this.isPaytmFirst = str7;
        this.label = str8;
        this.operator = str9;
        this.operatorDesc = str10;
        this.operatorAlert = str11;
        this.sampleBill = str12;
        this.customInt4 = str13;
        this.gasAgencyName = str14;
        this.gasAgencyAddress = str15;
        this.aggKey = str16;
        this.aggs = list;
        this.schedulable = str17;
        this.minAndroidVersion = str18;
        this.productList = list2;
        this.regEx = str19;
        this.bgImageUrl = str20;
        this.isDefaultSelected = str21;
        this.viewType = str22;
    }

    public final String getBbpsLogoUrl() {
        return this.bbpsLogoUrl;
    }

    public final void setBbpsLogoUrl(String str) {
        this.bbpsLogoUrl = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getDisplayValue() {
        return this.displayValue;
    }

    public final void setDisplayValue(String str) {
        this.displayValue = str;
    }

    public final String getBankCode() {
        return this.bankCode;
    }

    public final void setBankCode(String str) {
        this.bankCode = str;
    }

    public final String isPaytmFirst() {
        return this.isPaytmFirst;
    }

    public final void setPaytmFirst(String str) {
        this.isPaytmFirst = str;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final String getOperatorDesc() {
        return this.operatorDesc;
    }

    public final String getOperatorAlert() {
        return this.operatorAlert;
    }

    public final String getSampleBill() {
        return this.sampleBill;
    }

    public final String getCustomInt4() {
        return this.customInt4;
    }

    public final String getGasAgencyName() {
        return this.gasAgencyName;
    }

    public final String getGasAgencyAddress() {
        return this.gasAgencyAddress;
    }

    public final String getAggKey() {
        return this.aggKey;
    }

    public final List<CJRAggsItem> getAggs() {
        return this.aggs;
    }

    public final String getSchedulable() {
        return this.schedulable;
    }

    public final void setSchedulable(String str) {
        this.schedulable = str;
    }

    public final String getMinAndroidVersion() {
        return this.minAndroidVersion;
    }

    public final List<CJRProductsItem> getProductList() {
        return this.productList;
    }

    public final String getRegEx() {
        return this.regEx;
    }

    public final String getBgImageUrl() {
        return this.bgImageUrl;
    }

    public final String isDefaultSelected() {
        return this.isDefaultSelected;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRAggsItem(java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.util.List r42, java.lang.String r43, java.lang.String r44, java.util.List r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, int r50, kotlin.g.b.g r51) {
        /*
            r25 = this;
            r0 = r50
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r26
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r27
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r28
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r29
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r30
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r31
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r32
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r33
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r34
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r35
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r36
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r37
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r38
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r39
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r40
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r41
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r42
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r43
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r44
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r45
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r46
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r47
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r48
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r24
            if (r0 == 0) goto L_0x00db
            r0 = 0
            goto L_0x00dd
        L_0x00db:
            r0 = r49
        L_0x00dd:
            r26 = r25
            r27 = r1
            r28 = r3
            r29 = r4
            r30 = r5
            r31 = r6
            r32 = r7
            r33 = r8
            r34 = r9
            r35 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r39 = r14
            r40 = r15
            r41 = r2
            r42 = r16
            r43 = r17
            r44 = r18
            r45 = r19
            r46 = r20
            r47 = r21
            r48 = r22
            r49 = r23
            r50 = r0
            r26.<init>(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRAggsItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getViewType() {
        return this.viewType;
    }

    public final void setViewType(String str) {
        this.viewType = str;
    }

    public final boolean getShouldExpand() {
        return this.shouldExpand;
    }

    public final void setShouldExpand(boolean z) {
        this.shouldExpand = z;
    }

    public final String getTempDisplayValue() {
        return this.tempDisplayValue;
    }

    public final void setTempDisplayValue(String str) {
        this.tempDisplayValue = str;
    }

    public final String getTempFileterValue() {
        return this.tempFileterValue;
    }

    public final void setTempFileterValue(String str) {
        this.tempFileterValue = str;
    }

    public final boolean getTempItemSelected() {
        return this.tempItemSelected;
    }

    public final void setTempItemSelected(boolean z) {
        this.tempItemSelected = z;
    }

    public final boolean isItemShouldBeSelectedByDefault() {
        return p.a("true", this.isDefaultSelected, true);
    }

    public final void setItemSelected(boolean z) {
        this.tempItemSelected = z;
    }

    public final boolean isItemSelected() {
        return this.tempItemSelected;
    }

    /* renamed from: isPaytmFirst  reason: collision with other method in class */
    public final boolean m763isPaytmFirst() {
        return p.a("1", this.isPaytmFirst, true);
    }

    public final boolean isSchedulable() {
        return p.a("1", this.schedulable, true);
    }

    public static final class Builder {
        private List<CJRAggsItem> aggs;
        private String displayValue;
        private String value;

        public final Builder setValue(String str) {
            this.value = str;
            return this;
        }

        public final Builder setDisplayValue(String str) {
            this.displayValue = str;
            return this;
        }

        public final Builder setAggsItem(List<CJRAggsItem> list) {
            this.aggs = list;
            return this;
        }

        public final CJRAggsItem build() {
            return new CJRAggsItem((String) null, (String) null, (String) null, this.value, this.displayValue, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, this.aggs, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, 16711655, (g) null);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CJRAggsItem)) {
            return false;
        }
        return p.a(this.value, ((CJRAggsItem) obj).value, true);
    }

    public final int hashCode() {
        String str = this.bbpsLogoUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.imageUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.image;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.value;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.displayValue;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.bankCode;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.label;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.operator;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.operatorDesc;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.operatorAlert;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.sampleBill;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.customInt4;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.gasAgencyName;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.gasAgencyAddress;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.aggKey;
        int hashCode15 = (hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        List<CJRAggsItem> list = this.aggs;
        int hashCode16 = (hashCode15 + (list != null ? list.hashCode() : 0)) * 31;
        String str16 = this.schedulable;
        int hashCode17 = (hashCode16 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.minAndroidVersion;
        int hashCode18 = (hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31;
        List<CJRProductsItem> list2 = this.productList;
        int hashCode19 = (hashCode18 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str18 = this.regEx;
        int hashCode20 = (hashCode19 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.bgImageUrl;
        int hashCode21 = (hashCode20 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.isDefaultSelected;
        int hashCode22 = (hashCode21 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.viewType;
        int hashCode23 = (((hashCode22 + (str21 != null ? str21.hashCode() : 0)) * 31) + Boolean.valueOf(this.shouldExpand).hashCode()) * 31;
        String str22 = this.tempDisplayValue;
        int hashCode24 = (hashCode23 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.tempFileterValue;
        if (str23 != null) {
            i2 = str23.hashCode();
        }
        return hashCode24 + i2;
    }
}
