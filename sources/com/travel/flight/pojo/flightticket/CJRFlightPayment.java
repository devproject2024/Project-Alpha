package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import org.json.JSONObject;

public class CJRFlightPayment extends IJRPaytmDataModel {
    CJRFlightSearchResult mFlightPriceChannge;
    private CJRRechargePayment mRechargePayment;

    public void setFlightPriceChannge(CJRFlightSearchResult cJRFlightSearchResult) {
        this.mFlightPriceChannge = cJRFlightSearchResult;
    }

    public CJRFlightSearchResult getFlightPriceChannge() {
        return this.mFlightPriceChannge;
    }

    public CJRRechargePayment getPaymentInfo() {
        return this.mRechargePayment;
    }

    public void setPaymentInfo(CJRRechargePayment cJRRechargePayment) {
        this.mRechargePayment = cJRRechargePayment;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        if (!jSONObject.has("internal_code")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("body");
            if (jSONObject2 != null) {
                CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
                cJRRechargePayment.parseJSONObject(jSONObject2.toString());
                setPaymentInfo(cJRRechargePayment);
            }
        } else if (jSONObject.getString("internal_code").equalsIgnoreCase("FL2_2222")) {
            setFlightPriceChannge((CJRFlightSearchResult) fVar.a(str, CJRFlightSearchResult.class));
        } else {
            JSONObject jSONObject3 = jSONObject.getJSONObject("body");
            if (jSONObject3 != null) {
                CJRRechargePayment cJRRechargePayment2 = new CJRRechargePayment();
                cJRRechargePayment2.parseJSONObject(jSONObject3.toString());
                setPaymentInfo(cJRRechargePayment2);
            }
        }
        return this;
    }
}
