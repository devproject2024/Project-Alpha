package net.one97.paytm.o2o.movies.common.movies.foodbeverage;

import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRFoodVoucherItem implements IJRDataModel {
    private final HashMap<Long, a> idVoucherCodeMapping;
    private final Long productId;
    private final Integer quantity;
    private final String totalChargedPrice;
    private final String unitPrice;
    private final String voucherName;

    public static /* synthetic */ CJRFoodVoucherItem copy$default(CJRFoodVoucherItem cJRFoodVoucherItem, String str, Long l, String str2, String str3, Integer num, HashMap<Long, a> hashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRFoodVoucherItem.voucherName;
        }
        if ((i2 & 2) != 0) {
            l = cJRFoodVoucherItem.productId;
        }
        Long l2 = l;
        if ((i2 & 4) != 0) {
            str2 = cJRFoodVoucherItem.unitPrice;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            str3 = cJRFoodVoucherItem.totalChargedPrice;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            num = cJRFoodVoucherItem.quantity;
        }
        Integer num2 = num;
        if ((i2 & 32) != 0) {
            hashMap = cJRFoodVoucherItem.idVoucherCodeMapping;
        }
        return cJRFoodVoucherItem.copy(str, l2, str4, str5, num2, hashMap);
    }

    public final String component1() {
        return this.voucherName;
    }

    public final Long component2() {
        return this.productId;
    }

    public final String component3() {
        return this.unitPrice;
    }

    public final String component4() {
        return this.totalChargedPrice;
    }

    public final Integer component5() {
        return this.quantity;
    }

    public final HashMap<Long, a> component6() {
        return this.idVoucherCodeMapping;
    }

    public final CJRFoodVoucherItem copy(String str, Long l, String str2, String str3, Integer num, HashMap<Long, a> hashMap) {
        return new CJRFoodVoucherItem(str, l, str2, str3, num, hashMap);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRFoodVoucherItem)) {
            return false;
        }
        CJRFoodVoucherItem cJRFoodVoucherItem = (CJRFoodVoucherItem) obj;
        return k.a((Object) this.voucherName, (Object) cJRFoodVoucherItem.voucherName) && k.a((Object) this.productId, (Object) cJRFoodVoucherItem.productId) && k.a((Object) this.unitPrice, (Object) cJRFoodVoucherItem.unitPrice) && k.a((Object) this.totalChargedPrice, (Object) cJRFoodVoucherItem.totalChargedPrice) && k.a((Object) this.quantity, (Object) cJRFoodVoucherItem.quantity) && k.a((Object) this.idVoucherCodeMapping, (Object) cJRFoodVoucherItem.idVoucherCodeMapping);
    }

    public final int hashCode() {
        String str = this.voucherName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.productId;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.unitPrice;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.totalChargedPrice;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.quantity;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        HashMap<Long, a> hashMap = this.idVoucherCodeMapping;
        if (hashMap != null) {
            i2 = hashMap.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "CJRFoodVoucherItem(voucherName=" + this.voucherName + ", productId=" + this.productId + ", unitPrice=" + this.unitPrice + ", totalChargedPrice=" + this.totalChargedPrice + ", quantity=" + this.quantity + ", idVoucherCodeMapping=" + this.idVoucherCodeMapping + ")";
    }

    public CJRFoodVoucherItem(String str, Long l, String str2, String str3, Integer num, HashMap<Long, a> hashMap) {
        this.voucherName = str;
        this.productId = l;
        this.unitPrice = str2;
        this.totalChargedPrice = str3;
        this.quantity = num;
        this.idVoucherCodeMapping = hashMap;
    }

    public final String getVoucherName() {
        return this.voucherName;
    }

    public final Long getProductId() {
        return this.productId;
    }

    public final String getUnitPrice() {
        return this.unitPrice;
    }

    public final String getTotalChargedPrice() {
        return this.totalChargedPrice;
    }

    public final Integer getQuantity() {
        return this.quantity;
    }

    public final HashMap<Long, a> getIdVoucherCodeMapping() {
        return this.idVoucherCodeMapping;
    }
}
