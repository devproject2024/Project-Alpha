package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class NativeWithdrawDetails extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "authenticated")
    private final Boolean authenticated;
    @b(a = "txnToken")
    private final String txnToken;

    public NativeWithdrawDetails() {
        this((String) null, (Boolean) null, 3, (g) null);
    }

    public static /* synthetic */ NativeWithdrawDetails copy$default(NativeWithdrawDetails nativeWithdrawDetails, String str, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = nativeWithdrawDetails.txnToken;
        }
        if ((i2 & 2) != 0) {
            bool = nativeWithdrawDetails.authenticated;
        }
        return nativeWithdrawDetails.copy(str, bool);
    }

    public final String component1() {
        return this.txnToken;
    }

    public final Boolean component2() {
        return this.authenticated;
    }

    public final NativeWithdrawDetails copy(String str, Boolean bool) {
        return new NativeWithdrawDetails(str, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NativeWithdrawDetails)) {
            return false;
        }
        NativeWithdrawDetails nativeWithdrawDetails = (NativeWithdrawDetails) obj;
        return k.a((Object) this.txnToken, (Object) nativeWithdrawDetails.txnToken) && k.a((Object) this.authenticated, (Object) nativeWithdrawDetails.authenticated);
    }

    public final int hashCode() {
        String str = this.txnToken;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.authenticated;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "NativeWithdrawDetails(txnToken=" + this.txnToken + ", authenticated=" + this.authenticated + ")";
    }

    public NativeWithdrawDetails(String str, Boolean bool) {
        this.txnToken = str;
        this.authenticated = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NativeWithdrawDetails(String str, Boolean bool, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : bool);
    }

    public final Object clone() {
        return super.clone();
    }

    public final Boolean getAuthenticated() {
        return this.authenticated;
    }

    public final String getTxnToken() {
        return this.txnToken;
    }
}
