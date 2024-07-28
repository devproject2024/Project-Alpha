package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class VerifyCardDetailsReqModel {
    @b(a = "cardExpiryMonth")
    private final String cardExpiryMonth;
    @b(a = "cardExpiryYear")
    private final String cardExpiryYear;
    @b(a = "cardNo")
    private final String cardNo;
    @b(a = "meta")
    private final Meta meta;

    public VerifyCardDetailsReqModel(String str, String str2, String str3, Meta meta2) {
        k.c(str, "cardNo");
        k.c(str2, "cardExpiryMonth");
        k.c(str3, "cardExpiryYear");
        k.c(meta2, "meta");
        this.cardNo = str;
        this.cardExpiryMonth = str2;
        this.cardExpiryYear = str3;
        this.meta = meta2;
    }

    public final String getCardNo() {
        return this.cardNo;
    }

    public final String getCardExpiryMonth() {
        return this.cardExpiryMonth;
    }

    public final String getCardExpiryYear() {
        return this.cardExpiryYear;
    }

    public final Meta getMeta() {
        return this.meta;
    }
}
