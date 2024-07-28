package net.one97.paytm.common.entity.wallet;

import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.network.c;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRQRInfoResponse extends CJRWalletDataModel implements IJRDataModel, c {
    private static final long serialVersionUID = 1;
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

    public void parseJsonString(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.mStatusCode = jSONObject.optString("statusCode");
        this.mStatusMessage = jSONObject.optString("statusMessage");
        this.mResponse = jSONObject.optJSONObject(Payload.RESPONSE);
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        parseJsonString(str);
        return this;
    }
}
