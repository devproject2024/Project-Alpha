package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbSignatureResponse extends IJRPaytmDataModel {
    @b(a = "responseCode")
    private final Integer responseCode;
    @b(a = "responseMessage")
    private final String responseMessage;
    @b(a = "payload")
    private final CbSignaturePayload signaturePayload;

    public static /* synthetic */ CbSignatureResponse copy$default(CbSignatureResponse cbSignatureResponse, String str, Integer num, CbSignaturePayload cbSignaturePayload, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbSignatureResponse.responseMessage;
        }
        if ((i2 & 2) != 0) {
            num = cbSignatureResponse.responseCode;
        }
        if ((i2 & 4) != 0) {
            cbSignaturePayload = cbSignatureResponse.signaturePayload;
        }
        return cbSignatureResponse.copy(str, num, cbSignaturePayload);
    }

    public final String component1() {
        return this.responseMessage;
    }

    public final Integer component2() {
        return this.responseCode;
    }

    public final CbSignaturePayload component3() {
        return this.signaturePayload;
    }

    public final CbSignatureResponse copy(String str, Integer num, CbSignaturePayload cbSignaturePayload) {
        return new CbSignatureResponse(str, num, cbSignaturePayload);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbSignatureResponse)) {
            return false;
        }
        CbSignatureResponse cbSignatureResponse = (CbSignatureResponse) obj;
        return k.a((Object) this.responseMessage, (Object) cbSignatureResponse.responseMessage) && k.a((Object) this.responseCode, (Object) cbSignatureResponse.responseCode) && k.a((Object) this.signaturePayload, (Object) cbSignatureResponse.signaturePayload);
    }

    public final int hashCode() {
        String str = this.responseMessage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.responseCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        CbSignaturePayload cbSignaturePayload = this.signaturePayload;
        if (cbSignaturePayload != null) {
            i2 = cbSignaturePayload.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CbSignatureResponse(responseMessage=" + this.responseMessage + ", responseCode=" + this.responseCode + ", signaturePayload=" + this.signaturePayload + ")";
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public CbSignatureResponse(String str, Integer num, CbSignaturePayload cbSignaturePayload) {
        this.responseMessage = str;
        this.responseCode = num;
        this.signaturePayload = cbSignaturePayload;
    }

    public final CbSignaturePayload getSignaturePayload() {
        return this.signaturePayload;
    }
}
