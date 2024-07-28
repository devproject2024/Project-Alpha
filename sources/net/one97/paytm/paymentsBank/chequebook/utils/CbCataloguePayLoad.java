package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbCataloguePayLoad extends IJRPaytmDataModel {
    @b(a = "price")
    private final Double amount;
    @b(a = "description")
    private final String description;
    @b(a = "fulfilmentType")
    private final String fulfilmentType;
    @b(a = "name")
    private final String name;
    @b(a = "productId")
    private final String productId;
    @b(a = "productInitiator")
    private final String productInitiator;
    @b(a = "productType")
    private final String productType;
    @b(a = "signatureStatus")
    private final Boolean signatureStatus;

    public static /* synthetic */ CbCataloguePayLoad copy$default(CbCataloguePayLoad cbCataloguePayLoad, String str, String str2, Double d2, Boolean bool, String str3, String str4, String str5, String str6, int i2, Object obj) {
        CbCataloguePayLoad cbCataloguePayLoad2 = cbCataloguePayLoad;
        int i3 = i2;
        return cbCataloguePayLoad.copy((i3 & 1) != 0 ? cbCataloguePayLoad2.productId : str, (i3 & 2) != 0 ? cbCataloguePayLoad2.name : str2, (i3 & 4) != 0 ? cbCataloguePayLoad2.amount : d2, (i3 & 8) != 0 ? cbCataloguePayLoad2.signatureStatus : bool, (i3 & 16) != 0 ? cbCataloguePayLoad2.productType : str3, (i3 & 32) != 0 ? cbCataloguePayLoad2.fulfilmentType : str4, (i3 & 64) != 0 ? cbCataloguePayLoad2.description : str5, (i3 & 128) != 0 ? cbCataloguePayLoad2.productInitiator : str6);
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.name;
    }

    public final Double component3() {
        return this.amount;
    }

    public final Boolean component4() {
        return this.signatureStatus;
    }

    public final String component5() {
        return this.productType;
    }

    public final String component6() {
        return this.fulfilmentType;
    }

    public final String component7() {
        return this.description;
    }

    public final String component8() {
        return this.productInitiator;
    }

    public final CbCataloguePayLoad copy(String str, String str2, Double d2, Boolean bool, String str3, String str4, String str5, String str6) {
        return new CbCataloguePayLoad(str, str2, d2, bool, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbCataloguePayLoad)) {
            return false;
        }
        CbCataloguePayLoad cbCataloguePayLoad = (CbCataloguePayLoad) obj;
        return k.a((Object) this.productId, (Object) cbCataloguePayLoad.productId) && k.a((Object) this.name, (Object) cbCataloguePayLoad.name) && k.a((Object) this.amount, (Object) cbCataloguePayLoad.amount) && k.a((Object) this.signatureStatus, (Object) cbCataloguePayLoad.signatureStatus) && k.a((Object) this.productType, (Object) cbCataloguePayLoad.productType) && k.a((Object) this.fulfilmentType, (Object) cbCataloguePayLoad.fulfilmentType) && k.a((Object) this.description, (Object) cbCataloguePayLoad.description) && k.a((Object) this.productInitiator, (Object) cbCataloguePayLoad.productInitiator);
    }

    public final int hashCode() {
        String str = this.productId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Double d2 = this.amount;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Boolean bool = this.signatureStatus;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str3 = this.productType;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.fulfilmentType;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.productInitiator;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "CbCataloguePayLoad(productId=" + this.productId + ", name=" + this.name + ", amount=" + this.amount + ", signatureStatus=" + this.signatureStatus + ", productType=" + this.productType + ", fulfilmentType=" + this.fulfilmentType + ", description=" + this.description + ", productInitiator=" + this.productInitiator + ")";
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getName() {
        return this.name;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final Boolean getSignatureStatus() {
        return this.signatureStatus;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final String getFulfilmentType() {
        return this.fulfilmentType;
    }

    public final String getDescription() {
        return this.description;
    }

    public CbCataloguePayLoad(String str, String str2, Double d2, Boolean bool, String str3, String str4, String str5, String str6) {
        this.productId = str;
        this.name = str2;
        this.amount = d2;
        this.signatureStatus = bool;
        this.productType = str3;
        this.fulfilmentType = str4;
        this.description = str5;
        this.productInitiator = str6;
    }

    public final String getProductInitiator() {
        return this.productInitiator;
    }
}
