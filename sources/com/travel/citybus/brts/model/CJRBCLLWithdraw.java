package com.travel.citybus.brts.model;

import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import org.json.JSONObject;

public class CJRBCLLWithdraw extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "response")
    private CJRRechargePayment mResponse;
    @b(a = "statusMessage")
    private String mStatusMessage;

    public CJRRechargePayment getResponse() {
        return this.mResponse;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        if (this.mResponse == null) {
            this.mResponse = new CJRRechargePayment();
        }
        this.mResponse.parseResponse(new JSONObject(str).get(Payload.RESPONSE).toString(), fVar);
        return this;
    }
}
