package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRActivateWallet extends IJRPaytmDataModel {
    @b(a = "statusMessage")
    private final String msg;
    @b(a = "statusCode")
    private final String statusCode;

    public CJRActivateWallet() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ CJRActivateWallet copy$default(CJRActivateWallet cJRActivateWallet, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRActivateWallet.statusCode;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRActivateWallet.msg;
        }
        return cJRActivateWallet.copy(str, str2);
    }

    public final String component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.msg;
    }

    public final CJRActivateWallet copy(String str, String str2) {
        return new CJRActivateWallet(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRActivateWallet)) {
            return false;
        }
        CJRActivateWallet cJRActivateWallet = (CJRActivateWallet) obj;
        return k.a((Object) this.statusCode, (Object) cJRActivateWallet.statusCode) && k.a((Object) this.msg, (Object) cJRActivateWallet.msg);
    }

    public final int hashCode() {
        String str = this.statusCode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRActivateWallet(statusCode=" + this.statusCode + ", msg=" + this.msg + ")";
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public CJRActivateWallet(String str, String str2) {
        this.statusCode = str;
        this.msg = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRActivateWallet(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getMsg() {
        return this.msg;
    }
}
