package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class BankFfResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "payload")
    private final Payload payload;
    @b(a = "responseCode")
    private final int responseCode;
    @b(a = "responseMessage")
    private final String responseMessage;

    public BankFfResponse() {
        this((String) null, 0, (Payload) null, 7, (g) null);
    }

    public static /* synthetic */ BankFfResponse copy$default(BankFfResponse bankFfResponse, String str, int i2, Payload payload2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bankFfResponse.responseMessage;
        }
        if ((i3 & 2) != 0) {
            i2 = bankFfResponse.responseCode;
        }
        if ((i3 & 4) != 0) {
            payload2 = bankFfResponse.payload;
        }
        return bankFfResponse.copy(str, i2, payload2);
    }

    public final String component1() {
        return this.responseMessage;
    }

    public final int component2() {
        return this.responseCode;
    }

    public final Payload component3() {
        return this.payload;
    }

    public final BankFfResponse copy(String str, int i2, Payload payload2) {
        k.c(str, "responseMessage");
        return new BankFfResponse(str, i2, payload2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BankFfResponse) {
                BankFfResponse bankFfResponse = (BankFfResponse) obj;
                if (k.a((Object) this.responseMessage, (Object) bankFfResponse.responseMessage)) {
                    if (!(this.responseCode == bankFfResponse.responseCode) || !k.a((Object) this.payload, (Object) bankFfResponse.payload)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.responseMessage;
        int i2 = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.responseCode) * 31;
        Payload payload2 = this.payload;
        if (payload2 != null) {
            i2 = payload2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "BankFfResponse(responseMessage=" + this.responseMessage + ", responseCode=" + this.responseCode + ", payload=" + this.payload + ")";
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public BankFfResponse(String str, int i2, Payload payload2) {
        k.c(str, "responseMessage");
        this.responseMessage = str;
        this.responseCode = i2;
        this.payload = payload2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BankFfResponse(String str, int i2, Payload payload2, int i3, g gVar) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : payload2);
    }

    public final Payload getPayload() {
        return this.payload;
    }
}
