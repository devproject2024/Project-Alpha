package net.one97.paytm.recharge.model.rechargeutility;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class UnsubscribeApiResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private final String message;
    @b(a = "status")
    private final Integer status;

    public UnsubscribeApiResponse() {
        this((Integer) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ UnsubscribeApiResponse copy$default(UnsubscribeApiResponse unsubscribeApiResponse, Integer num, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = unsubscribeApiResponse.status;
        }
        if ((i2 & 2) != 0) {
            str = unsubscribeApiResponse.message;
        }
        return unsubscribeApiResponse.copy(num, str);
    }

    public final Integer component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final UnsubscribeApiResponse copy(Integer num, String str) {
        return new UnsubscribeApiResponse(num, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnsubscribeApiResponse)) {
            return false;
        }
        UnsubscribeApiResponse unsubscribeApiResponse = (UnsubscribeApiResponse) obj;
        return k.a((Object) this.status, (Object) unsubscribeApiResponse.status) && k.a((Object) this.message, (Object) unsubscribeApiResponse.message);
    }

    public final int hashCode() {
        Integer num = this.status;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.message;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "UnsubscribeApiResponse(status=" + this.status + ", message=" + this.message + ")";
    }

    public final Integer getStatus() {
        return this.status;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnsubscribeApiResponse(Integer num, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str);
    }

    public final String getMessage() {
        return this.message;
    }

    public UnsubscribeApiResponse(Integer num, String str) {
        this.status = num;
        this.message = str;
    }
}
