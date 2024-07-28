package net.one97.paytm.passbook.beans.goldv2;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class GoldError extends IJRDataModel {
    @b(a = "code")
    private final String code;
    @b(a = "status")
    private final Integer status;

    public GoldError() {
        this((Integer) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ GoldError copy$default(GoldError goldError, Integer num, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = goldError.status;
        }
        if ((i2 & 2) != 0) {
            str = goldError.code;
        }
        return goldError.copy(num, str);
    }

    public final Integer component1() {
        return this.status;
    }

    public final String component2() {
        return this.code;
    }

    public final GoldError copy(Integer num, String str) {
        return new GoldError(num, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoldError)) {
            return false;
        }
        GoldError goldError = (GoldError) obj;
        return k.a((Object) this.status, (Object) goldError.status) && k.a((Object) this.code, (Object) goldError.code);
    }

    public final int hashCode() {
        Integer num = this.status;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.code;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "GoldError(status=" + this.status + ", code=" + this.code + ")";
    }

    public final Integer getStatus() {
        return this.status;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoldError(Integer num, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str);
    }

    public final String getCode() {
        return this.code;
    }

    public GoldError(Integer num, String str) {
        this.status = num;
        this.code = str;
    }
}
