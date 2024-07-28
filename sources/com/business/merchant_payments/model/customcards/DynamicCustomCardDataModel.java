package com.business.merchant_payments.model.customcards;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.util.Arrays;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class DynamicCustomCardDataModel {
    public final String bodyColor;
    public final String[] bodyParams;
    public final String cardColor;
    public final int cardId;
    public final boolean closeable;
    public final String ctaColor;
    public final String[] ctaParams;
    public final boolean ctaVisible;
    public final String deeplink;
    public final String defaultBody;
    public final String defaultCta;
    public final String defaultHeader;
    public final String headerColor;
    public final String[] headerParams;
    public final String iconUrl;
    public final boolean showHeaderArrow;

    public static /* synthetic */ DynamicCustomCardDataModel copy$default(DynamicCustomCardDataModel dynamicCustomCardDataModel, int i2, String[] strArr, String[] strArr2, String[] strArr3, String str, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, boolean z3, int i3, Object obj) {
        DynamicCustomCardDataModel dynamicCustomCardDataModel2 = dynamicCustomCardDataModel;
        int i4 = i3;
        return dynamicCustomCardDataModel.copy((i4 & 1) != 0 ? dynamicCustomCardDataModel2.cardId : i2, (i4 & 2) != 0 ? dynamicCustomCardDataModel2.headerParams : strArr, (i4 & 4) != 0 ? dynamicCustomCardDataModel2.ctaParams : strArr2, (i4 & 8) != 0 ? dynamicCustomCardDataModel2.bodyParams : strArr3, (i4 & 16) != 0 ? dynamicCustomCardDataModel2.deeplink : str, (i4 & 32) != 0 ? dynamicCustomCardDataModel2.iconUrl : str2, (i4 & 64) != 0 ? dynamicCustomCardDataModel2.closeable : z, (i4 & 128) != 0 ? dynamicCustomCardDataModel2.defaultHeader : str3, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? dynamicCustomCardDataModel2.defaultBody : str4, (i4 & 512) != 0 ? dynamicCustomCardDataModel2.defaultCta : str5, (i4 & TarConstants.EOF_BLOCK) != 0 ? dynamicCustomCardDataModel2.cardColor : str6, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? dynamicCustomCardDataModel2.headerColor : str7, (i4 & 4096) != 0 ? dynamicCustomCardDataModel2.bodyColor : str8, (i4 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? dynamicCustomCardDataModel2.ctaColor : str9, (i4 & 16384) != 0 ? dynamicCustomCardDataModel2.showHeaderArrow : z2, (i4 & 32768) != 0 ? dynamicCustomCardDataModel2.ctaVisible : z3);
    }

    public final int component1() {
        return this.cardId;
    }

    public final String component10() {
        return this.defaultCta;
    }

    public final String component11() {
        return this.cardColor;
    }

    public final String component12() {
        return this.headerColor;
    }

    public final String component13() {
        return this.bodyColor;
    }

    public final String component14() {
        return this.ctaColor;
    }

    public final boolean component15() {
        return this.showHeaderArrow;
    }

    public final boolean component16() {
        return this.ctaVisible;
    }

    public final String[] component2() {
        return this.headerParams;
    }

    public final String[] component3() {
        return this.ctaParams;
    }

    public final String[] component4() {
        return this.bodyParams;
    }

    public final String component5() {
        return this.deeplink;
    }

    public final String component6() {
        return this.iconUrl;
    }

    public final boolean component7() {
        return this.closeable;
    }

    public final String component8() {
        return this.defaultHeader;
    }

    public final String component9() {
        return this.defaultBody;
    }

    public final DynamicCustomCardDataModel copy(int i2, String[] strArr, String[] strArr2, String[] strArr3, String str, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, boolean z3) {
        int i3 = i2;
        k.d(strArr, "headerParams");
        k.d(strArr2, "ctaParams");
        k.d(strArr3, "bodyParams");
        k.d(str, "deeplink");
        k.d(str2, SDKConstants.ICON_URL);
        k.d(str3, "defaultHeader");
        k.d(str4, "defaultBody");
        k.d(str5, "defaultCta");
        return new DynamicCustomCardDataModel(i2, strArr, strArr2, strArr3, str, str2, z, str3, str4, str5, str6, str7, str8, str9, z2, z3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicCustomCardDataModel)) {
            return false;
        }
        DynamicCustomCardDataModel dynamicCustomCardDataModel = (DynamicCustomCardDataModel) obj;
        return this.cardId == dynamicCustomCardDataModel.cardId && k.a((Object) this.headerParams, (Object) dynamicCustomCardDataModel.headerParams) && k.a((Object) this.ctaParams, (Object) dynamicCustomCardDataModel.ctaParams) && k.a((Object) this.bodyParams, (Object) dynamicCustomCardDataModel.bodyParams) && k.a((Object) this.deeplink, (Object) dynamicCustomCardDataModel.deeplink) && k.a((Object) this.iconUrl, (Object) dynamicCustomCardDataModel.iconUrl) && this.closeable == dynamicCustomCardDataModel.closeable && k.a((Object) this.defaultHeader, (Object) dynamicCustomCardDataModel.defaultHeader) && k.a((Object) this.defaultBody, (Object) dynamicCustomCardDataModel.defaultBody) && k.a((Object) this.defaultCta, (Object) dynamicCustomCardDataModel.defaultCta) && k.a((Object) this.cardColor, (Object) dynamicCustomCardDataModel.cardColor) && k.a((Object) this.headerColor, (Object) dynamicCustomCardDataModel.headerColor) && k.a((Object) this.bodyColor, (Object) dynamicCustomCardDataModel.bodyColor) && k.a((Object) this.ctaColor, (Object) dynamicCustomCardDataModel.ctaColor) && this.showHeaderArrow == dynamicCustomCardDataModel.showHeaderArrow && this.ctaVisible == dynamicCustomCardDataModel.ctaVisible;
    }

    public final int hashCode() {
        int i2 = this.cardId * 31;
        String[] strArr = this.headerParams;
        int i3 = 0;
        int hashCode = (i2 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.ctaParams;
        int hashCode2 = (hashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31;
        String[] strArr3 = this.bodyParams;
        int hashCode3 = (hashCode2 + (strArr3 != null ? Arrays.hashCode(strArr3) : 0)) * 31;
        String str = this.deeplink;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.iconUrl;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.closeable;
        if (z) {
            z = true;
        }
        int i4 = (hashCode5 + (z ? 1 : 0)) * 31;
        String str3 = this.defaultHeader;
        int hashCode6 = (i4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.defaultBody;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.defaultCta;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.cardColor;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.headerColor;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.bodyColor;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.ctaColor;
        if (str9 != null) {
            i3 = str9.hashCode();
        }
        int i5 = (hashCode11 + i3) * 31;
        boolean z2 = this.showHeaderArrow;
        if (z2) {
            z2 = true;
        }
        int i6 = (i5 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.ctaVisible;
        if (z3) {
            z3 = true;
        }
        return i6 + (z3 ? 1 : 0);
    }

    public final String toString() {
        return "DynamicCustomCardDataModel(cardId=" + this.cardId + ", headerParams=" + Arrays.toString(this.headerParams) + ", ctaParams=" + Arrays.toString(this.ctaParams) + ", bodyParams=" + Arrays.toString(this.bodyParams) + ", deeplink=" + this.deeplink + ", iconUrl=" + this.iconUrl + ", closeable=" + this.closeable + ", defaultHeader=" + this.defaultHeader + ", defaultBody=" + this.defaultBody + ", defaultCta=" + this.defaultCta + ", cardColor=" + this.cardColor + ", headerColor=" + this.headerColor + ", bodyColor=" + this.bodyColor + ", ctaColor=" + this.ctaColor + ", showHeaderArrow=" + this.showHeaderArrow + ", ctaVisible=" + this.ctaVisible + ")";
    }

    public DynamicCustomCardDataModel(int i2, String[] strArr, String[] strArr2, String[] strArr3, String str, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, boolean z3) {
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        k.d(strArr, "headerParams");
        k.d(strArr2, "ctaParams");
        k.d(strArr3, "bodyParams");
        k.d(str, "deeplink");
        k.d(str10, SDKConstants.ICON_URL);
        k.d(str11, "defaultHeader");
        k.d(str12, "defaultBody");
        k.d(str13, "defaultCta");
        this.cardId = i2;
        this.headerParams = strArr;
        this.ctaParams = strArr2;
        this.bodyParams = strArr3;
        this.deeplink = str;
        this.iconUrl = str10;
        this.closeable = z;
        this.defaultHeader = str11;
        this.defaultBody = str12;
        this.defaultCta = str13;
        this.cardColor = str6;
        this.headerColor = str7;
        this.bodyColor = str8;
        this.ctaColor = str9;
        this.showHeaderArrow = z2;
        this.ctaVisible = z3;
    }

    public final int getCardId() {
        return this.cardId;
    }

    public final String[] getHeaderParams() {
        return this.headerParams;
    }

    public final String[] getCtaParams() {
        return this.ctaParams;
    }

    public final String[] getBodyParams() {
        return this.bodyParams;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final boolean getCloseable() {
        return this.closeable;
    }

    public final String getDefaultHeader() {
        return this.defaultHeader;
    }

    public final String getDefaultBody() {
        return this.defaultBody;
    }

    public final String getDefaultCta() {
        return this.defaultCta;
    }

    public final String getCardColor() {
        return this.cardColor;
    }

    public final String getHeaderColor() {
        return this.headerColor;
    }

    public final String getBodyColor() {
        return this.bodyColor;
    }

    public final String getCtaColor() {
        return this.ctaColor;
    }

    public final boolean getShowHeaderArrow() {
        return this.showHeaderArrow;
    }

    public final boolean getCtaVisible() {
        return this.ctaVisible;
    }
}
