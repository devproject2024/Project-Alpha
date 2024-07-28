package net.one97.paytm.smssdk.model;

import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;

public final class Request {
    private final String preferenceKey;
    private final boolean preferenceValue;

    public static /* synthetic */ Request copy$default(Request request, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = request.preferenceKey;
        }
        if ((i2 & 2) != 0) {
            z = request.preferenceValue;
        }
        return request.copy(str, z);
    }

    public final String component1() {
        return this.preferenceKey;
    }

    public final boolean component2() {
        return this.preferenceValue;
    }

    public final Request copy(String str, boolean z) {
        k.c(str, AppConstants.PREFERENCE_KEY);
        return new Request(str, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;
        return k.a((Object) this.preferenceKey, (Object) request.preferenceKey) && this.preferenceValue == request.preferenceValue;
    }

    public final int hashCode() {
        String str = this.preferenceKey;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.preferenceValue;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final String toString() {
        return "Request(preferenceKey=" + this.preferenceKey + ", preferenceValue=" + this.preferenceValue + ")";
    }

    public Request(String str, boolean z) {
        k.c(str, AppConstants.PREFERENCE_KEY);
        this.preferenceKey = str;
        this.preferenceValue = z;
    }

    public final String getPreferenceKey() {
        return this.preferenceKey;
    }

    public final boolean getPreferenceValue() {
        return this.preferenceValue;
    }
}
