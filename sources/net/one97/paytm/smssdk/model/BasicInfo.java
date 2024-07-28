package net.one97.paytm.smssdk.model;

import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;

public final class BasicInfo {
    private final String email;
    private final boolean emailVerified;

    public static /* synthetic */ BasicInfo copy$default(BasicInfo basicInfo, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = basicInfo.email;
        }
        if ((i2 & 2) != 0) {
            z = basicInfo.emailVerified;
        }
        return basicInfo.copy(str, z);
    }

    public final String component1() {
        return this.email;
    }

    public final boolean component2() {
        return this.emailVerified;
    }

    public final BasicInfo copy(String str, boolean z) {
        k.c(str, AppConstants.KEY_EMAIL);
        return new BasicInfo(str, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasicInfo)) {
            return false;
        }
        BasicInfo basicInfo = (BasicInfo) obj;
        return k.a((Object) this.email, (Object) basicInfo.email) && this.emailVerified == basicInfo.emailVerified;
    }

    public final int hashCode() {
        String str = this.email;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.emailVerified;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final String toString() {
        return "BasicInfo(email=" + this.email + ", emailVerified=" + this.emailVerified + ")";
    }

    public BasicInfo(String str, boolean z) {
        k.c(str, AppConstants.KEY_EMAIL);
        this.email = str;
        this.emailVerified = z;
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean getEmailVerified() {
        return this.emailVerified;
    }
}
