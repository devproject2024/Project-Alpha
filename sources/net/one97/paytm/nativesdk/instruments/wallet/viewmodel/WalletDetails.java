package net.one97.paytm.nativesdk.instruments.wallet.viewmodel;

import kotlin.g.b.k;

public final class WalletDetails {
    private final String walletBalance;
    private final String walletName;

    public static /* synthetic */ WalletDetails copy$default(WalletDetails walletDetails, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = walletDetails.walletBalance;
        }
        if ((i2 & 2) != 0) {
            str2 = walletDetails.walletName;
        }
        return walletDetails.copy(str, str2);
    }

    public final String component1() {
        return this.walletBalance;
    }

    public final String component2() {
        return this.walletName;
    }

    public final WalletDetails copy(String str, String str2) {
        k.c(str, "walletBalance");
        k.c(str2, "walletName");
        return new WalletDetails(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletDetails)) {
            return false;
        }
        WalletDetails walletDetails = (WalletDetails) obj;
        return k.a((Object) this.walletBalance, (Object) walletDetails.walletBalance) && k.a((Object) this.walletName, (Object) walletDetails.walletName);
    }

    public final int hashCode() {
        String str = this.walletBalance;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.walletName;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "WalletDetails(walletBalance=" + this.walletBalance + ", walletName=" + this.walletName + ")";
    }

    public WalletDetails(String str, String str2) {
        k.c(str, "walletBalance");
        k.c(str2, "walletName");
        this.walletBalance = str;
        this.walletName = str2;
    }

    public final String getWalletBalance() {
        return this.walletBalance;
    }

    public final String getWalletName() {
        return this.walletName;
    }
}
