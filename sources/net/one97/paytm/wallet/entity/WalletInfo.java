package net.one97.paytm.wallet.entity;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class WalletInfo extends IJRPaytmDataModel {
    private final String amt;
    private final boolean isTruncate;

    public static /* synthetic */ WalletInfo copy$default(WalletInfo walletInfo, boolean z, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = walletInfo.isTruncate;
        }
        if ((i2 & 2) != 0) {
            str = walletInfo.amt;
        }
        return walletInfo.copy(z, str);
    }

    public final boolean component1() {
        return this.isTruncate;
    }

    public final String component2() {
        return this.amt;
    }

    public final WalletInfo copy(boolean z, String str) {
        k.c(str, "amt");
        return new WalletInfo(z, str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof WalletInfo) {
                WalletInfo walletInfo = (WalletInfo) obj;
                if (!(this.isTruncate == walletInfo.isTruncate) || !k.a((Object) this.amt, (Object) walletInfo.amt)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.isTruncate;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.amt;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "WalletInfo(isTruncate=" + this.isTruncate + ", amt=" + this.amt + ")";
    }

    public WalletInfo(boolean z, String str) {
        k.c(str, "amt");
        this.isTruncate = z;
        this.amt = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletInfo(boolean z, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? false : z, str);
    }

    public final String getAmt() {
        return this.amt;
    }

    public final boolean isTruncate() {
        return this.isTruncate;
    }
}
