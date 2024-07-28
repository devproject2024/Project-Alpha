package net.one97.paytm.upi.mandate.data.model;

import com.google.gson.a.c;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public final class MandateTimeLineResponse implements UpiBaseDataModel {
    @c(a = "message")
    private final String message;
    @c(a = "responseCode")
    private final String responseCode;
    @c(a = "status")
    private final String status;
    @c(a = "timeline")
    private final List<MandateTimeLineItem> timeLine;

    public MandateTimeLineResponse() {
        this((String) null, (String) null, (String) null, (List) null, 15, (g) null);
    }

    public static /* synthetic */ MandateTimeLineResponse copy$default(MandateTimeLineResponse mandateTimeLineResponse, String str, String str2, String str3, List<MandateTimeLineItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mandateTimeLineResponse.status;
        }
        if ((i2 & 2) != 0) {
            str2 = mandateTimeLineResponse.responseCode;
        }
        if ((i2 & 4) != 0) {
            str3 = mandateTimeLineResponse.message;
        }
        if ((i2 & 8) != 0) {
            list = mandateTimeLineResponse.timeLine;
        }
        return mandateTimeLineResponse.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.responseCode;
    }

    public final String component3() {
        return this.message;
    }

    public final List<MandateTimeLineItem> component4() {
        return this.timeLine;
    }

    public final MandateTimeLineResponse copy(String str, String str2, String str3, List<MandateTimeLineItem> list) {
        return new MandateTimeLineResponse(str, str2, str3, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MandateTimeLineResponse)) {
            return false;
        }
        MandateTimeLineResponse mandateTimeLineResponse = (MandateTimeLineResponse) obj;
        return k.a((Object) this.status, (Object) mandateTimeLineResponse.status) && k.a((Object) this.responseCode, (Object) mandateTimeLineResponse.responseCode) && k.a((Object) this.message, (Object) mandateTimeLineResponse.message) && k.a((Object) this.timeLine, (Object) mandateTimeLineResponse.timeLine);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.responseCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.message;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<MandateTimeLineItem> list = this.timeLine;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MandateTimeLineResponse(status=" + this.status + ", responseCode=" + this.responseCode + ", message=" + this.message + ", timeLine=" + this.timeLine + ")";
    }

    public MandateTimeLineResponse(String str, String str2, String str3, List<MandateTimeLineItem> list) {
        this.status = str;
        this.responseCode = str2;
        this.message = str3;
        this.timeLine = list;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MandateTimeLineResponse(String str, String str2, String str3, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? null : list);
    }

    public final List<MandateTimeLineItem> getTimeLine() {
        return this.timeLine;
    }
}
