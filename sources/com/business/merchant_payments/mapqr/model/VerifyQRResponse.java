package com.business.merchant_payments.mapqr.model;

import com.business.common_module.f.a;
import com.business.merchant_payments.model.qrsummarymodel.QRSummaryListItem;
import java.util.List;
import kotlin.g.b.k;

public final class VerifyQRResponse extends a {
    public String orderId;
    public String requestGuid;
    public List<? extends QRSummaryListItem> response;
    public String status;
    public String statusCode;
    public String statusMessage;

    public static /* synthetic */ VerifyQRResponse copy$default(VerifyQRResponse verifyQRResponse, String str, String str2, String str3, String str4, String str5, List<? extends QRSummaryListItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = verifyQRResponse.requestGuid;
        }
        if ((i2 & 2) != 0) {
            str2 = verifyQRResponse.orderId;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = verifyQRResponse.status;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = verifyQRResponse.statusCode;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = verifyQRResponse.statusMessage;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            list = verifyQRResponse.response;
        }
        return verifyQRResponse.copy(str, str6, str7, str8, str9, list);
    }

    public final String component1() {
        return this.requestGuid;
    }

    public final String component2() {
        return this.orderId;
    }

    public final String component3() {
        return this.status;
    }

    public final String component4() {
        return this.statusCode;
    }

    public final String component5() {
        return this.statusMessage;
    }

    public final List<QRSummaryListItem> component6() {
        return this.response;
    }

    public final VerifyQRResponse copy(String str, String str2, String str3, String str4, String str5, List<? extends QRSummaryListItem> list) {
        return new VerifyQRResponse(str, str2, str3, str4, str5, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerifyQRResponse)) {
            return false;
        }
        VerifyQRResponse verifyQRResponse = (VerifyQRResponse) obj;
        return k.a((Object) this.requestGuid, (Object) verifyQRResponse.requestGuid) && k.a((Object) this.orderId, (Object) verifyQRResponse.orderId) && k.a((Object) this.status, (Object) verifyQRResponse.status) && k.a((Object) this.statusCode, (Object) verifyQRResponse.statusCode) && k.a((Object) this.statusMessage, (Object) verifyQRResponse.statusMessage) && k.a((Object) this.response, (Object) verifyQRResponse.response);
    }

    public final int hashCode() {
        String str = this.requestGuid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.orderId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.statusCode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.statusMessage;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<? extends QRSummaryListItem> list = this.response;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "VerifyQRResponse(requestGuid=" + this.requestGuid + ", orderId=" + this.orderId + ", status=" + this.status + ", statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", response=" + this.response + ")";
    }

    public final String getRequestGuid() {
        return this.requestGuid;
    }

    public final void setRequestGuid(String str) {
        this.requestGuid = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(String str) {
        this.statusCode = str;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public final List<QRSummaryListItem> getResponse() {
        return this.response;
    }

    public final void setResponse(List<? extends QRSummaryListItem> list) {
        this.response = list;
    }

    public VerifyQRResponse(String str, String str2, String str3, String str4, String str5, List<? extends QRSummaryListItem> list) {
        this.requestGuid = str;
        this.orderId = str2;
        this.status = str3;
        this.statusCode = str4;
        this.statusMessage = str5;
        this.response = list;
    }
}
