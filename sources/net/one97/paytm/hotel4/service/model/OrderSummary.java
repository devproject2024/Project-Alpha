package net.one97.paytm.hotel4.service.model;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.hotel4.service.model.ordersummary.MetaData;

public final class OrderSummary extends CJROrderSummary {
    private String request_id = "";

    public final String getRequest_id() {
        return this.request_id;
    }

    public final void setRequest_id(String str) {
        k.c(str, "<set-?>");
        this.request_id = str;
    }

    public final MetaData getMetaData(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "cartItem");
        Object obj = cJROrderedCart.mMetaDataResponse;
        k.a(obj, "cartItem.mMetaDataResponse");
        f fVar = new f();
        Object a2 = fVar.a(fVar.a(obj), MetaData.class);
        k.a(a2, "mGson.fromJson(metaDataS…ng, MetaData::class.java)");
        return (MetaData) a2;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        IJRPaytmDataModel parseResponse = super.parseResponse(str, fVar);
        k.a((Object) parseResponse, "super.parseResponse(p0, p1)");
        return parseResponse;
    }
}
