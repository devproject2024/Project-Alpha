package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class ResultInfoV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "resultCode")
    private String resultCode;
    @b(a = "resultMsg")
    private String resultMsg;
    @b(a = "resultStatus")
    private String resultStatus;

    public ResultInfoV2() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ ResultInfoV2 copy$default(ResultInfoV2 resultInfoV2, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = resultInfoV2.resultStatus;
        }
        if ((i2 & 2) != 0) {
            str2 = resultInfoV2.resultCode;
        }
        if ((i2 & 4) != 0) {
            str3 = resultInfoV2.resultMsg;
        }
        return resultInfoV2.copy(str, str2, str3);
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

    public final ResultInfoV2 copy(String str, String str2, String str3) {
        return new ResultInfoV2(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultInfoV2)) {
            return false;
        }
        ResultInfoV2 resultInfoV2 = (ResultInfoV2) obj;
        return k.a((Object) this.resultStatus, (Object) resultInfoV2.resultStatus) && k.a((Object) this.resultCode, (Object) resultInfoV2.resultCode) && k.a((Object) this.resultMsg, (Object) resultInfoV2.resultMsg);
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
        return "ResultInfoV2(resultStatus=" + this.resultStatus + ", resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ")";
    }

    public ResultInfoV2(String str, String str2, String str3) {
        this.resultStatus = str;
        this.resultCode = str2;
        this.resultMsg = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResultInfoV2(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getResultCode() {
        return this.resultCode;
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

    public final void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public final void setResultStatus(String str) {
        this.resultStatus = str;
    }
}
