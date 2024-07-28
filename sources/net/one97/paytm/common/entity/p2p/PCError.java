package net.one97.paytm.common.entity.p2p;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class PCError extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "code")
    private String code;
    @b(a = "message")
    private String message;

    public PCError() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ PCError copy$default(PCError pCError, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pCError.code;
        }
        if ((i2 & 2) != 0) {
            str2 = pCError.message;
        }
        return pCError.copy(str, str2);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final PCError copy(String str, String str2) {
        return new PCError(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PCError)) {
            return false;
        }
        PCError pCError = (PCError) obj;
        return k.a((Object) this.code, (Object) pCError.code) && k.a((Object) this.message, (Object) pCError.message);
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "PCError(code=" + this.code + ", message=" + this.message + ")";
    }

    public PCError(String str, String str2) {
        this.code = str;
        this.message = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PCError(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
