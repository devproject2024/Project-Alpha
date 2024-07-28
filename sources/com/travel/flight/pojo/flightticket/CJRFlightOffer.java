package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import org.json.JSONArray;
import org.json.JSONObject;

public class CJRFlightOffer extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "error")
    private String mError;
    @b(a = "body")
    private CJROffers mOffers;
    @b(a = "status")
    private CJRStatus mStatus;
    private String stringResponseCodes;

    public String getmError() {
        return this.mError;
    }

    public void setmError(String str) {
        this.mError = str;
    }

    public CJRStatus getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(CJRStatus cJRStatus) {
        this.mStatus = cJRStatus;
    }

    public CJROffers getmOffers() {
        return this.mOffers;
    }

    public void setmOffers(CJROffers cJROffers) {
        this.mOffers = cJROffers;
    }

    public String getStringResponseCodes() {
        return this.stringResponseCodes;
    }

    public void setStringResponseCodes(String str) {
        this.stringResponseCodes = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRFlightOfferV2 cJRFlightOfferV2 = new CJRFlightOfferV2();
        cJRFlightOfferV2.setFlightOffer((CJRFlightOffer) super.parseResponse(str, fVar));
        cJRFlightOfferV2.setStringResponse(str);
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).get("body");
            if (jSONObject.has("codes")) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("codes", (JSONArray) jSONObject.get("codes"));
                cJRFlightOfferV2.setStringResponse(jSONObject2.toString());
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return cJRFlightOfferV2;
    }
}
