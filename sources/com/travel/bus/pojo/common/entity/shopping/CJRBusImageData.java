package com.travel.bus.pojo.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import org.json.JSONObject;

public class CJRBusImageData extends IJRPaytmDataModel {
    private static final String LOG_TAG = "CJRBusImageData";
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
        CJRBusImageData cJRBusImageData = new CJRBusImageData();
        cJRBusImageData.parseImageResponse(str, cJRBusImageData);
        return cJRBusImageData;
    }

    public void parseImageResponse(String str, CJRBusImageData cJRBusImageData) {
        try {
            this.body = new JSONObject(str).getJSONObject("body");
            cJRBusImageData.setBody(this.body);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }
}
