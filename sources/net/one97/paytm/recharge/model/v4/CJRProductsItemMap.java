package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.p;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRProductsItemMap extends IJRPaytmDataModel implements IJRDataModel {
    private HashMap<String, String> productHashMap;

    public final void setProductHashMap(HashMap<String, String> hashMap) {
        this.productHashMap = hashMap;
    }

    public final HashMap<String, String> getProductHashMap() {
        return this.productHashMap;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        HashMap<String, String> hashMap;
        if (fVar != null) {
            try {
                hashMap = (HashMap) fVar.a(str, new HashMap().getClass());
            } catch (p e2) {
                q.d(e2.getMessage());
                IJRPaytmDataModel parseResponse = super.parseResponse(str, fVar);
                k.a((Object) parseResponse, "super.parseResponse(response, gson)");
                return parseResponse;
            }
        } else {
            hashMap = null;
        }
        CJRProductsItemMap cJRProductsItemMap = new CJRProductsItemMap();
        cJRProductsItemMap.productHashMap = hashMap;
        return cJRProductsItemMap;
    }
}
