package net.one97.paytm.recharge.mobile_v3.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRMarkAsPaidResponseV3 extends IJRPaytmDataModel {
    @b(a = "message")
    private final String message;
    @b(a = "status")
    private final String status;

    public CJRMarkAsPaidResponseV3() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ CJRMarkAsPaidResponseV3 copy$default(CJRMarkAsPaidResponseV3 cJRMarkAsPaidResponseV3, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRMarkAsPaidResponseV3.status;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRMarkAsPaidResponseV3.message;
        }
        return cJRMarkAsPaidResponseV3.copy(str, str2);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final CJRMarkAsPaidResponseV3 copy(String str, String str2) {
        return new CJRMarkAsPaidResponseV3(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRMarkAsPaidResponseV3)) {
            return false;
        }
        CJRMarkAsPaidResponseV3 cJRMarkAsPaidResponseV3 = (CJRMarkAsPaidResponseV3) obj;
        return k.a((Object) this.status, (Object) cJRMarkAsPaidResponseV3.status) && k.a((Object) this.message, (Object) cJRMarkAsPaidResponseV3.message);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRMarkAsPaidResponseV3(status=" + this.status + ", message=" + this.message + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMarkAsPaidResponseV3(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getMessage() {
        return this.message;
    }

    public CJRMarkAsPaidResponseV3(String str, String str2) {
        this.status = str;
        this.message = str2;
    }
}
