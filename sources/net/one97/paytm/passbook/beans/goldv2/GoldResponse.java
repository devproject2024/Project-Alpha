package net.one97.paytm.passbook.beans.goldv2;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class GoldResponse extends IJRDataModel {
    @b(a = "code")
    private final String code;
    @b(a = "customer")
    private final GoldCustomer customer;
    @b(a = "error")
    private final GoldError error;
    @b(a = "message")
    private final String message;

    public GoldResponse() {
        this((GoldCustomer) null, (GoldError) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ GoldResponse copy$default(GoldResponse goldResponse, GoldCustomer goldCustomer, GoldError goldError, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            goldCustomer = goldResponse.customer;
        }
        if ((i2 & 2) != 0) {
            goldError = goldResponse.error;
        }
        if ((i2 & 4) != 0) {
            str = goldResponse.message;
        }
        if ((i2 & 8) != 0) {
            str2 = goldResponse.code;
        }
        return goldResponse.copy(goldCustomer, goldError, str, str2);
    }

    public final GoldCustomer component1() {
        return this.customer;
    }

    public final GoldError component2() {
        return this.error;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.code;
    }

    public final GoldResponse copy(GoldCustomer goldCustomer, GoldError goldError, String str, String str2) {
        return new GoldResponse(goldCustomer, goldError, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoldResponse)) {
            return false;
        }
        GoldResponse goldResponse = (GoldResponse) obj;
        return k.a((Object) this.customer, (Object) goldResponse.customer) && k.a((Object) this.error, (Object) goldResponse.error) && k.a((Object) this.message, (Object) goldResponse.message) && k.a((Object) this.code, (Object) goldResponse.code);
    }

    public final int hashCode() {
        GoldCustomer goldCustomer = this.customer;
        int i2 = 0;
        int hashCode = (goldCustomer != null ? goldCustomer.hashCode() : 0) * 31;
        GoldError goldError = this.error;
        int hashCode2 = (hashCode + (goldError != null ? goldError.hashCode() : 0)) * 31;
        String str = this.message;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.code;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "GoldResponse(customer=" + this.customer + ", error=" + this.error + ", message=" + this.message + ", code=" + this.code + ")";
    }

    public final GoldCustomer getCustomer() {
        return this.customer;
    }

    public final GoldError getError() {
        return this.error;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoldResponse(GoldCustomer goldCustomer, GoldError goldError, String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : goldCustomer, (i2 & 2) != 0 ? null : goldError, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2);
    }

    public final String getCode() {
        return this.code;
    }

    public GoldResponse(GoldCustomer goldCustomer, GoldError goldError, String str, String str2) {
        this.customer = goldCustomer;
        this.error = goldError;
        this.message = str;
        this.code = str2;
    }
}
