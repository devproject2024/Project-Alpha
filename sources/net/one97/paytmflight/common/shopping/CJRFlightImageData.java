package net.one97.paytmflight.common.shopping;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import org.json.JSONObject;

public class CJRFlightImageData extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "body")
    private JSONObject body;

    public JSONObject getBody() {
        return this.body;
    }

    public void setBody(JSONObject jSONObject) {
        this.body = jSONObject;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRFlightImageData cJRFlightImageData = new CJRFlightImageData();
        cJRFlightImageData.parseImageResponse(str, cJRFlightImageData);
        return cJRFlightImageData;
    }

    public void parseImageResponse(String str, CJRFlightImageData cJRFlightImageData) {
        try {
            this.body = new JSONObject(str).getJSONObject("body");
            cJRFlightImageData.setBody(this.body);
        } catch (Exception unused) {
        }
    }
}
