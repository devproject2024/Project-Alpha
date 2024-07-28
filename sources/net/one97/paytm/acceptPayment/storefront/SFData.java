package net.one97.paytm.acceptPayment.storefront;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRDataModelItem;

public final class SFData extends CJRDataModelItem {
    private String rawResponse;

    public final String getRawResponse() {
        return this.rawResponse;
    }

    public final void setRawResponse(String str) {
        this.rawResponse = str;
    }

    public final String getName() {
        String name = SFData.class.getName();
        k.b(name, "SFData::class.java.name");
        return name;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        this.rawResponse = str;
        return this;
    }
}
