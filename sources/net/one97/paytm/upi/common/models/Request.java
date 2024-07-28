package net.one97.paytm.upi.common.models;

import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;

public final class Request {
    private final String preferenceKey;
    private final String preferenceValue;

    public static /* synthetic */ Request copy$default(Request request, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = request.preferenceKey;
        }
        if ((i2 & 2) != 0) {
            str2 = request.preferenceValue;
        }
        return request.copy(str, str2);
    }

    public final String component1() {
        return this.preferenceKey;
    }

    public final String component2() {
        return this.preferenceValue;
    }

    public final Request copy(String str, String str2) {
        k.c(str, AppConstants.PREFERENCE_KEY);
        k.c(str2, AppConstants.PREFERENCE_VALUE);
        return new Request(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;
        return k.a((Object) this.preferenceKey, (Object) request.preferenceKey) && k.a((Object) this.preferenceValue, (Object) request.preferenceValue);
    }

    public final int hashCode() {
        String str = this.preferenceKey;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.preferenceValue;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Request(preferenceKey=" + this.preferenceKey + ", preferenceValue=" + this.preferenceValue + ")";
    }

    public Request(String str, String str2) {
        k.c(str, AppConstants.PREFERENCE_KEY);
        k.c(str2, AppConstants.PREFERENCE_VALUE);
        this.preferenceKey = str;
        this.preferenceValue = str2;
    }

    public final String getPreferenceKey() {
        return this.preferenceKey;
    }

    public final String getPreferenceValue() {
        return this.preferenceValue;
    }
}
