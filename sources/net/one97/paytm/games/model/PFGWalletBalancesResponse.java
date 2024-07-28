package net.one97.paytm.games.model;

import com.google.gson.a.c;
import net.one97.paytm.games.model.pfg.PFGWalletBalances;

public class PFGWalletBalancesResponse extends GpCommonBaseResponse {
    @c(a = "data")
    private PFGWalletBalances data;

    public PFGWalletBalances getBalances() {
        return this.data;
    }
}
