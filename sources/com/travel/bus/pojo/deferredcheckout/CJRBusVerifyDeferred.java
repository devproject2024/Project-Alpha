package com.travel.bus.pojo.deferredcheckout;

import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.v;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import org.json.JSONObject;

public class CJRBusVerifyDeferred extends IJRPaytmDataModel implements IJRDataModel {
    private String LOG_TAG = "CJRBusVerifyDeferred";
    private CJRRechargePayment mPaymentInfo;
    private String paymentInstruments;

    public CJRRechargePayment getPaymentInfo() {
        return this.mPaymentInfo;
    }

    public void setPayment(CJRRechargePayment cJRRechargePayment) {
        this.mPaymentInfo = cJRRechargePayment;
    }

    public String getPaymentInstruments() {
        return this.paymentInstruments;
    }

    public void setPaymentInstruments(String str) {
        this.paymentInstruments = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject(str);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("body");
        if (jSONObject3 != null) {
            try {
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) fVar.a(jSONObject3.toString(), CJRRechargeCart.class);
                if (!(cJRRechargeCart == null || cJRRechargeCart.getCart() == null || cJRRechargeCart.getCart().getPaymentInstruments() == null)) {
                    setPaymentInstruments(cJRRechargeCart.getCart().getPaymentInstruments().toString());
                }
            } catch (v e2) {
                q.c(e2.getMessage());
            }
        }
        if (jSONObject2.getJSONObject("body").has("cart") && jSONObject2.getJSONObject("body").getJSONObject("cart").has("payment_info") && (jSONObject = jSONObject2.getJSONObject("body").getJSONObject("cart").getJSONObject("payment_info")) != null) {
            CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
            cJRRechargePayment.parseJSONObject(jSONObject.toString());
            setPayment(cJRRechargePayment);
        }
        return this;
    }
}
