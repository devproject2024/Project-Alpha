package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import java.io.Serializable;
import kotlin.g.b.k;

public final class ResultInfo implements Serializable {
    private Boolean bankRetry;
    private Boolean isRedirect;
    private String resultCode;
    private String resultMsg;
    private String resultStatus;
    private Boolean retry;

    public static /* synthetic */ ResultInfo copy$default(ResultInfo resultInfo, String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = resultInfo.resultStatus;
        }
        if ((i2 & 2) != 0) {
            str2 = resultInfo.resultCode;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = resultInfo.resultMsg;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            bool = resultInfo.isRedirect;
        }
        Boolean bool4 = bool;
        if ((i2 & 16) != 0) {
            bool2 = resultInfo.retry;
        }
        Boolean bool5 = bool2;
        if ((i2 & 32) != 0) {
            bool3 = resultInfo.bankRetry;
        }
        return resultInfo.copy(str, str4, str5, bool4, bool5, bool3);
    }

    public final String component1() {
        return this.resultStatus;
    }

    public final String component2() {
        return this.resultCode;
    }

    public final String component3() {
        return this.resultMsg;
    }

    public final Boolean component4() {
        return this.isRedirect;
    }

    public final Boolean component5() {
        return this.retry;
    }

    public final Boolean component6() {
        return this.bankRetry;
    }

    public final ResultInfo copy(String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3) {
        return new ResultInfo(str, str2, str3, bool, bool2, bool3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultInfo)) {
            return false;
        }
        ResultInfo resultInfo = (ResultInfo) obj;
        return k.a((Object) this.resultStatus, (Object) resultInfo.resultStatus) && k.a((Object) this.resultCode, (Object) resultInfo.resultCode) && k.a((Object) this.resultMsg, (Object) resultInfo.resultMsg) && k.a((Object) this.isRedirect, (Object) resultInfo.isRedirect) && k.a((Object) this.retry, (Object) resultInfo.retry) && k.a((Object) this.bankRetry, (Object) resultInfo.bankRetry);
    }

    public final int hashCode() {
        String str = this.resultStatus;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.resultCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.resultMsg;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.isRedirect;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.retry;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.bankRetry;
        if (bool3 != null) {
            i2 = bool3.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "ResultInfo(resultStatus=" + this.resultStatus + ", resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", isRedirect=" + this.isRedirect + ", retry=" + this.retry + ", bankRetry=" + this.bankRetry + ")";
    }

    public ResultInfo(String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3) {
        this.resultStatus = str;
        this.resultCode = str2;
        this.resultMsg = str3;
        this.isRedirect = bool;
        this.retry = bool2;
        this.bankRetry = bool3;
    }

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final void setResultStatus(String str) {
        this.resultStatus = str;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public final void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public final Boolean isRedirect() {
        return this.isRedirect;
    }

    public final void setRedirect(Boolean bool) {
        this.isRedirect = bool;
    }

    public final Boolean getRetry() {
        return this.retry;
    }

    public final void setRetry(Boolean bool) {
        this.retry = bool;
    }

    public final Boolean getBankRetry() {
        return this.bankRetry;
    }

    public final void setBankRetry(Boolean bool) {
        this.bankRetry = bool;
    }
}
