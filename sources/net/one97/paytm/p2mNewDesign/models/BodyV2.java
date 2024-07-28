package net.one97.paytm.p2mNewDesign.models;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class BodyV2 extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "activeMerchant")
    private boolean activeMerchant;
    @b(a = "addDescriptionMandatory")
    private final boolean addDescriptionMandatory;
    @b(a = "addMoneyMerchantDetails")
    private MerchantDetailsV2 addMoneyMerchantDetails;
    @b(a = "consultDetails")
    private Object consultDetails;
    @b(a = "consultFeeResponse")
    private final String consultFeeResponse;
    @b(a = "descriptionTextFormat")
    private final String descriptionTextFormat;
    @b(a = "displayMessage")
    private final String displayMessage;
    @b(a = "extraParamsMap")
    private final String extraParamsMap;
    @b(a = "iconBaseUrl")
    private final String iconBaseUrl;
    @b(a = "infoButtonUpdateMessage")
    private final String infoButtonUpdateMessage;
    @b(a = "merchantDetails")
    private MerchantDetailsV2 merchantDetails;
    @b(a = "merchantLimitInfo")
    private final MerchantLimitInfoV2 merchantLimitInfo;
    @b(a = "merchantOfferMessage")
    private final String merchantOfferMessage;
    @b(a = "merchantPayOption")
    private MerchantPayOptionV2 merchantPayOption;
    @b(a = "nativeJsonRequestSupported")
    private boolean nativeJsonRequestSupported;
    @b(a = "onTheFlyKYCRequired")
    private String onTheFlyKYCRequired;
    @b(a = "oneClickMaxAmount")
    private String oneClickMaxAmount;
    @b(a = "orderId")
    private String orderId;
    @b(a = "paymentFlow")
    private String paymentFlow;
    @b(a = "pcfEnabled")
    private boolean pcfEnabled;
    @b(a = "promoCodeData")
    private final NativePromoCodeDataV2 promoCodeData;
    @b(a = "resultInfo")
    private ResultInfoV2 resultInfo;
    @b(a = "walletOnly")
    private String walletOnly;
    @b(a = "zeroCostEmi")
    private String zeroCostEmi;

    public BodyV2() {
        this((String) null, (String) null, (String) null, false, (NativePromoCodeDataV2) null, false, (String) null, (MerchantDetailsV2) null, (String) null, (ResultInfoV2) null, (String) null, (MerchantPayOptionV2) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, (MerchantDetailsV2) null, (MerchantLimitInfoV2) null, false, (String) null, (Object) null, 16777215, (g) null);
    }

    public static /* synthetic */ BodyV2 copy$default(BodyV2 bodyV2, String str, String str2, String str3, boolean z, NativePromoCodeDataV2 nativePromoCodeDataV2, boolean z2, String str4, MerchantDetailsV2 merchantDetailsV2, String str5, ResultInfoV2 resultInfoV2, String str6, MerchantPayOptionV2 merchantPayOptionV2, String str7, boolean z3, String str8, String str9, String str10, String str11, String str12, MerchantDetailsV2 merchantDetailsV22, MerchantLimitInfoV2 merchantLimitInfoV2, boolean z4, String str13, Object obj, int i2, Object obj2) {
        BodyV2 bodyV22 = bodyV2;
        int i3 = i2;
        return bodyV2.copy((i3 & 1) != 0 ? bodyV22.zeroCostEmi : str, (i3 & 2) != 0 ? bodyV22.merchantOfferMessage : str2, (i3 & 4) != 0 ? bodyV22.orderId : str3, (i3 & 8) != 0 ? bodyV22.nativeJsonRequestSupported : z, (i3 & 16) != 0 ? bodyV22.promoCodeData : nativePromoCodeDataV2, (i3 & 32) != 0 ? bodyV22.activeMerchant : z2, (i3 & 64) != 0 ? bodyV22.extraParamsMap : str4, (i3 & 128) != 0 ? bodyV22.merchantDetails : merchantDetailsV2, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? bodyV22.onTheFlyKYCRequired : str5, (i3 & 512) != 0 ? bodyV22.resultInfo : resultInfoV2, (i3 & TarConstants.EOF_BLOCK) != 0 ? bodyV22.displayMessage : str6, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? bodyV22.merchantPayOption : merchantPayOptionV2, (i3 & 4096) != 0 ? bodyV22.walletOnly : str7, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? bodyV22.pcfEnabled : z3, (i3 & 16384) != 0 ? bodyV22.oneClickMaxAmount : str8, (i3 & 32768) != 0 ? bodyV22.infoButtonUpdateMessage : str9, (i3 & 65536) != 0 ? bodyV22.consultFeeResponse : str10, (i3 & 131072) != 0 ? bodyV22.paymentFlow : str11, (i3 & 262144) != 0 ? bodyV22.iconBaseUrl : str12, (i3 & 524288) != 0 ? bodyV22.addMoneyMerchantDetails : merchantDetailsV22, (i3 & 1048576) != 0 ? bodyV22.merchantLimitInfo : merchantLimitInfoV2, (i3 & 2097152) != 0 ? bodyV22.addDescriptionMandatory : z4, (i3 & 4194304) != 0 ? bodyV22.descriptionTextFormat : str13, (i3 & 8388608) != 0 ? bodyV22.consultDetails : obj);
    }

    public final String component1() {
        return this.zeroCostEmi;
    }

    public final ResultInfoV2 component10() {
        return this.resultInfo;
    }

    public final String component11() {
        return this.displayMessage;
    }

    public final MerchantPayOptionV2 component12() {
        return this.merchantPayOption;
    }

    public final String component13() {
        return this.walletOnly;
    }

    public final boolean component14() {
        return this.pcfEnabled;
    }

    public final String component15() {
        return this.oneClickMaxAmount;
    }

    public final String component16() {
        return this.infoButtonUpdateMessage;
    }

    public final String component17() {
        return this.consultFeeResponse;
    }

    public final String component18() {
        return this.paymentFlow;
    }

    public final String component19() {
        return this.iconBaseUrl;
    }

    public final String component2() {
        return this.merchantOfferMessage;
    }

    public final MerchantDetailsV2 component20() {
        return this.addMoneyMerchantDetails;
    }

    public final MerchantLimitInfoV2 component21() {
        return this.merchantLimitInfo;
    }

    public final boolean component22() {
        return this.addDescriptionMandatory;
    }

    public final String component23() {
        return this.descriptionTextFormat;
    }

    public final Object component24() {
        return this.consultDetails;
    }

    public final String component3() {
        return this.orderId;
    }

    public final boolean component4() {
        return this.nativeJsonRequestSupported;
    }

    public final NativePromoCodeDataV2 component5() {
        return this.promoCodeData;
    }

    public final boolean component6() {
        return this.activeMerchant;
    }

    public final String component7() {
        return this.extraParamsMap;
    }

    public final MerchantDetailsV2 component8() {
        return this.merchantDetails;
    }

    public final String component9() {
        return this.onTheFlyKYCRequired;
    }

    public final BodyV2 copy(String str, String str2, String str3, boolean z, NativePromoCodeDataV2 nativePromoCodeDataV2, boolean z2, String str4, MerchantDetailsV2 merchantDetailsV2, String str5, ResultInfoV2 resultInfoV2, String str6, MerchantPayOptionV2 merchantPayOptionV2, String str7, boolean z3, String str8, String str9, String str10, String str11, String str12, MerchantDetailsV2 merchantDetailsV22, MerchantLimitInfoV2 merchantLimitInfoV2, boolean z4, String str13, Object obj) {
        return new BodyV2(str, str2, str3, z, nativePromoCodeDataV2, z2, str4, merchantDetailsV2, str5, resultInfoV2, str6, merchantPayOptionV2, str7, z3, str8, str9, str10, str11, str12, merchantDetailsV22, merchantLimitInfoV2, z4, str13, obj);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BodyV2) {
                BodyV2 bodyV2 = (BodyV2) obj;
                if (k.a((Object) this.zeroCostEmi, (Object) bodyV2.zeroCostEmi) && k.a((Object) this.merchantOfferMessage, (Object) bodyV2.merchantOfferMessage) && k.a((Object) this.orderId, (Object) bodyV2.orderId)) {
                    if ((this.nativeJsonRequestSupported == bodyV2.nativeJsonRequestSupported) && k.a((Object) this.promoCodeData, (Object) bodyV2.promoCodeData)) {
                        if ((this.activeMerchant == bodyV2.activeMerchant) && k.a((Object) this.extraParamsMap, (Object) bodyV2.extraParamsMap) && k.a((Object) this.merchantDetails, (Object) bodyV2.merchantDetails) && k.a((Object) this.onTheFlyKYCRequired, (Object) bodyV2.onTheFlyKYCRequired) && k.a((Object) this.resultInfo, (Object) bodyV2.resultInfo) && k.a((Object) this.displayMessage, (Object) bodyV2.displayMessage) && k.a((Object) this.merchantPayOption, (Object) bodyV2.merchantPayOption) && k.a((Object) this.walletOnly, (Object) bodyV2.walletOnly)) {
                            if ((this.pcfEnabled == bodyV2.pcfEnabled) && k.a((Object) this.oneClickMaxAmount, (Object) bodyV2.oneClickMaxAmount) && k.a((Object) this.infoButtonUpdateMessage, (Object) bodyV2.infoButtonUpdateMessage) && k.a((Object) this.consultFeeResponse, (Object) bodyV2.consultFeeResponse) && k.a((Object) this.paymentFlow, (Object) bodyV2.paymentFlow) && k.a((Object) this.iconBaseUrl, (Object) bodyV2.iconBaseUrl) && k.a((Object) this.addMoneyMerchantDetails, (Object) bodyV2.addMoneyMerchantDetails) && k.a((Object) this.merchantLimitInfo, (Object) bodyV2.merchantLimitInfo)) {
                                if (!(this.addDescriptionMandatory == bodyV2.addDescriptionMandatory) || !k.a((Object) this.descriptionTextFormat, (Object) bodyV2.descriptionTextFormat) || !k.a(this.consultDetails, bodyV2.consultDetails)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.zeroCostEmi;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merchantOfferMessage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.orderId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.nativeJsonRequestSupported;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        NativePromoCodeDataV2 nativePromoCodeDataV2 = this.promoCodeData;
        int hashCode4 = (i3 + (nativePromoCodeDataV2 != null ? nativePromoCodeDataV2.hashCode() : 0)) * 31;
        boolean z2 = this.activeMerchant;
        if (z2) {
            z2 = true;
        }
        int i4 = (hashCode4 + (z2 ? 1 : 0)) * 31;
        String str4 = this.extraParamsMap;
        int hashCode5 = (i4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        MerchantDetailsV2 merchantDetailsV2 = this.merchantDetails;
        int hashCode6 = (hashCode5 + (merchantDetailsV2 != null ? merchantDetailsV2.hashCode() : 0)) * 31;
        String str5 = this.onTheFlyKYCRequired;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        ResultInfoV2 resultInfoV2 = this.resultInfo;
        int hashCode8 = (hashCode7 + (resultInfoV2 != null ? resultInfoV2.hashCode() : 0)) * 31;
        String str6 = this.displayMessage;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        MerchantPayOptionV2 merchantPayOptionV2 = this.merchantPayOption;
        int hashCode10 = (hashCode9 + (merchantPayOptionV2 != null ? merchantPayOptionV2.hashCode() : 0)) * 31;
        String str7 = this.walletOnly;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z3 = this.pcfEnabled;
        if (z3) {
            z3 = true;
        }
        int i5 = (hashCode11 + (z3 ? 1 : 0)) * 31;
        String str8 = this.oneClickMaxAmount;
        int hashCode12 = (i5 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.infoButtonUpdateMessage;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.consultFeeResponse;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.paymentFlow;
        int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.iconBaseUrl;
        int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 31;
        MerchantDetailsV2 merchantDetailsV22 = this.addMoneyMerchantDetails;
        int hashCode17 = (hashCode16 + (merchantDetailsV22 != null ? merchantDetailsV22.hashCode() : 0)) * 31;
        MerchantLimitInfoV2 merchantLimitInfoV2 = this.merchantLimitInfo;
        int hashCode18 = (hashCode17 + (merchantLimitInfoV2 != null ? merchantLimitInfoV2.hashCode() : 0)) * 31;
        boolean z4 = this.addDescriptionMandatory;
        if (z4) {
            z4 = true;
        }
        int i6 = (hashCode18 + (z4 ? 1 : 0)) * 31;
        String str13 = this.descriptionTextFormat;
        int hashCode19 = (i6 + (str13 != null ? str13.hashCode() : 0)) * 31;
        Object obj = this.consultDetails;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return hashCode19 + i2;
    }

    public final String toString() {
        return "BodyV2(zeroCostEmi=" + this.zeroCostEmi + ", merchantOfferMessage=" + this.merchantOfferMessage + ", orderId=" + this.orderId + ", nativeJsonRequestSupported=" + this.nativeJsonRequestSupported + ", promoCodeData=" + this.promoCodeData + ", activeMerchant=" + this.activeMerchant + ", extraParamsMap=" + this.extraParamsMap + ", merchantDetails=" + this.merchantDetails + ", onTheFlyKYCRequired=" + this.onTheFlyKYCRequired + ", resultInfo=" + this.resultInfo + ", displayMessage=" + this.displayMessage + ", merchantPayOption=" + this.merchantPayOption + ", walletOnly=" + this.walletOnly + ", pcfEnabled=" + this.pcfEnabled + ", oneClickMaxAmount=" + this.oneClickMaxAmount + ", infoButtonUpdateMessage=" + this.infoButtonUpdateMessage + ", consultFeeResponse=" + this.consultFeeResponse + ", paymentFlow=" + this.paymentFlow + ", iconBaseUrl=" + this.iconBaseUrl + ", addMoneyMerchantDetails=" + this.addMoneyMerchantDetails + ", merchantLimitInfo=" + this.merchantLimitInfo + ", addDescriptionMandatory=" + this.addDescriptionMandatory + ", descriptionTextFormat=" + this.descriptionTextFormat + ", consultDetails=" + this.consultDetails + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getZeroCostEmi() {
        return this.zeroCostEmi;
    }

    public final void setZeroCostEmi(String str) {
        this.zeroCostEmi = str;
    }

    public final String getMerchantOfferMessage() {
        return this.merchantOfferMessage;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final boolean getNativeJsonRequestSupported() {
        return this.nativeJsonRequestSupported;
    }

    public final void setNativeJsonRequestSupported(boolean z) {
        this.nativeJsonRequestSupported = z;
    }

    public final NativePromoCodeDataV2 getPromoCodeData() {
        return this.promoCodeData;
    }

    public final boolean getActiveMerchant() {
        return this.activeMerchant;
    }

    public final void setActiveMerchant(boolean z) {
        this.activeMerchant = z;
    }

    public final String getExtraParamsMap() {
        return this.extraParamsMap;
    }

    public final MerchantDetailsV2 getMerchantDetails() {
        return this.merchantDetails;
    }

    public final void setMerchantDetails(MerchantDetailsV2 merchantDetailsV2) {
        this.merchantDetails = merchantDetailsV2;
    }

    public final String getOnTheFlyKYCRequired() {
        return this.onTheFlyKYCRequired;
    }

    public final void setOnTheFlyKYCRequired(String str) {
        this.onTheFlyKYCRequired = str;
    }

    public final ResultInfoV2 getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(ResultInfoV2 resultInfoV2) {
        this.resultInfo = resultInfoV2;
    }

    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    public final MerchantPayOptionV2 getMerchantPayOption() {
        return this.merchantPayOption;
    }

    public final void setMerchantPayOption(MerchantPayOptionV2 merchantPayOptionV2) {
        this.merchantPayOption = merchantPayOptionV2;
    }

    public final String getWalletOnly() {
        return this.walletOnly;
    }

    public final void setWalletOnly(String str) {
        this.walletOnly = str;
    }

    public final boolean getPcfEnabled() {
        return this.pcfEnabled;
    }

    public final void setPcfEnabled(boolean z) {
        this.pcfEnabled = z;
    }

    public final String getOneClickMaxAmount() {
        return this.oneClickMaxAmount;
    }

    public final void setOneClickMaxAmount(String str) {
        this.oneClickMaxAmount = str;
    }

    public final String getInfoButtonUpdateMessage() {
        return this.infoButtonUpdateMessage;
    }

    public final String getConsultFeeResponse() {
        return this.consultFeeResponse;
    }

    public final String getIconBaseUrl() {
        return this.iconBaseUrl;
    }

    public final String getPaymentFlow() {
        return this.paymentFlow;
    }

    public final void setPaymentFlow(String str) {
        this.paymentFlow = str;
    }

    public BodyV2(String str, String str2, String str3, boolean z, NativePromoCodeDataV2 nativePromoCodeDataV2, boolean z2, String str4, MerchantDetailsV2 merchantDetailsV2, String str5, ResultInfoV2 resultInfoV2, String str6, MerchantPayOptionV2 merchantPayOptionV2, String str7, boolean z3, String str8, String str9, String str10, String str11, String str12, MerchantDetailsV2 merchantDetailsV22, MerchantLimitInfoV2 merchantLimitInfoV2, boolean z4, String str13, Object obj) {
        this.zeroCostEmi = str;
        this.merchantOfferMessage = str2;
        this.orderId = str3;
        this.nativeJsonRequestSupported = z;
        this.promoCodeData = nativePromoCodeDataV2;
        this.activeMerchant = z2;
        this.extraParamsMap = str4;
        this.merchantDetails = merchantDetailsV2;
        this.onTheFlyKYCRequired = str5;
        this.resultInfo = resultInfoV2;
        this.displayMessage = str6;
        this.merchantPayOption = merchantPayOptionV2;
        this.walletOnly = str7;
        this.pcfEnabled = z3;
        this.oneClickMaxAmount = str8;
        this.infoButtonUpdateMessage = str9;
        this.consultFeeResponse = str10;
        this.paymentFlow = str11;
        this.iconBaseUrl = str12;
        this.addMoneyMerchantDetails = merchantDetailsV22;
        this.merchantLimitInfo = merchantLimitInfoV2;
        this.addDescriptionMandatory = z4;
        this.descriptionTextFormat = str13;
        this.consultDetails = obj;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BodyV2(java.lang.String r26, java.lang.String r27, java.lang.String r28, boolean r29, net.one97.paytm.p2mNewDesign.models.NativePromoCodeDataV2 r30, boolean r31, java.lang.String r32, net.one97.paytm.p2mNewDesign.models.MerchantDetailsV2 r33, java.lang.String r34, net.one97.paytm.p2mNewDesign.models.ResultInfoV2 r35, java.lang.String r36, net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r37, java.lang.String r38, boolean r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, net.one97.paytm.p2mNewDesign.models.MerchantDetailsV2 r45, net.one97.paytm.p2mNewDesign.models.MerchantLimitInfoV2 r46, boolean r47, java.lang.String r48, java.lang.Object r49, int r50, kotlin.g.b.g r51) {
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
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            r7 = 0
            goto L_0x002a
        L_0x0028:
            r7 = r30
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            r8 = 0
            goto L_0x0032
        L_0x0030:
            r8 = r31
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            r9 = 0
            goto L_0x003a
        L_0x0038:
            r9 = r32
        L_0x003a:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            r10 = 0
            goto L_0x0042
        L_0x0040:
            r10 = r33
        L_0x0042:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0048
            r11 = 0
            goto L_0x004a
        L_0x0048:
            r11 = r34
        L_0x004a:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0050
            r12 = 0
            goto L_0x0052
        L_0x0050:
            r12 = r35
        L_0x0052:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            r13 = 0
            goto L_0x005a
        L_0x0058:
            r13 = r36
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0060
            r14 = 0
            goto L_0x0062
        L_0x0060:
            r14 = r37
        L_0x0062:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0068
            r15 = 0
            goto L_0x006a
        L_0x0068:
            r15 = r38
        L_0x006a:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0072
        L_0x0070:
            r2 = r39
        L_0x0072:
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0078
            r6 = 0
            goto L_0x007a
        L_0x0078:
            r6 = r40
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
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r10
            r35 = r11
            r36 = r12
            r37 = r13
            r38 = r14
            r39 = r15
            r40 = r2
            r41 = r6
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.BodyV2.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, net.one97.paytm.p2mNewDesign.models.NativePromoCodeDataV2, boolean, java.lang.String, net.one97.paytm.p2mNewDesign.models.MerchantDetailsV2, java.lang.String, net.one97.paytm.p2mNewDesign.models.ResultInfoV2, java.lang.String, net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.models.MerchantDetailsV2, net.one97.paytm.p2mNewDesign.models.MerchantLimitInfoV2, boolean, java.lang.String, java.lang.Object, int, kotlin.g.b.g):void");
    }

    public final boolean getAddDescriptionMandatory() {
        return this.addDescriptionMandatory;
    }

    public final MerchantDetailsV2 getAddMoneyMerchantDetails() {
        return this.addMoneyMerchantDetails;
    }

    public final Object getConsultDetails() {
        return this.consultDetails;
    }

    public final String getDescriptionTextFormat() {
        return this.descriptionTextFormat;
    }

    public final MerchantLimitInfoV2 getMerchantLimitInfo() {
        return this.merchantLimitInfo;
    }

    public final void setAddMoneyMerchantDetails(MerchantDetailsV2 merchantDetailsV2) {
        this.addMoneyMerchantDetails = merchantDetailsV2;
    }

    public final void setConsultDetails(Object obj) {
        this.consultDetails = obj;
    }
}
