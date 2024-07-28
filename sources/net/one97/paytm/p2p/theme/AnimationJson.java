package net.one97.paytm.p2p.theme;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.network.c;

public class AnimationJson extends CJRWalletDataModel implements IJRDataModel, c {
    private String json;

    public String getJson() {
        return this.json;
    }

    public void setJson(String str) {
        this.json = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        this.json = str;
        return this;
    }
}
