package com.business.merchant_payments.model.customcards;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.util.Arrays;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class CustomCardUIModel {
    public final boolean arrowVisibleOnHeader;
    public final int backgroundColor;
    public final int bodyColor;
    public final String[] bodyParams;
    public final String bodyText;
    public final int cardId;
    public final boolean closeable;
    public final int ctaColor;
    public final String[] ctaParams;
    public final String ctaText;
    public final String deeplink;
    public final int headerColor;
    public final String[] headerParams;
    public final String headerText;
    public final int iconId;
    public final String iconUrl;
    public final boolean isCtaVisible;
    public final boolean isIconVisible;
    public final boolean showSpanAtEnd;
    public final boolean toUnderlineCta;

    public static /* synthetic */ CustomCardUIModel copy$default(CustomCardUIModel customCardUIModel, String str, String str2, String str3, int i2, boolean z, String[] strArr, String[] strArr2, String[] strArr3, String str4, String str5, boolean z2, boolean z3, boolean z4, int i3, int i4, int i5, boolean z5, boolean z6, int i6, int i7, int i8, Object obj) {
        CustomCardUIModel customCardUIModel2 = customCardUIModel;
        int i9 = i8;
        return customCardUIModel.copy((i9 & 1) != 0 ? customCardUIModel2.headerText : str, (i9 & 2) != 0 ? customCardUIModel2.bodyText : str2, (i9 & 4) != 0 ? customCardUIModel2.ctaText : str3, (i9 & 8) != 0 ? customCardUIModel2.headerColor : i2, (i9 & 16) != 0 ? customCardUIModel2.isIconVisible : z, (i9 & 32) != 0 ? customCardUIModel2.headerParams : strArr, (i9 & 64) != 0 ? customCardUIModel2.ctaParams : strArr2, (i9 & 128) != 0 ? customCardUIModel2.bodyParams : strArr3, (i9 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? customCardUIModel2.deeplink : str4, (i9 & 512) != 0 ? customCardUIModel2.iconUrl : str5, (i9 & TarConstants.EOF_BLOCK) != 0 ? customCardUIModel2.isCtaVisible : z2, (i9 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? customCardUIModel2.closeable : z3, (i9 & 4096) != 0 ? customCardUIModel2.arrowVisibleOnHeader : z4, (i9 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? customCardUIModel2.backgroundColor : i3, (i9 & 16384) != 0 ? customCardUIModel2.cardId : i4, (i9 & 32768) != 0 ? customCardUIModel2.iconId : i5, (i9 & 65536) != 0 ? customCardUIModel2.toUnderlineCta : z5, (i9 & 131072) != 0 ? customCardUIModel2.showSpanAtEnd : z6, (i9 & 262144) != 0 ? customCardUIModel2.bodyColor : i6, (i9 & 524288) != 0 ? customCardUIModel2.ctaColor : i7);
    }

    public final String component1() {
        return this.headerText;
    }

    public final String component10() {
        return this.iconUrl;
    }

    public final boolean component11() {
        return this.isCtaVisible;
    }

    public final boolean component12() {
        return this.closeable;
    }

    public final boolean component13() {
        return this.arrowVisibleOnHeader;
    }

    public final int component14() {
        return this.backgroundColor;
    }

    public final int component15() {
        return this.cardId;
    }

    public final int component16() {
        return this.iconId;
    }

    public final boolean component17() {
        return this.toUnderlineCta;
    }

    public final boolean component18() {
        return this.showSpanAtEnd;
    }

    public final int component19() {
        return this.bodyColor;
    }

    public final String component2() {
        return this.bodyText;
    }

    public final int component20() {
        return this.ctaColor;
    }

    public final String component3() {
        return this.ctaText;
    }

    public final int component4() {
        return this.headerColor;
    }

    public final boolean component5() {
        return this.isIconVisible;
    }

    public final String[] component6() {
        return this.headerParams;
    }

    public final String[] component7() {
        return this.ctaParams;
    }

    public final String[] component8() {
        return this.bodyParams;
    }

    public final String component9() {
        return this.deeplink;
    }

    public final CustomCardUIModel copy(String str, String str2, String str3, int i2, boolean z, String[] strArr, String[] strArr2, String[] strArr3, String str4, String str5, boolean z2, boolean z3, boolean z4, int i3, int i4, int i5, boolean z5, boolean z6, int i6, int i7) {
        String str6 = str;
        k.d(strArr, "headerParams");
        k.d(strArr2, "ctaParams");
        k.d(strArr3, "bodyParams");
        k.d(str4, "deeplink");
        k.d(str5, SDKConstants.ICON_URL);
        return new CustomCardUIModel(str, str2, str3, i2, z, strArr, strArr2, strArr3, str4, str5, z2, z3, z4, i3, i4, i5, z5, z6, i6, i7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomCardUIModel)) {
            return false;
        }
        CustomCardUIModel customCardUIModel = (CustomCardUIModel) obj;
        return k.a((Object) this.headerText, (Object) customCardUIModel.headerText) && k.a((Object) this.bodyText, (Object) customCardUIModel.bodyText) && k.a((Object) this.ctaText, (Object) customCardUIModel.ctaText) && this.headerColor == customCardUIModel.headerColor && this.isIconVisible == customCardUIModel.isIconVisible && k.a((Object) this.headerParams, (Object) customCardUIModel.headerParams) && k.a((Object) this.ctaParams, (Object) customCardUIModel.ctaParams) && k.a((Object) this.bodyParams, (Object) customCardUIModel.bodyParams) && k.a((Object) this.deeplink, (Object) customCardUIModel.deeplink) && k.a((Object) this.iconUrl, (Object) customCardUIModel.iconUrl) && this.isCtaVisible == customCardUIModel.isCtaVisible && this.closeable == customCardUIModel.closeable && this.arrowVisibleOnHeader == customCardUIModel.arrowVisibleOnHeader && this.backgroundColor == customCardUIModel.backgroundColor && this.cardId == customCardUIModel.cardId && this.iconId == customCardUIModel.iconId && this.toUnderlineCta == customCardUIModel.toUnderlineCta && this.showSpanAtEnd == customCardUIModel.showSpanAtEnd && this.bodyColor == customCardUIModel.bodyColor && this.ctaColor == customCardUIModel.ctaColor;
    }

    public final int hashCode() {
        String str = this.headerText;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bodyText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ctaText;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.headerColor) * 31;
        boolean z = this.isIconVisible;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        String[] strArr = this.headerParams;
        int hashCode4 = (i3 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.ctaParams;
        int hashCode5 = (hashCode4 + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31;
        String[] strArr3 = this.bodyParams;
        int hashCode6 = (hashCode5 + (strArr3 != null ? Arrays.hashCode(strArr3) : 0)) * 31;
        String str4 = this.deeplink;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.iconUrl;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i4 = (hashCode7 + i2) * 31;
        boolean z2 = this.isCtaVisible;
        if (z2) {
            z2 = true;
        }
        int i5 = (i4 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.closeable;
        if (z3) {
            z3 = true;
        }
        int i6 = (i5 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.arrowVisibleOnHeader;
        if (z4) {
            z4 = true;
        }
        int i7 = (((((((i6 + (z4 ? 1 : 0)) * 31) + this.backgroundColor) * 31) + this.cardId) * 31) + this.iconId) * 31;
        boolean z5 = this.toUnderlineCta;
        if (z5) {
            z5 = true;
        }
        int i8 = (i7 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.showSpanAtEnd;
        if (z6) {
            z6 = true;
        }
        return ((((i8 + (z6 ? 1 : 0)) * 31) + this.bodyColor) * 31) + this.ctaColor;
    }

    public final String toString() {
        return "CustomCardUIModel(headerText=" + this.headerText + ", bodyText=" + this.bodyText + ", ctaText=" + this.ctaText + ", headerColor=" + this.headerColor + ", isIconVisible=" + this.isIconVisible + ", headerParams=" + Arrays.toString(this.headerParams) + ", ctaParams=" + Arrays.toString(this.ctaParams) + ", bodyParams=" + Arrays.toString(this.bodyParams) + ", deeplink=" + this.deeplink + ", iconUrl=" + this.iconUrl + ", isCtaVisible=" + this.isCtaVisible + ", closeable=" + this.closeable + ", arrowVisibleOnHeader=" + this.arrowVisibleOnHeader + ", backgroundColor=" + this.backgroundColor + ", cardId=" + this.cardId + ", iconId=" + this.iconId + ", toUnderlineCta=" + this.toUnderlineCta + ", showSpanAtEnd=" + this.showSpanAtEnd + ", bodyColor=" + this.bodyColor + ", ctaColor=" + this.ctaColor + ")";
    }

    public CustomCardUIModel(String str, String str2, String str3, int i2, boolean z, String[] strArr, String[] strArr2, String[] strArr3, String str4, String str5, boolean z2, boolean z3, boolean z4, int i3, int i4, int i5, boolean z5, boolean z6, int i6, int i7) {
        String str6 = str4;
        String str7 = str5;
        k.d(strArr, "headerParams");
        k.d(strArr2, "ctaParams");
        k.d(strArr3, "bodyParams");
        k.d(str6, "deeplink");
        k.d(str7, SDKConstants.ICON_URL);
        this.headerText = str;
        this.bodyText = str2;
        this.ctaText = str3;
        this.headerColor = i2;
        this.isIconVisible = z;
        this.headerParams = strArr;
        this.ctaParams = strArr2;
        this.bodyParams = strArr3;
        this.deeplink = str6;
        this.iconUrl = str7;
        this.isCtaVisible = z2;
        this.closeable = z3;
        this.arrowVisibleOnHeader = z4;
        this.backgroundColor = i3;
        this.cardId = i4;
        this.iconId = i5;
        this.toUnderlineCta = z5;
        this.showSpanAtEnd = z6;
        this.bodyColor = i6;
        this.ctaColor = i7;
    }

    public final String getHeaderText() {
        return this.headerText;
    }

    public final String getBodyText() {
        return this.bodyText;
    }

    public final String getCtaText() {
        return this.ctaText;
    }

    public final int getHeaderColor() {
        return this.headerColor;
    }

    public final boolean isIconVisible() {
        return this.isIconVisible;
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

    public final boolean isCtaVisible() {
        return this.isCtaVisible;
    }

    public final boolean getCloseable() {
        return this.closeable;
    }

    public final boolean getArrowVisibleOnHeader() {
        return this.arrowVisibleOnHeader;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getCardId() {
        return this.cardId;
    }

    public final int getIconId() {
        return this.iconId;
    }

    public final boolean getToUnderlineCta() {
        return this.toUnderlineCta;
    }

    public final boolean getShowSpanAtEnd() {
        return this.showSpanAtEnd;
    }

    public final int getBodyColor() {
        return this.bodyColor;
    }

    public final int getCtaColor() {
        return this.ctaColor;
    }
}
