package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class Result extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "resultCode")
    private String resultCode;
    @b(a = "resultCodeId")
    private String resultCodeId;
    @b(a = "resultMsg")
    private String resultMsg;
    @b(a = "resultStatus")
    private String resultStatus;

    public Result() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ Result copy$default(Result result, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = result.resultStatus;
        }
        if ((i2 & 2) != 0) {
            str2 = result.resultCodeId;
        }
        if ((i2 & 4) != 0) {
            str3 = result.resultCode;
        }
        if ((i2 & 8) != 0) {
            str4 = result.resultMsg;
        }
        return result.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.resultStatus;
    }

    public final String component2() {
        return this.resultCodeId;
    }

    public final String component3() {
        return this.resultCode;
    }

    public final String component4() {
        return this.resultMsg;
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
        return k.a((Object) this.resultStatus, (Object) result.resultStatus) && k.a((Object) this.resultCodeId, (Object) result.resultCodeId) && k.a((Object) this.resultCode, (Object) result.resultCode) && k.a((Object) this.resultMsg, (Object) result.resultMsg);
    }

    public final int hashCode() {
        String str = this.resultStatus;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.resultCodeId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.resultCode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.resultMsg;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "Result(resultStatus=" + this.resultStatus + ", resultCodeId=" + this.resultCodeId + ", resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ")";
    }

    public Result(String str, String str2, String str3, String str4) {
        this.resultStatus = str;
        this.resultCodeId = str2;
        this.resultCode = str3;
        this.resultMsg = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Result(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final String getResultCodeId() {
        return this.resultCodeId;
    }

    public final String getResultMsg() {
        return this.resultMsg;
    }

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public final void setResultCodeId(String str) {
        this.resultCodeId = str;
    }

    public final void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public final void setResultStatus(String str) {
        this.resultStatus = str;
    }
}
