package net.one97.paytm.games.model;

import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class GamepindSpsClient {
    @c(a = "checksumHashKey")
    public String checksumHashKey;
    @c(a = "mId")
    public String mId;
    @c(a = "mSecret")
    public String mSecret;
    @c(a = "verifyTimeoutMillis")
    public int verifyTimeoutMillis;
    @c(a = "walletBalancesUrl")
    public String walletBalancesUrl;

    public String getApiKey() {
        return this.mId + AppConstants.COLON + this.mSecret;
    }
}
