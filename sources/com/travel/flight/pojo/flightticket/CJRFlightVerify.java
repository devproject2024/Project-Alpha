package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import org.json.JSONObject;

public class CJRFlightVerify extends IJRPaytmDataModel {
    CJRFlightSearchResult mFlightPriceChannge;
    private CJRRechargePayment mRechargePayment;
    String paymentInstruments;
    private double paytmCashback;
    private double paytmDiscount;
    private double paytmGoldback;
    private double paytmPgcashback;

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

    public String getPaymentInstruments() {
        String str = this.paymentInstruments;
        return str != null ? str : "";
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject(str);
        if (jSONObject2.has("internal_code")) {
            String string = jSONObject2.getString("internal_code");
            if (string.equalsIgnoreCase("FL2_2222")) {
                setFlightPriceChannge((CJRFlightSearchResult) fVar.a(str, CJRFlightSearchResult.class));
            } else if (string.equalsIgnoreCase("FL2_2714") && (jSONObject = jSONObject2.getJSONObject("body")) != null) {
                setPaytmCashback(jSONObject.getDouble("paytm_cashback"));
                setPaytmDiscount(jSONObject.getDouble("paytm_discount"));
                setPaytmGoldback(jSONObject.getDouble("paytm_goldback"));
                setPaytmPgcashback(jSONObject.getDouble("paytm_pgcashback"));
                JSONObject jSONObject3 = jSONObject.getJSONObject(CJRRechargeCart.KEY_PAYMENT_INFO);
                if (jSONObject3 != null) {
                    CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
                    cJRRechargePayment.parseJSONObject(jSONObject3.toString());
                    if (jSONObject3.has("txnAmount") && jSONObject3.getJSONObject("txnAmount") != null && jSONObject3.getJSONObject("txnAmount").has("value")) {
                        cJRRechargePayment.setTxnAmount(jSONObject3.getJSONObject("txnAmount").getString("value"));
                    }
                    setPaymentInfo(cJRRechargePayment);
                }
                this.paymentInstruments = jSONObject.getJSONObject("paymentInstruments").toString();
            }
        }
        return this;
    }

    private void setPaytmDiscount(double d2) {
        this.paytmDiscount = d2;
    }

    private void setPaytmCashback(double d2) {
        this.paytmCashback = d2;
    }

    private void setPaytmGoldback(double d2) {
        this.paytmGoldback = d2;
    }

    private void setPaytmPgcashback(double d2) {
        this.paytmPgcashback = d2;
    }

    public int getPaytmDiscount() {
        return (int) this.paytmDiscount;
    }

    public int getPaytmCashback() {
        return (int) this.paytmCashback;
    }

    public int getPaytmGoldback() {
        return (int) this.paytmGoldback;
    }

    public int getPaytmPgcashback() {
        return (int) this.paytmPgcashback;
    }
}
