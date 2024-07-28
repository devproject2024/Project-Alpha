package net.one97.paytm.nativesdk.walletOtp;

import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ResultInfo {
    @c(a = "resultCode")
    private final String resultCode;
    @c(a = "resultMsg")
    private final String resultMsg;
    @c(a = "resultStatus")
    private final String resultStatus;

    public ResultInfo() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ ResultInfo copy$default(ResultInfo resultInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = resultInfo.resultStatus;
        }
        if ((i2 & 2) != 0) {
            str2 = resultInfo.resultCode;
        }
        if ((i2 & 4) != 0) {
            str3 = resultInfo.resultMsg;
        }
        return resultInfo.copy(str, str2, str3);
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

    public final ResultInfo copy(String str, String str2, String str3) {
        return new ResultInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultInfo)) {
            return false;
        }
        ResultInfo resultInfo = (ResultInfo) obj;
        return k.a((Object) this.resultStatus, (Object) resultInfo.resultStatus) && k.a((Object) this.resultCode, (Object) resultInfo.resultCode) && k.a((Object) this.resultMsg, (Object) resultInfo.resultMsg);
    }

    public final int hashCode() {
        String str = this.resultStatus;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.resultCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.resultMsg;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ResultInfo(resultStatus=" + this.resultStatus + ", resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ")";
    }

    public ResultInfo(String str, String str2, String str3) {
        this.resultStatus = str;
        this.resultCode = str2;
        this.resultMsg = str3;
    }

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResultInfo(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }
}
