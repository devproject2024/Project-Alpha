package com.paytmmall.artifact.scan.entity;

import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRQRInfoResponse extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    String TAG = "CJRQRInfoResponse";
    @b(a = "response")
    private JSONObject mResponse;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;

    public JSONObject getResponse() {
        return this.mResponse;
    }

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mStatusCode = jSONObject.optString("statusCode");
            this.mStatusMessage = jSONObject.optString("statusMessage");
            this.mResponse = jSONObject.optJSONObject(Payload.RESPONSE);
        } catch (JSONException e2) {
            q.c(e2.getMessage());
        }
        return this;
    }
}
