package net.one97.paytm.nativesdk.instruments.upipush.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public final class UpiProfile implements BaseDataModel {
    private String priority;
    private ResponseDetails respDetails;
    private Boolean upiOnboarding;

    public static /* synthetic */ UpiProfile copy$default(UpiProfile upiProfile, ResponseDetails responseDetails, Boolean bool, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            responseDetails = upiProfile.respDetails;
        }
        if ((i2 & 2) != 0) {
            bool = upiProfile.upiOnboarding;
        }
        if ((i2 & 4) != 0) {
            str = upiProfile.priority;
        }
        return upiProfile.copy(responseDetails, bool, str);
    }

    public final ResponseDetails component1() {
        return this.respDetails;
    }

    public final Boolean component2() {
        return this.upiOnboarding;
    }

    public final String component3() {
        return this.priority;
    }

    public final UpiProfile copy(ResponseDetails responseDetails, Boolean bool, String str) {
        return new UpiProfile(responseDetails, bool, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpiProfile)) {
            return false;
        }
        UpiProfile upiProfile = (UpiProfile) obj;
        return k.a((Object) this.respDetails, (Object) upiProfile.respDetails) && k.a((Object) this.upiOnboarding, (Object) upiProfile.upiOnboarding) && k.a((Object) this.priority, (Object) upiProfile.priority);
    }

    public final int hashCode() {
        ResponseDetails responseDetails = this.respDetails;
        int i2 = 0;
        int hashCode = (responseDetails != null ? responseDetails.hashCode() : 0) * 31;
        Boolean bool = this.upiOnboarding;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        String str = this.priority;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "UpiProfile(respDetails=" + this.respDetails + ", upiOnboarding=" + this.upiOnboarding + ", priority=" + this.priority + ")";
    }

    public UpiProfile(ResponseDetails responseDetails, Boolean bool, String str) {
        this.respDetails = responseDetails;
        this.upiOnboarding = bool;
        this.priority = str;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final ResponseDetails getRespDetails() {
        return this.respDetails;
    }

    public final Boolean getUpiOnboarding() {
        return this.upiOnboarding;
    }

    public final void setPriority(String str) {
        this.priority = str;
    }

    public final void setRespDetails(ResponseDetails responseDetails) {
        this.respDetails = responseDetails;
    }

    public final void setUpiOnboarding(Boolean bool) {
        this.upiOnboarding = bool;
    }
}
