package com.paytm.business.merchantprofile.inactivemerchant;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class Success extends MerchantAccountActivationUIState {
    public final Object data;

    public Success() {
        this((Object) null, 1, (g) null);
    }

    public static /* synthetic */ Success copy$default(Success success, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = success.data;
        }
        return success.copy(obj);
    }

    public final Object component1() {
        return this.data;
    }

    public final Success copy(Object obj) {
        return new Success(obj);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof Success) && k.a(this.data, ((Success) obj).data);
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.data;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Success(data=" + this.data + ")";
    }

    public Success(Object obj) {
        super((g) null);
        this.data = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Success(Object obj, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : obj);
    }

    public final Object getData() {
        return this.data;
    }
}
