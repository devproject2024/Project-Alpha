package net.one97.paytm.upi.common.models;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class SmartTransferReponse extends IJRPaytmDataModel {
    private String action;
    private final String requestId;
    private final String respCode;
    private final String respMessage;
    private final String status;

    public static /* synthetic */ SmartTransferReponse copy$default(SmartTransferReponse smartTransferReponse, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = smartTransferReponse.requestId;
        }
        if ((i2 & 2) != 0) {
            str2 = smartTransferReponse.respCode;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = smartTransferReponse.respMessage;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = smartTransferReponse.status;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = smartTransferReponse.action;
        }
        return smartTransferReponse.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.requestId;
    }

    public final String component2() {
        return this.respCode;
    }

    public final String component3() {
        return this.respMessage;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.action;
    }

    public final SmartTransferReponse copy(String str, String str2, String str3, String str4, String str5) {
        k.c(str, "requestId");
        k.c(str4, "status");
        k.c(str5, "action");
        return new SmartTransferReponse(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmartTransferReponse)) {
            return false;
        }
        SmartTransferReponse smartTransferReponse = (SmartTransferReponse) obj;
        return k.a((Object) this.requestId, (Object) smartTransferReponse.requestId) && k.a((Object) this.respCode, (Object) smartTransferReponse.respCode) && k.a((Object) this.respMessage, (Object) smartTransferReponse.respMessage) && k.a((Object) this.status, (Object) smartTransferReponse.status) && k.a((Object) this.action, (Object) smartTransferReponse.action);
    }

    public final int hashCode() {
        String str = this.requestId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.respCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.respMessage;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.status;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.action;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "SmartTransferReponse(requestId=" + this.requestId + ", respCode=" + this.respCode + ", respMessage=" + this.respMessage + ", status=" + this.status + ", action=" + this.action + ")";
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getRespCode() {
        return this.respCode;
    }

    public final String getRespMessage() {
        return this.respMessage;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String str) {
        k.c(str, "<set-?>");
        this.action = str;
    }

    public SmartTransferReponse(String str, String str2, String str3, String str4, String str5) {
        k.c(str, "requestId");
        k.c(str4, "status");
        k.c(str5, "action");
        this.requestId = str;
        this.respCode = str2;
        this.respMessage = str3;
        this.status = str4;
        this.action = str5;
    }
}
