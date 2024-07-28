package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class Result extends IJRDataModel {
    @b(a = "resultMsg")
    private String message;
    @b(a = "resultCode")
    private String resultCode;
    @b(a = "resultCodeId")
    private String resultId;
    @b(a = "resultStatus")
    private String status;

    public Result() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ Result copy$default(Result result, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = result.message;
        }
        if ((i2 & 2) != 0) {
            str2 = result.resultId;
        }
        if ((i2 & 4) != 0) {
            str3 = result.resultCode;
        }
        if ((i2 & 8) != 0) {
            str4 = result.status;
        }
        return result.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.resultId;
    }

    public final String component3() {
        return this.resultCode;
    }

    public final String component4() {
        return this.status;
    }

    public final Result copy(String str, String str2, String str3, String str4) {
        return new Result(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Result)) {
            return false;
        }
        Result result = (Result) obj;
        return k.a((Object) this.message, (Object) result.message) && k.a((Object) this.resultId, (Object) result.resultId) && k.a((Object) this.resultCode, (Object) result.resultCode) && k.a((Object) this.status, (Object) result.status);
    }

    public final int hashCode() {
        String str = this.message;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.resultId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.resultCode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.status;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "Result(message=" + this.message + ", resultId=" + this.resultId + ", resultCode=" + this.resultCode + ", status=" + this.status + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getResultId() {
        return this.resultId;
    }

    public final void setResultId(String str) {
        this.resultId = str;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Result(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public Result(String str, String str2, String str3, String str4) {
        this.message = str;
        this.resultId = str2;
        this.resultCode = str3;
        this.status = str4;
    }
}
