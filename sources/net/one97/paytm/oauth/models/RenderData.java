package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class RenderData extends IJRPaytmDataModel {
    @b(a = "masked_card_list")
    private final String maskedCardList;

    public final String getMaskedCardList() {
        return this.maskedCardList;
    }
}
