package com.business.merchant_payments.model.user;

import kotlin.g.b.k;

public final class UserDetails {
    public final DefaultInfo defaultInfo;

    public static /* synthetic */ UserDetails copy$default(UserDetails userDetails, DefaultInfo defaultInfo2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            defaultInfo2 = userDetails.defaultInfo;
        }
        return userDetails.copy(defaultInfo2);
    }

    public final DefaultInfo component1() {
        return this.defaultInfo;
    }

    public final UserDetails copy(DefaultInfo defaultInfo2) {
        k.d(defaultInfo2, "defaultInfo");
        return new UserDetails(defaultInfo2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof UserDetails) && k.a((Object) this.defaultInfo, (Object) ((UserDetails) obj).defaultInfo);
        }
        return true;
    }

    public final int hashCode() {
        DefaultInfo defaultInfo2 = this.defaultInfo;
        if (defaultInfo2 != null) {
            return defaultInfo2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "UserDetails(defaultInfo=" + this.defaultInfo + ")";
    }

    public UserDetails(DefaultInfo defaultInfo2) {
        k.d(defaultInfo2, "defaultInfo");
        this.defaultInfo = defaultInfo2;
    }

    public final DefaultInfo getDefaultInfo() {
        return this.defaultInfo;
    }
}
