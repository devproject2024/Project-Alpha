package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CbCatalogueResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "payload")
    private final List<CbCataloguePayLoad> cataloguePayload;
    @b(a = "requestId")
    private final String requestId;
    @b(a = "responseCode")
    private final Integer responseCode;
    @b(a = "responseMessage")
    private final String responseMessage;

    public static /* synthetic */ CbCatalogueResponse copy$default(CbCatalogueResponse cbCatalogueResponse, String str, Integer num, String str2, List<CbCataloguePayLoad> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbCatalogueResponse.responseMessage;
        }
        if ((i2 & 2) != 0) {
            num = cbCatalogueResponse.responseCode;
        }
        if ((i2 & 4) != 0) {
            str2 = cbCatalogueResponse.requestId;
        }
        if ((i2 & 8) != 0) {
            list = cbCatalogueResponse.cataloguePayload;
        }
        return cbCatalogueResponse.copy(str, num, str2, list);
    }

    public final String component1() {
        return this.responseMessage;
    }

    public final Integer component2() {
        return this.responseCode;
    }

    public final String component3() {
        return this.requestId;
    }

    public final List<CbCataloguePayLoad> component4() {
        return this.cataloguePayload;
    }

    public final CbCatalogueResponse copy(String str, Integer num, String str2, List<CbCataloguePayLoad> list) {
        return new CbCatalogueResponse(str, num, str2, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbCatalogueResponse)) {
            return false;
        }
        CbCatalogueResponse cbCatalogueResponse = (CbCatalogueResponse) obj;
        return k.a((Object) this.responseMessage, (Object) cbCatalogueResponse.responseMessage) && k.a((Object) this.responseCode, (Object) cbCatalogueResponse.responseCode) && k.a((Object) this.requestId, (Object) cbCatalogueResponse.requestId) && k.a((Object) this.cataloguePayload, (Object) cbCatalogueResponse.cataloguePayload);
    }

    public final int hashCode() {
        String str = this.responseMessage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.responseCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.requestId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<CbCataloguePayLoad> list = this.cataloguePayload;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CbCatalogueResponse(responseMessage=" + this.responseMessage + ", responseCode=" + this.responseCode + ", requestId=" + this.requestId + ", cataloguePayload=" + this.cataloguePayload + ")";
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public CbCatalogueResponse(String str, Integer num, String str2, List<CbCataloguePayLoad> list) {
        this.responseMessage = str;
        this.responseCode = num;
        this.requestId = str2;
        this.cataloguePayload = list;
    }

    public final List<CbCataloguePayLoad> getCataloguePayload() {
        return this.cataloguePayload;
    }
}
