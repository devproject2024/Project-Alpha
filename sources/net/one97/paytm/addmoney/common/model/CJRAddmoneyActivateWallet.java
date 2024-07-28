package net.one97.paytm.addmoney.common.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRAddmoneyActivateWallet extends IJRPaytmDataModel {
    @b(a = "statusMessage")
    private final String msg;
    @b(a = "statusCode")
    private final String statusCode;

    public CJRAddmoneyActivateWallet() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ CJRAddmoneyActivateWallet copy$default(CJRAddmoneyActivateWallet cJRAddmoneyActivateWallet, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRAddmoneyActivateWallet.statusCode;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRAddmoneyActivateWallet.msg;
        }
        return cJRAddmoneyActivateWallet.copy(str, str2);
    }

    public final String component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.msg;
    }

    public final CJRAddmoneyActivateWallet copy(String str, String str2) {
        return new CJRAddmoneyActivateWallet(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRAddmoneyActivateWallet)) {
            return false;
        }
        CJRAddmoneyActivateWallet cJRAddmoneyActivateWallet = (CJRAddmoneyActivateWallet) obj;
        return k.a((Object) this.statusCode, (Object) cJRAddmoneyActivateWallet.statusCode) && k.a((Object) this.msg, (Object) cJRAddmoneyActivateWallet.msg);
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
        return "CJRAddmoneyActivateWallet(statusCode=" + this.statusCode + ", msg=" + this.msg + ")";
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public CJRAddmoneyActivateWallet(String str, String str2) {
        this.statusCode = str;
        this.msg = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRAddmoneyActivateWallet(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getMsg() {
        return this.msg;
    }
}
