package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CBDocumentTypeResponse extends IJRPaytmDataModel {
    @c(a = "message")
    @a
    private String message;
    @c(a = "payload")
    @a
    private List<Payload> payload;
    @c(a = "responseCode")
    @a
    private String responseCode;
    @c(a = "status")
    @a
    private String status;

    public CBDocumentTypeResponse() {
        this((String) null, (String) null, (String) null, (List) null, 15, (g) null);
    }

    public static /* synthetic */ CBDocumentTypeResponse copy$default(CBDocumentTypeResponse cBDocumentTypeResponse, String str, String str2, String str3, List<Payload> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cBDocumentTypeResponse.status;
        }
        if ((i2 & 2) != 0) {
            str2 = cBDocumentTypeResponse.responseCode;
        }
        if ((i2 & 4) != 0) {
            str3 = cBDocumentTypeResponse.message;
        }
        if ((i2 & 8) != 0) {
            list = cBDocumentTypeResponse.payload;
        }
        return cBDocumentTypeResponse.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.responseCode;
    }

    public final String component3() {
        return this.message;
    }

    public final List<Payload> component4() {
        return this.payload;
    }

    public final CBDocumentTypeResponse copy(String str, String str2, String str3, List<Payload> list) {
        return new CBDocumentTypeResponse(str, str2, str3, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CBDocumentTypeResponse)) {
            return false;
        }
        CBDocumentTypeResponse cBDocumentTypeResponse = (CBDocumentTypeResponse) obj;
        return k.a((Object) this.status, (Object) cBDocumentTypeResponse.status) && k.a((Object) this.responseCode, (Object) cBDocumentTypeResponse.responseCode) && k.a((Object) this.message, (Object) cBDocumentTypeResponse.message) && k.a((Object) this.payload, (Object) cBDocumentTypeResponse.payload);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.responseCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.message;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<Payload> list = this.payload;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CBDocumentTypeResponse(status=" + this.status + ", responseCode=" + this.responseCode + ", message=" + this.message + ", payload=" + this.payload + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(String str) {
        this.responseCode = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CBDocumentTypeResponse(String str, String str2, String str3, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : list);
    }

    public final List<Payload> getPayload() {
        return this.payload;
    }

    public final void setPayload(List<Payload> list) {
        this.payload = list;
    }

    public CBDocumentTypeResponse(String str, String str2, String str3, List<Payload> list) {
        this.status = str;
        this.responseCode = str2;
        this.message = str3;
        this.payload = list;
    }
}
