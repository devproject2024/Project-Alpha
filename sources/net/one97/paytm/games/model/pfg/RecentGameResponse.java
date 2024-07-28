package net.one97.paytm.games.model.pfg;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.d;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import org.json.JSONObject;

public final class RecentGameResponse extends GpCommonBaseResponse {
    private String jsonString;

    public final String getJsonString() {
        return this.jsonString;
    }

    public final void setJsonString(String str) {
        this.jsonString = str;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        super.parseResponse(str, fVar);
        try {
            byte[] bArr = getNetworkResponse().data;
            k.a((Object) bArr, "networkResponse.data");
            String str2 = new String(bArr, d.f47971a);
            if (new JSONObject(str2).getBoolean("success")) {
                net.one97.paytm.games.e.a.d dVar = net.one97.paytm.games.e.a.d.f35594a;
                List list = (List) ((GameResponse) net.one97.paytm.games.e.a.d.a(str2, GameResponse.class)).getData();
                if (list != null && (!list.isEmpty())) {
                    CategoryInfo categoryInfo = new CategoryInfo();
                    categoryInfo.setCardType(1);
                    categoryInfo.setData(list);
                    net.one97.paytm.games.e.a.d dVar2 = net.one97.paytm.games.e.a.d.f35594a;
                    this.jsonString = net.one97.paytm.games.e.a.d.a(categoryInfo);
                }
            }
        } catch (Throwable unused) {
        }
        return this;
    }
}
