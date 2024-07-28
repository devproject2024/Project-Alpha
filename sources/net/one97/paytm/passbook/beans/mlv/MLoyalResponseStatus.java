package net.one97.paytm.passbook.beans.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MLoyalResponseStatus extends IJRDataModel {
    @b(a = "code")
    private Integer code;
    @b(a = "message")
    private MLoyalResponseMessage message;
    @b(a = "result")
    private String result;

    public MLoyalResponseStatus() {
        this((String) null, (MLoyalResponseMessage) null, (Integer) null, 7, (g) null);
    }

    public static /* synthetic */ MLoyalResponseStatus copy$default(MLoyalResponseStatus mLoyalResponseStatus, String str, MLoyalResponseMessage mLoyalResponseMessage, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mLoyalResponseStatus.result;
        }
        if ((i2 & 2) != 0) {
            mLoyalResponseMessage = mLoyalResponseStatus.message;
        }
        if ((i2 & 4) != 0) {
            num = mLoyalResponseStatus.code;
        }
        return mLoyalResponseStatus.copy(str, mLoyalResponseMessage, num);
    }

    public final String component1() {
        return this.result;
    }

    public final MLoyalResponseMessage component2() {
        return this.message;
    }

    public final Integer component3() {
        return this.code;
    }

    public final MLoyalResponseStatus copy(String str, MLoyalResponseMessage mLoyalResponseMessage, Integer num) {
        return new MLoyalResponseStatus(str, mLoyalResponseMessage, num);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MLoyalResponseStatus)) {
            return false;
        }
        MLoyalResponseStatus mLoyalResponseStatus = (MLoyalResponseStatus) obj;
        return k.a((Object) this.result, (Object) mLoyalResponseStatus.result) && k.a((Object) this.message, (Object) mLoyalResponseStatus.message) && k.a((Object) this.code, (Object) mLoyalResponseStatus.code);
    }

    public final int hashCode() {
        String str = this.result;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        MLoyalResponseMessage mLoyalResponseMessage = this.message;
        int hashCode2 = (hashCode + (mLoyalResponseMessage != null ? mLoyalResponseMessage.hashCode() : 0)) * 31;
        Integer num = this.code;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "MLoyalResponseStatus(result=" + this.result + ", message=" + this.message + ", code=" + this.code + ")";
    }

    public final String getResult() {
        return this.result;
    }

    public final void setResult(String str) {
        this.result = str;
    }

    public final MLoyalResponseMessage getMessage() {
        return this.message;
    }

    public final void setMessage(MLoyalResponseMessage mLoyalResponseMessage) {
        this.message = mLoyalResponseMessage;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MLoyalResponseStatus(String str, MLoyalResponseMessage mLoyalResponseMessage, Integer num, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : mLoyalResponseMessage, (i2 & 4) != 0 ? null : num);
    }

    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public MLoyalResponseStatus(String str, MLoyalResponseMessage mLoyalResponseMessage, Integer num) {
        this.result = str;
        this.message = mLoyalResponseMessage;
        this.code = num;
    }
}
