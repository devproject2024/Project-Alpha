package net.one97.paytm.games.model;

import com.google.gson.a.c;
import net.one97.paytm.games.model.pfg.GamesWalletBalances;

public class GamesWalletBalancesResponse extends GpCommonBaseResponse {
    @c(a = "paytm_balance")
    private GamesWalletBalances paytm_balance;

    public GamesWalletBalances getBalances() {
        return this.paytm_balance;
    }
}
