package net.one97.paytm.nativesdk.transactionsummary.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.IJRDataModel;

public final class ResultInfo implements IJRDataModel {
    private final String code;
    private final String message;
    private final String status;

    public static /* synthetic */ ResultInfo copy$default(ResultInfo resultInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = resultInfo.code;
        }
        if ((i2 & 2) != 0) {
            str2 = resultInfo.message;
        }
        if ((i2 & 4) != 0) {
            str3 = resultInfo.status;
        }
        return resultInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.status;
    }

    public final ResultInfo copy(String str, String str2, String str3) {
        k.c(str, "code");
        k.c(str2, "message");
        k.c(str3, "status");
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
        return k.a((Object) this.code, (Object) resultInfo.code) && k.a((Object) this.message, (Object) resultInfo.message) && k.a((Object) this.status, (Object) resultInfo.status);
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ResultInfo(code=" + this.code + ", message=" + this.message + ", status=" + this.status + ")";
    }

    public ResultInfo(String str, String str2, String str3) {
        k.c(str, "code");
        k.c(str2, "message");
        k.c(str3, "status");
        this.code = str;
        this.message = str2;
        this.status = str3;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStatus() {
        return this.status;
    }
}
