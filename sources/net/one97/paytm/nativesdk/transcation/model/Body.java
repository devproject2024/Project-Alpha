package net.one97.paytm.nativesdk.transcation.model;

import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo;

public final class Body implements Serializable {
    private String callBackUrl;
    private ResultInfo resultInfo;
    private Object txnInfo;

    public static /* synthetic */ Body copy$default(Body body, ResultInfo resultInfo2, Object obj, String str, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            resultInfo2 = body.resultInfo;
        }
        if ((i2 & 2) != 0) {
            obj = body.txnInfo;
        }
        if ((i2 & 4) != 0) {
            str = body.callBackUrl;
        }
        return body.copy(resultInfo2, obj, str);
    }

    public final ResultInfo component1() {
        return this.resultInfo;
    }

    public final Object component2() {
        return this.txnInfo;
    }

    public final String component3() {
        return this.callBackUrl;
    }

    public final Body copy(ResultInfo resultInfo2, Object obj, String str) {
        return new Body(resultInfo2, obj, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Body)) {
            return false;
        }
        Body body = (Body) obj;
        return k.a((Object) this.resultInfo, (Object) body.resultInfo) && k.a(this.txnInfo, body.txnInfo) && k.a((Object) this.callBackUrl, (Object) body.callBackUrl);
    }

    public final int hashCode() {
        ResultInfo resultInfo2 = this.resultInfo;
        int i2 = 0;
        int hashCode = (resultInfo2 != null ? resultInfo2.hashCode() : 0) * 31;
        Object obj = this.txnInfo;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        String str = this.callBackUrl;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "Body(resultInfo=" + this.resultInfo + ", txnInfo=" + this.txnInfo + ", callBackUrl=" + this.callBackUrl + ")";
    }

    public Body(ResultInfo resultInfo2, Object obj, String str) {
        this.resultInfo = resultInfo2;
        this.txnInfo = obj;
        this.callBackUrl = str;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public final void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public final Object getTxnInfo() {
        return this.txnInfo;
    }

    public final void setTxnInfo(Object obj) {
        this.txnInfo = obj;
    }

    public final String getCallBackUrl() {
        return this.callBackUrl;
    }

    public final void setCallBackUrl(String str) {
        this.callBackUrl = str;
    }
}
