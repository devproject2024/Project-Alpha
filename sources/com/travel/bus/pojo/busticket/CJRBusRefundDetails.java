package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.bus.pojo.photos.CJRBusBPPhotos;

public class CJRBusRefundDetails extends IJRPaytmDataModel {
    @b(a = "boarding_coordinates")
    private CJRBusBPPhotos busBPPhotos;
    @b(a = "cancellation_policy_details")
    private CJRBusOrderSummaryCancellationPolicy cancelPolicy;
    @b(a = "insurance_text")
    private CJRBusInsuranceText insuranceText;
    @b(a = "refund_card")
    private CJRBusRefundCard refundCard;

    public CJRBusOrderSummaryCancellationPolicy getCancelPolicy() {
        return this.cancelPolicy;
    }

    public void setCancelPolicy(CJRBusOrderSummaryCancellationPolicy cJRBusOrderSummaryCancellationPolicy) {
        this.cancelPolicy = cJRBusOrderSummaryCancellationPolicy;
    }

    public CJRBusRefundCard getRefundCard() {
        return this.refundCard;
    }

    public void setRefundCard(CJRBusRefundCard cJRBusRefundCard) {
        this.refundCard = cJRBusRefundCard;
    }

    public CJRBusInsuranceText getInsuranceText() {
        return this.insuranceText;
    }

    public void setInsuranceText(CJRBusInsuranceText cJRBusInsuranceText) {
        this.insuranceText = cJRBusInsuranceText;
    }

    public CJRBusBPPhotos getBusBPPhotos() {
        return this.busBPPhotos;
    }

    public void setBusBPPhotos(CJRBusBPPhotos cJRBusBPPhotos) {
        this.busBPPhotos = cJRBusBPPhotos;
    }
}
