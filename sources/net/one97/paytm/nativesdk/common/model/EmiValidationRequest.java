package net.one97.paytm.nativesdk.common.model;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;

public class EmiValidationRequest implements BaseDataModel {
    @c(a = "emi_filters")
    private EmiFilters emi_filters;
    @c(a = "payment_intent")
    private ArrayList<PaymentIntent> payment_intent;
    @c(a = "payment_offers_applied")
    private ApplyPromoResponse.PaymentOffer payment_offers_applied;

    public EmiFilters getEmi_filters() {
        return this.emi_filters;
    }

    public void setEmi_filters(EmiFilters emiFilters) {
        this.emi_filters = emiFilters;
    }

    public ArrayList<PaymentIntent> getPayment_intent() {
        return this.payment_intent;
    }

    public void setPayment_intent(ArrayList<PaymentIntent> arrayList) {
        this.payment_intent = arrayList;
    }

    public ApplyPromoResponse.PaymentOffer getPayment_offers_applied() {
        return this.payment_offers_applied;
    }

    public void setPayment_offers_applied(ApplyPromoResponse.PaymentOffer paymentOffer) {
        this.payment_offers_applied = paymentOffer;
    }
}
