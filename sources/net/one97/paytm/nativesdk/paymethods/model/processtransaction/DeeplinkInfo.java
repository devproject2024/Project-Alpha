package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import java.io.Serializable;
import kotlin.g.b.k;

public final class DeeplinkInfo implements Serializable {
    private String cashierRequestId;
    private String deepLink;
    private String orderId;
    private String transId;

    public static /* synthetic */ DeeplinkInfo copy$default(DeeplinkInfo deeplinkInfo, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = deeplinkInfo.deepLink;
        }
        if ((i2 & 2) != 0) {
            str2 = deeplinkInfo.orderId;
        }
        if ((i2 & 4) != 0) {
            str3 = deeplinkInfo.transId;
        }
        if ((i2 & 8) != 0) {
            str4 = deeplinkInfo.cashierRequestId;
        }
        return deeplinkInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.deepLink;
    }

    public final String component2() {
        return this.orderId;
    }

    public final String component3() {
        return this.transId;
    }

    public final String component4() {
        return this.cashierRequestId;
    }

    public final DeeplinkInfo copy(String str, String str2, String str3, String str4) {
        return new DeeplinkInfo(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeeplinkInfo)) {
            return false;
        }
        DeeplinkInfo deeplinkInfo = (DeeplinkInfo) obj;
        return k.a((Object) this.deepLink, (Object) deeplinkInfo.deepLink) && k.a((Object) this.orderId, (Object) deeplinkInfo.orderId) && k.a((Object) this.transId, (Object) deeplinkInfo.transId) && k.a((Object) this.cashierRequestId, (Object) deeplinkInfo.cashierRequestId);
    }

    public final int hashCode() {
        String str = this.deepLink;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.orderId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.transId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.cashierRequestId;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "DeeplinkInfo(deepLink=" + this.deepLink + ", orderId=" + this.orderId + ", transId=" + this.transId + ", cashierRequestId=" + this.cashierRequestId + ")";
    }

    public DeeplinkInfo(String str, String str2, String str3, String str4) {
        this.deepLink = str;
        this.orderId = str2;
        this.transId = str3;
        this.cashierRequestId = str4;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final void setDeepLink(String str) {
        this.deepLink = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getTransId() {
        return this.transId;
    }

    public final void setTransId(String str) {
        this.transId = str;
    }

    public final String getCashierRequestId() {
        return this.cashierRequestId;
    }

    public final void setCashierRequestId(String str) {
        this.cashierRequestId = str;
    }
}
