package com.paytmmall.clpartifact.modal;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRDataModelItem;

public final class StringResponseModel extends CJRDataModelItem {
    private String rawResponse;

    public final String getRawResponse() {
        return this.rawResponse;
    }

    public final void setRawResponse(String str) {
        this.rawResponse = str;
    }

    public final String getName() {
        String name = StringResponseModel.class.getName();
        k.a((Object) name, "StringResponseModel::class.java.name");
        return name;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        this.rawResponse = str;
        return this;
    }
}
