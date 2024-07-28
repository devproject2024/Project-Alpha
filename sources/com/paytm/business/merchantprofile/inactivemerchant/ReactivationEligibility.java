package com.paytm.business.merchantprofile.inactivemerchant;

import kotlin.g.b.k;

public final class ReactivationEligibility {
    public final boolean instantActivation;
    public final String status;

    public static /* synthetic */ ReactivationEligibility copy$default(ReactivationEligibility reactivationEligibility, boolean z, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = reactivationEligibility.instantActivation;
        }
        if ((i2 & 2) != 0) {
            str = reactivationEligibility.status;
        }
        return reactivationEligibility.copy(z, str);
    }

    public final boolean component1() {
        return this.instantActivation;
    }

    public final String component2() {
        return this.status;
    }

    public final ReactivationEligibility copy(boolean z, String str) {
        k.d(str, "status");
        return new ReactivationEligibility(z, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReactivationEligibility)) {
            return false;
        }
        ReactivationEligibility reactivationEligibility = (ReactivationEligibility) obj;
        return this.instantActivation == reactivationEligibility.instantActivation && k.a((Object) this.status, (Object) reactivationEligibility.status);
    }

    public final int hashCode() {
        boolean z = this.instantActivation;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.status;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "ReactivationEligibility(instantActivation=" + this.instantActivation + ", status=" + this.status + ")";
    }

    public ReactivationEligibility(boolean z, String str) {
        k.d(str, "status");
        this.instantActivation = z;
        this.status = str;
    }

    public final boolean getInstantActivation() {
        return this.instantActivation;
    }

    public final String getStatus() {
        return this.status;
    }
}
