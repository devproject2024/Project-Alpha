package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbCheckOutPayLoad extends IJRPaytmDataModel {
    @b(a = "amount")
    private final Double amount;
    @b(a = "documentation")
    private final String documentation;
    @b(a = "errorCode")
    private final Integer errorCode;
    @b(a = "errorMessage")
    private final String errorMessage;
    @b(a = "orderId")
    private final String orderId;
    @b(a = "reqMappingId")
    private final String reqMappingId;
    @b(a = "signatureStatus")
    private final Boolean signatureStatus;

    public static /* synthetic */ CbCheckOutPayLoad copy$default(CbCheckOutPayLoad cbCheckOutPayLoad, String str, String str2, Double d2, Boolean bool, String str3, Integer num, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbCheckOutPayLoad.reqMappingId;
        }
        if ((i2 & 2) != 0) {
            str2 = cbCheckOutPayLoad.orderId;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            d2 = cbCheckOutPayLoad.amount;
        }
        Double d3 = d2;
        if ((i2 & 8) != 0) {
            bool = cbCheckOutPayLoad.signatureStatus;
        }
        Boolean bool2 = bool;
        if ((i2 & 16) != 0) {
            str3 = cbCheckOutPayLoad.errorMessage;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            num = cbCheckOutPayLoad.errorCode;
        }
        Integer num2 = num;
        if ((i2 & 64) != 0) {
            str4 = cbCheckOutPayLoad.documentation;
        }
        return cbCheckOutPayLoad.copy(str, str5, d3, bool2, str6, num2, str4);
    }

    public final String component1() {
        return this.reqMappingId;
    }

    public final String component2() {
        return this.orderId;
    }

    public final Double component3() {
        return this.amount;
    }

    public final Boolean component4() {
        return this.signatureStatus;
    }

    public final String component5() {
        return this.errorMessage;
    }

    public final Integer component6() {
        return this.errorCode;
    }

    public final String component7() {
        return this.documentation;
    }

    public final CbCheckOutPayLoad copy(String str, String str2, Double d2, Boolean bool, String str3, Integer num, String str4) {
        return new CbCheckOutPayLoad(str, str2, d2, bool, str3, num, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbCheckOutPayLoad)) {
            return false;
        }
        CbCheckOutPayLoad cbCheckOutPayLoad = (CbCheckOutPayLoad) obj;
        return k.a((Object) this.reqMappingId, (Object) cbCheckOutPayLoad.reqMappingId) && k.a((Object) this.orderId, (Object) cbCheckOutPayLoad.orderId) && k.a((Object) this.amount, (Object) cbCheckOutPayLoad.amount) && k.a((Object) this.signatureStatus, (Object) cbCheckOutPayLoad.signatureStatus) && k.a((Object) this.errorMessage, (Object) cbCheckOutPayLoad.errorMessage) && k.a((Object) this.errorCode, (Object) cbCheckOutPayLoad.errorCode) && k.a((Object) this.documentation, (Object) cbCheckOutPayLoad.documentation);
    }

    public final int hashCode() {
        String str = this.reqMappingId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.orderId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Double d2 = this.amount;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Boolean bool = this.signatureStatus;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str3 = this.errorMessage;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.errorCode;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        String str4 = this.documentation;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "CbCheckOutPayLoad(reqMappingId=" + this.reqMappingId + ", orderId=" + this.orderId + ", amount=" + this.amount + ", signatureStatus=" + this.signatureStatus + ", errorMessage=" + this.errorMessage + ", errorCode=" + this.errorCode + ", documentation=" + this.documentation + ")";
    }

    public final String getReqMappingId() {
        return this.reqMappingId;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final Boolean getSignatureStatus() {
        return this.signatureStatus;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public CbCheckOutPayLoad(String str, String str2, Double d2, Boolean bool, String str3, Integer num, String str4) {
        this.reqMappingId = str;
        this.orderId = str2;
        this.amount = d2;
        this.signatureStatus = bool;
        this.errorMessage = str3;
        this.errorCode = num;
        this.documentation = str4;
    }

    public final String getDocumentation() {
        return this.documentation;
    }
}
