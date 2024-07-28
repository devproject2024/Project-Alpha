package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class SavedCardsResModel extends IJRPaytmDataModel {
    @b(a = "renderData")
    private final RenderData renderData;
    @b(a = "resultInfo")
    private final ResultInfo resultInfo;

    public final RenderData getRenderData() {
        return this.renderData;
    }

    public final ResultInfo getResultInfo() {
        return this.resultInfo;
    }
}
