package net.one97.paytm.games.model.pfg;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import kotlin.m.d;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public final class HomePageResponse extends GpCommonBaseResponse {
    private JSONArray jsonDataArray;

    public final JSONArray getJsonDataArray() {
        return this.jsonDataArray;
    }

    public final void setJsonDataArray(JSONArray jSONArray) {
        this.jsonDataArray = jSONArray;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        super.parseResponse(str, fVar);
        try {
            byte[] bArr = getNetworkResponse().data;
            k.a((Object) bArr, "networkResponse.data");
            JSONObject jSONObject = new JSONObject(new String(bArr, d.f47971a));
            if (jSONObject.getBoolean("success")) {
                this.jsonDataArray = jSONObject.getJSONObject("data").getJSONArray("data");
            }
        } catch (Throwable unused) {
        }
        return this;
    }
}
