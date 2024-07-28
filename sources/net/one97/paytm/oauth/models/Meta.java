package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class Meta {
    @b(a = "verifyId")
    private final String verifyId;

    public Meta(String str) {
        k.c(str, "verifyId");
        this.verifyId = str;
    }

    public final String getVerifyId() {
        return this.verifyId;
    }
}
