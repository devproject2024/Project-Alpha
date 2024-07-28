package net.one97.paytm.games.model.pfg;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class GamesWalletBalances {
    private Double gp_loyalty_wallet_balance;

    public GamesWalletBalances() {
        this((Double) null, 1, (g) null);
    }

    public static /* synthetic */ GamesWalletBalances copy$default(GamesWalletBalances gamesWalletBalances, Double d2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = gamesWalletBalances.gp_loyalty_wallet_balance;
        }
        return gamesWalletBalances.copy(d2);
    }

    public final Double component1() {
        return this.gp_loyalty_wallet_balance;
    }

    public final GamesWalletBalances copy(Double d2) {
        return new GamesWalletBalances(d2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof GamesWalletBalances) && k.a((Object) this.gp_loyalty_wallet_balance, (Object) ((GamesWalletBalances) obj).gp_loyalty_wallet_balance);
        }
        return true;
    }

    public final int hashCode() {
        Double d2 = this.gp_loyalty_wallet_balance;
        if (d2 != null) {
            return d2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "GamesWalletBalances(gp_loyalty_wallet_balance=" + this.gp_loyalty_wallet_balance + ")";
    }

    public GamesWalletBalances(Double d2) {
        this.gp_loyalty_wallet_balance = d2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GamesWalletBalances(Double d2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : d2);
    }

    public final Double getGp_loyalty_wallet_balance() {
        return this.gp_loyalty_wallet_balance;
    }

    public final void setGp_loyalty_wallet_balance(Double d2) {
        this.gp_loyalty_wallet_balance = d2;
    }
}
