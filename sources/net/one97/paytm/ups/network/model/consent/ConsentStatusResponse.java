package net.one97.paytm.ups.network.model.consent;

import java.util.List;
import kotlin.g.b.k;

public final class ConsentStatusResponse {
    private final BasicInfo basicInfo;
    private final List<ConsentStatusPreference> preferences;

    public static /* synthetic */ ConsentStatusResponse copy$default(ConsentStatusResponse consentStatusResponse, BasicInfo basicInfo2, List<ConsentStatusPreference> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            basicInfo2 = consentStatusResponse.basicInfo;
        }
        if ((i2 & 2) != 0) {
            list = consentStatusResponse.preferences;
        }
        return consentStatusResponse.copy(basicInfo2, list);
    }

    public final BasicInfo component1() {
        return this.basicInfo;
    }

    public final List<ConsentStatusPreference> component2() {
        return this.preferences;
    }

    public final ConsentStatusResponse copy(BasicInfo basicInfo2, List<ConsentStatusPreference> list) {
        k.c(basicInfo2, "basicInfo");
        k.c(list, "preferences");
        return new ConsentStatusResponse(basicInfo2, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsentStatusResponse)) {
            return false;
        }
        ConsentStatusResponse consentStatusResponse = (ConsentStatusResponse) obj;
        return k.a((Object) this.basicInfo, (Object) consentStatusResponse.basicInfo) && k.a((Object) this.preferences, (Object) consentStatusResponse.preferences);
    }

    public final int hashCode() {
        BasicInfo basicInfo2 = this.basicInfo;
        int i2 = 0;
        int hashCode = (basicInfo2 != null ? basicInfo2.hashCode() : 0) * 31;
        List<ConsentStatusPreference> list = this.preferences;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ConsentStatusResponse(basicInfo=" + this.basicInfo + ", preferences=" + this.preferences + ")";
    }

    public ConsentStatusResponse(BasicInfo basicInfo2, List<ConsentStatusPreference> list) {
        k.c(basicInfo2, "basicInfo");
        k.c(list, "preferences");
        this.basicInfo = basicInfo2;
        this.preferences = list;
    }

    public final BasicInfo getBasicInfo() {
        return this.basicInfo;
    }

    public final List<ConsentStatusPreference> getPreferences() {
        return this.preferences;
    }
}
