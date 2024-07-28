package net.one97.paytm.games.model;

import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class GamesPcsClient {
    @c(a = "mId")
    public String mId;
    @c(a = "mSecret")
    public String mSecret;

    public String getApiKey() {
        return this.mId + AppConstants.COLON + this.mSecret;
    }
}
