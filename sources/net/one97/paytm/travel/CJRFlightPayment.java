package net.one97.paytm.travel;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import org.json.JSONObject;

public class CJRFlightPayment extends IJRPaytmDataModel {
    private CJRRechargePayment mRechargePayment;

    public CJRRechargePayment getPaymentInfo() {
        return this.mRechargePayment;
    }

    public void setPaymentInfo(CJRRechargePayment cJRRechargePayment) {
        this.mRechargePayment = cJRRechargePayment;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        JSONObject jSONObject = new JSONObject(str).getJSONObject("body");
        if (jSONObject != null) {
            CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
            cJRRechargePayment.parseJSONObject(jSONObject.toString());
            setPaymentInfo(cJRRechargePayment);
        }
        return this;
    }
}
