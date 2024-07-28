package net.one97.paytm.travel;

import android.text.TextUtils;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sendbird.android.constant.StringSet;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import org.json.JSONObject;

public class CJRTrainCartVerify extends IJRPaytmDataModel implements IJRDataModel {
    private String mConvFeeLabel = "You will be charged a convenience fee of ";
    private CJRRechargePayment mPayment;
    private CJRRechargeCart mRechargeCart;
    private String paymentInstruments;

    public CJRRechargePayment getPayment() {
        return this.mPayment;
    }

    public void setPayment(CJRRechargePayment cJRRechargePayment) {
        this.mPayment = cJRRechargePayment;
    }

    public String getPaymentInstruments() {
        return this.paymentInstruments;
    }

    public void setPaymentInstruments(String str) {
        this.paymentInstruments = str;
    }

    public CJRRechargeCart getmRechargeCart() {
        return this.mRechargeCart;
    }

    private void setRechargeCart(CJRRechargeCart cJRRechargeCart) {
        this.mRechargeCart = cJRRechargeCart;
    }

    public String getConvFeeLabel() {
        return this.mConvFeeLabel;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject(str);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("body");
        if (jSONObject3 != null) {
            CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) fVar.a(jSONObject3.toString(), CJRRechargeCart.class);
            setRechargeCart(cJRRechargeCart);
            if (!(cJRRechargeCart == null || cJRRechargeCart.getCart() == null || cJRRechargeCart.getCart().getPaymentInstruments() == null)) {
                setPaymentInstruments(cJRRechargeCart.getCart().getPaymentInstruments().toString());
            }
        }
        if (jSONObject2.getJSONObject("body").has("cart") && jSONObject2.getJSONObject("body").getJSONObject("cart").has("pg_conv_fee_label")) {
            String string = jSONObject2.getJSONObject("body").getJSONObject("cart").getString("pg_conv_fee_label");
            if (!TextUtils.isEmpty(string)) {
                this.mConvFeeLabel = string;
            }
        }
        if (jSONObject2.getJSONObject("body").has("cart") && jSONObject2.getJSONObject("body").getJSONObject("cart").has(CJRRechargeCart.KEY_PAYMENT_INFO)) {
            JSONObject jSONObject4 = jSONObject2.getJSONObject("body").getJSONObject("cart").getJSONObject(CJRRechargeCart.KEY_PAYMENT_INFO);
            if (jSONObject4 != null) {
                CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
                cJRRechargePayment.parseJSONObject(jSONObject4.toString());
                setPayment(cJRRechargePayment);
            }
        } else if (jSONObject2.getJSONObject("body").has(StringSet.order) && (jSONObject = jSONObject2.getJSONObject("body").getJSONObject(StringSet.order)) != null) {
            CJRRechargePayment cJRRechargePayment2 = new CJRRechargePayment();
            cJRRechargePayment2.parseJSONObject(jSONObject.toString());
            setPayment(cJRRechargePayment2);
        }
        return this;
    }
}
