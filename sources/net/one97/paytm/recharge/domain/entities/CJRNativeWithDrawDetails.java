package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRNativeWithDrawDetails implements IJRDataModel {
    @b(a = "authenticated")
    private final boolean authenticated;
    @b(a = "subscriptionId")
    private final String subscriptionId;
    @b(a = "txnToken")
    private final String txnToken;

    public CJRNativeWithDrawDetails() {
        this((String) null, false, (String) null, 7, (g) null);
    }

    public static /* synthetic */ CJRNativeWithDrawDetails copy$default(CJRNativeWithDrawDetails cJRNativeWithDrawDetails, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRNativeWithDrawDetails.txnToken;
        }
        if ((i2 & 2) != 0) {
            z = cJRNativeWithDrawDetails.authenticated;
        }
        if ((i2 & 4) != 0) {
            str2 = cJRNativeWithDrawDetails.subscriptionId;
        }
        return cJRNativeWithDrawDetails.copy(str, z, str2);
    }

    public final String component1() {
        return this.txnToken;
    }

    public final boolean component2() {
        return this.authenticated;
    }

    public final String component3() {
        return this.subscriptionId;
    }

    public final CJRNativeWithDrawDetails copy(String str, boolean z, String str2) {
        return new CJRNativeWithDrawDetails(str, z, str2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CJRNativeWithDrawDetails) {
                CJRNativeWithDrawDetails cJRNativeWithDrawDetails = (CJRNativeWithDrawDetails) obj;
                if (k.a((Object) this.txnToken, (Object) cJRNativeWithDrawDetails.txnToken)) {
                    if (!(this.authenticated == cJRNativeWithDrawDetails.authenticated) || !k.a((Object) this.subscriptionId, (Object) cJRNativeWithDrawDetails.subscriptionId)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.txnToken;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.authenticated;
        if (z) {
            z = true;
        }
        int i3 = (hashCode + (z ? 1 : 0)) * 31;
        String str2 = this.subscriptionId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 + i2;
    }

    public final String toString() {
        return "CJRNativeWithDrawDetails(txnToken=" + this.txnToken + ", authenticated=" + this.authenticated + ", subscriptionId=" + this.subscriptionId + ")";
    }

    public CJRNativeWithDrawDetails(String str, boolean z, String str2) {
        this.txnToken = str;
        this.authenticated = z;
        this.subscriptionId = str2;
    }

    public final String getTxnToken() {
        return this.txnToken;
    }

    public final boolean getAuthenticated() {
        return this.authenticated;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRNativeWithDrawDetails(String str, boolean z, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : str2);
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }
}
