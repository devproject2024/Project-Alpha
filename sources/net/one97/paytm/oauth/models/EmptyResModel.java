package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public final class EmptyResModel extends IJRPaytmDataModel {
    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        return this;
    }
}
