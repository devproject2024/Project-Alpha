package net.one97.paytm.wallet.rateMerchant.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class RatingResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "code")
    private Integer code;
    @b(a = "message")
    private String message;

    public RatingResponse() {
        this((Integer) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ RatingResponse copy$default(RatingResponse ratingResponse, Integer num, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = ratingResponse.code;
        }
        if ((i2 & 2) != 0) {
            str = ratingResponse.message;
        }
        return ratingResponse.copy(num, str);
    }

    public final Integer component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final RatingResponse copy(Integer num, String str) {
        return new RatingResponse(num, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RatingResponse)) {
            return false;
        }
        RatingResponse ratingResponse = (RatingResponse) obj;
        return k.a((Object) this.code, (Object) ratingResponse.code) && k.a((Object) this.message, (Object) ratingResponse.message);
    }

    public final int hashCode() {
        Integer num = this.code;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.message;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "RatingResponse(code=" + this.code + ", message=" + this.message + ")";
    }

    public final Integer getCode() {
        return this.code;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public RatingResponse(Integer num, String str) {
        this.code = num;
        this.message = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RatingResponse(Integer num, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str);
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
