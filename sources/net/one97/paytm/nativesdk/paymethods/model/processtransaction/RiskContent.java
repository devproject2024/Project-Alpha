package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import java.io.Serializable;
import kotlin.g.b.k;

public final class RiskContent implements Serializable {
    private String eventLinkId;

    public static /* synthetic */ RiskContent copy$default(RiskContent riskContent, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = riskContent.eventLinkId;
        }
        return riskContent.copy(str);
    }

    public final String component1() {
        return this.eventLinkId;
    }

    public final RiskContent copy(String str) {
        return new RiskContent(str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RiskContent) && k.a((Object) this.eventLinkId, (Object) ((RiskContent) obj).eventLinkId);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.eventLinkId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "RiskContent(eventLinkId=" + this.eventLinkId + ")";
    }

    public RiskContent(String str) {
        this.eventLinkId = str;
    }

    public final String getEventLinkId() {
        return this.eventLinkId;
    }

    public final void setEventLinkId(String str) {
        this.eventLinkId = str;
    }

    public RiskContent() {
        this((String) null);
    }
}
