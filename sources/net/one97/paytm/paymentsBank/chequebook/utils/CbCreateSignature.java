package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CbCreateSignature extends IJRPaytmDataModel {
    @b(a = "message")
    private final String message;
    @b(a = "payload")
    private final CreateSignPayload payload;
    @b(a = "responseCode")
    private final String responseCode;
    @b(a = "status")
    private final String status;

    public CbCreateSignature() {
        this((String) null, (CreateSignPayload) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ CbCreateSignature copy$default(CbCreateSignature cbCreateSignature, String str, CreateSignPayload createSignPayload, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbCreateSignature.message;
        }
        if ((i2 & 2) != 0) {
            createSignPayload = cbCreateSignature.payload;
        }
        if ((i2 & 4) != 0) {
            str2 = cbCreateSignature.responseCode;
        }
        if ((i2 & 8) != 0) {
            str3 = cbCreateSignature.status;
        }
        return cbCreateSignature.copy(str, createSignPayload, str2, str3);
    }

    public final String component1() {
        return this.message;
    }

    public final CreateSignPayload component2() {
        return this.payload;
    }

    public final String component3() {
        return this.responseCode;
    }

    public final String component4() {
        return this.status;
    }

    public final CbCreateSignature copy(String str, CreateSignPayload createSignPayload, String str2, String str3) {
        return new CbCreateSignature(str, createSignPayload, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbCreateSignature)) {
            return false;
        }
        CbCreateSignature cbCreateSignature = (CbCreateSignature) obj;
        return k.a((Object) this.message, (Object) cbCreateSignature.message) && k.a((Object) this.payload, (Object) cbCreateSignature.payload) && k.a((Object) this.responseCode, (Object) cbCreateSignature.responseCode) && k.a((Object) this.status, (Object) cbCreateSignature.status);
    }

    public final int hashCode() {
        String str = this.message;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CreateSignPayload createSignPayload = this.payload;
        int hashCode2 = (hashCode + (createSignPayload != null ? createSignPayload.hashCode() : 0)) * 31;
        String str2 = this.responseCode;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CbCreateSignature(message=" + this.message + ", payload=" + this.payload + ", responseCode=" + this.responseCode + ", status=" + this.status + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    public final CreateSignPayload getPayload() {
        return this.payload;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public CbCreateSignature(String str, CreateSignPayload createSignPayload, String str2, String str3) {
        this.message = str;
        this.payload = createSignPayload;
        this.responseCode = str2;
        this.status = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CbCreateSignature(String str, CreateSignPayload createSignPayload, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : createSignPayload, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3);
    }

    public final String getStatus() {
        return this.status;
    }
}
