package com.business.merchant_payments.model.customcards;

import java.util.Arrays;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class CustomCardDataModel {
    public final String[] bodyParams;
    public final int cardId;
    public final boolean closeable;
    public final String[] ctaParams;
    public final String deeplink;
    public final String[] headerParams;
    public final String iconUrl;

    public static /* synthetic */ CustomCardDataModel copy$default(CustomCardDataModel customCardDataModel, int i2, String[] strArr, String[] strArr2, String[] strArr3, String str, String str2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = customCardDataModel.cardId;
        }
        if ((i3 & 2) != 0) {
            strArr = customCardDataModel.headerParams;
        }
        String[] strArr4 = strArr;
        if ((i3 & 4) != 0) {
            strArr2 = customCardDataModel.ctaParams;
        }
        String[] strArr5 = strArr2;
        if ((i3 & 8) != 0) {
            strArr3 = customCardDataModel.bodyParams;
        }
        String[] strArr6 = strArr3;
        if ((i3 & 16) != 0) {
            str = customCardDataModel.deeplink;
        }
        String str3 = str;
        if ((i3 & 32) != 0) {
            str2 = customCardDataModel.iconUrl;
        }
        String str4 = str2;
        if ((i3 & 64) != 0) {
            z = customCardDataModel.closeable;
        }
        return customCardDataModel.copy(i2, strArr4, strArr5, strArr6, str3, str4, z);
    }

    public final int component1() {
        return this.cardId;
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

    public final CustomCardDataModel copy(int i2, String[] strArr, String[] strArr2, String[] strArr3, String str, String str2, boolean z) {
        k.d(strArr, "headerParams");
        k.d(strArr2, "ctaParams");
        k.d(strArr3, "bodyParams");
        k.d(str, "deeplink");
        k.d(str2, SDKConstants.ICON_URL);
        return new CustomCardDataModel(i2, strArr, strArr2, strArr3, str, str2, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomCardDataModel)) {
            return false;
        }
        CustomCardDataModel customCardDataModel = (CustomCardDataModel) obj;
        return this.cardId == customCardDataModel.cardId && k.a((Object) this.headerParams, (Object) customCardDataModel.headerParams) && k.a((Object) this.ctaParams, (Object) customCardDataModel.ctaParams) && k.a((Object) this.bodyParams, (Object) customCardDataModel.bodyParams) && k.a((Object) this.deeplink, (Object) customCardDataModel.deeplink) && k.a((Object) this.iconUrl, (Object) customCardDataModel.iconUrl) && this.closeable == customCardDataModel.closeable;
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
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        int i4 = (hashCode4 + i3) * 31;
        boolean z = this.closeable;
        if (z) {
            z = true;
        }
        return i4 + (z ? 1 : 0);
    }

    public final String toString() {
        return "CustomCardDataModel(cardId=" + this.cardId + ", headerParams=" + Arrays.toString(this.headerParams) + ", ctaParams=" + Arrays.toString(this.ctaParams) + ", bodyParams=" + Arrays.toString(this.bodyParams) + ", deeplink=" + this.deeplink + ", iconUrl=" + this.iconUrl + ", closeable=" + this.closeable + ")";
    }

    public CustomCardDataModel(int i2, String[] strArr, String[] strArr2, String[] strArr3, String str, String str2, boolean z) {
        k.d(strArr, "headerParams");
        k.d(strArr2, "ctaParams");
        k.d(strArr3, "bodyParams");
        k.d(str, "deeplink");
        k.d(str2, SDKConstants.ICON_URL);
        this.cardId = i2;
        this.headerParams = strArr;
        this.ctaParams = strArr2;
        this.bodyParams = strArr3;
        this.deeplink = str;
        this.iconUrl = str2;
        this.closeable = z;
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
}
