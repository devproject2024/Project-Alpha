package com.travel.citybus.brts.model.pojo;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class CJRCity implements Serializable {
    @b(a = "displayMerchantName")
    private String displayMerchantName;
    @b(a = "id")
    private int id;
    @b(a = "imageURL")
    private String imageURL;
    @b(a = "isEnabled")
    private boolean isEnabled;
    @b(a = "merchantId")
    private String merchantId;
    @b(a = "merchantName")
    private String merchantName;
    @b(a = "name")
    private String name;
    @b(a = "productId")
    private String productId;

    public static /* synthetic */ CJRCity copy$default(CJRCity cJRCity, int i2, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i3, Object obj) {
        CJRCity cJRCity2 = cJRCity;
        int i4 = i3;
        return cJRCity.copy((i4 & 1) != 0 ? cJRCity2.id : i2, (i4 & 2) != 0 ? cJRCity2.name : str, (i4 & 4) != 0 ? cJRCity2.merchantName : str2, (i4 & 8) != 0 ? cJRCity2.merchantId : str3, (i4 & 16) != 0 ? cJRCity2.productId : str4, (i4 & 32) != 0 ? cJRCity2.displayMerchantName : str5, (i4 & 64) != 0 ? cJRCity2.imageURL : str6, (i4 & 128) != 0 ? cJRCity2.isEnabled : z);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.merchantName;
    }

    public final String component4() {
        return this.merchantId;
    }

    public final String component5() {
        return this.productId;
    }

    public final String component6() {
        return this.displayMerchantName;
    }

    public final String component7() {
        return this.imageURL;
    }

    public final boolean component8() {
        return this.isEnabled;
    }

    public final CJRCity copy(int i2, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        k.c(str, "name");
        k.c(str2, "merchantName");
        k.c(str3, SDKConstants.KEY_MERCHANT_ID);
        k.c(str4, "productId");
        String str7 = str5;
        k.c(str7, "displayMerchantName");
        String str8 = str6;
        k.c(str8, "imageURL");
        return new CJRCity(i2, str, str2, str3, str4, str7, str8, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCity)) {
            return false;
        }
        CJRCity cJRCity = (CJRCity) obj;
        return this.id == cJRCity.id && k.a((Object) this.name, (Object) cJRCity.name) && k.a((Object) this.merchantName, (Object) cJRCity.merchantName) && k.a((Object) this.merchantId, (Object) cJRCity.merchantId) && k.a((Object) this.productId, (Object) cJRCity.productId) && k.a((Object) this.displayMerchantName, (Object) cJRCity.displayMerchantName) && k.a((Object) this.imageURL, (Object) cJRCity.imageURL) && this.isEnabled == cJRCity.isEnabled;
    }

    public final int hashCode() {
        int i2 = this.id * 31;
        String str = this.name;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.merchantName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.merchantId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.productId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.displayMerchantName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.imageURL;
        if (str6 != null) {
            i3 = str6.hashCode();
        }
        int i4 = (hashCode5 + i3) * 31;
        boolean z = this.isEnabled;
        if (z) {
            z = true;
        }
        return i4 + (z ? 1 : 0);
    }

    public final String toString() {
        return "CJRCity(id=" + this.id + ", name=" + this.name + ", merchantName=" + this.merchantName + ", merchantId=" + this.merchantId + ", productId=" + this.productId + ", displayMerchantName=" + this.displayMerchantName + ", imageURL=" + this.imageURL + ", isEnabled=" + this.isEnabled + ")";
    }

    public CJRCity(int i2, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        k.c(str, "name");
        k.c(str2, "merchantName");
        k.c(str3, SDKConstants.KEY_MERCHANT_ID);
        k.c(str4, "productId");
        k.c(str5, "displayMerchantName");
        k.c(str6, "imageURL");
        this.id = i2;
        this.name = str;
        this.merchantName = str2;
        this.merchantId = str3;
        this.productId = str4;
        this.displayMerchantName = str5;
        this.imageURL = str6;
        this.isEnabled = z;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final void setMerchantName(String str) {
        k.c(str, "<set-?>");
        this.merchantName = str;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        k.c(str, "<set-?>");
        this.merchantId = str;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setProductId(String str) {
        k.c(str, "<set-?>");
        this.productId = str;
    }

    public final String getDisplayMerchantName() {
        return this.displayMerchantName;
    }

    public final void setDisplayMerchantName(String str) {
        k.c(str, "<set-?>");
        this.displayMerchantName = str;
    }

    public final String getImageURL() {
        return this.imageURL;
    }

    public final void setImageURL(String str) {
        k.c(str, "<set-?>");
        this.imageURL = str;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }
}
