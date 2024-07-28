package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public final class TokenV3ResModel extends IJRPaytmDataModel {
    @b(a = "tokens")
    private final ArrayList<TokenV3Data> tokens = new ArrayList<>();

    public final ArrayList<TokenV3Data> getTokens() {
        return this.tokens;
    }
}
