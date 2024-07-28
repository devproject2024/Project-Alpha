package net.one97.paytm.games.model;

import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class GamepindCasClient {
    @c(a = "leaderboardPageSize")
    public int leaderboardPageSize;
    @c(a = "mId")
    public String mId;
    @c(a = "mSecret")
    public String mSecret;
    @c(a = "mapperId")
    public String mapperId;
    @c(a = "property")
    public String property;
    @c(a = "source")
    public String source;

    public String getApiKey() {
        return this.mId + AppConstants.COLON + this.mSecret;
    }
}
