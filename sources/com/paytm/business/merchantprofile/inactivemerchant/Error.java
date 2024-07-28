package com.paytm.business.merchantprofile.inactivemerchant;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Error extends MerchantAccountActivationUIState {
    public final Object response;

    public Error() {
        this((Object) null, 1, (g) null);
    }

    public static /* synthetic */ Error copy$default(Error error, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = error.response;
        }
        return error.copy(obj);
    }

    public final Object component1() {
        return this.response;
    }

    public final Error copy(Object obj) {
        return new Error(obj);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Error) && k.a(this.response, ((Error) obj).response);
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.response;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Error(response=" + this.response + ")";
    }

    public Error(Object obj) {
        super((g) null);
        this.response = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Error(Object obj, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : obj);
    }

    public final Object getResponse() {
        return this.response;
    }
}
