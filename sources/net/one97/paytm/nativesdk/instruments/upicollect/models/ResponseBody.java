package net.one97.paytm.nativesdk.instruments.upicollect.models;

import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo;

public final class ResponseBody implements Serializable {
    private RecurringDetails recurringDetails;
    private ResultInfo resultInfo;
    private Boolean valid;
    private String vpa;

    public static /* synthetic */ ResponseBody copy$default(ResponseBody responseBody, ResultInfo resultInfo2, String str, Boolean bool, RecurringDetails recurringDetails2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            resultInfo2 = responseBody.resultInfo;
        }
        if ((i2 & 2) != 0) {
            str = responseBody.vpa;
        }
        if ((i2 & 4) != 0) {
            bool = responseBody.valid;
        }
        if ((i2 & 8) != 0) {
            recurringDetails2 = responseBody.recurringDetails;
        }
        return responseBody.copy(resultInfo2, str, bool, recurringDetails2);
    }

    public final ResultInfo component1() {
        return this.resultInfo;
    }

    public final String component2() {
        return this.vpa;
    }

    public final Boolean component3() {
        return this.valid;
    }

    public final RecurringDetails component4() {
        return this.recurringDetails;
    }

    public final ResponseBody copy(ResultInfo resultInfo2, String str, Boolean bool, RecurringDetails recurringDetails2) {
        return new ResponseBody(resultInfo2, str, bool, recurringDetails2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseBody)) {
            return false;
        }
        ResponseBody responseBody = (ResponseBody) obj;
        return k.a((Object) this.resultInfo, (Object) responseBody.resultInfo) && k.a((Object) this.vpa, (Object) responseBody.vpa) && k.a((Object) this.valid, (Object) responseBody.valid) && k.a((Object) this.recurringDetails, (Object) responseBody.recurringDetails);
    }

    public final int hashCode() {
        ResultInfo resultInfo2 = this.resultInfo;
        int i2 = 0;
        int hashCode = (resultInfo2 != null ? resultInfo2.hashCode() : 0) * 31;
        String str = this.vpa;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Boolean bool = this.valid;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        RecurringDetails recurringDetails2 = this.recurringDetails;
        if (recurringDetails2 != null) {
            i2 = recurringDetails2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "ResponseBody(resultInfo=" + this.resultInfo + ", vpa=" + this.vpa + ", valid=" + this.valid + ", recurringDetails=" + this.recurringDetails + ")";
    }

    public ResponseBody(ResultInfo resultInfo2, String str, Boolean bool, RecurringDetails recurringDetails2) {
        this.resultInfo = resultInfo2;
        this.vpa = str;
        this.valid = bool;
        this.recurringDetails = recurringDetails2;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public final String getVpa() {
        return this.vpa;
    }

    public final void setVpa(String str) {
        this.vpa = str;
    }

    public final Boolean getValid() {
        return this.valid;
    }

    public final void setValid(Boolean bool) {
        this.valid = bool;
    }

    public final RecurringDetails getRecurringDetails() {
        return this.recurringDetails;
    }

    public final void setRecurringDetails(RecurringDetails recurringDetails2) {
        this.recurringDetails = recurringDetails2;
    }
}
