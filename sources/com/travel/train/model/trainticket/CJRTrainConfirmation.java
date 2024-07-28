package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;

public class CJRTrainConfirmation extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "enable_fare_det_back_end")
    private Boolean enableFareDetBackEnd;
    @b(a = "fare_details")
    private List<CJRTrainFareDetail> fareDetails;
    @b(a = "ff_button_text")
    private String ffButtonText;
    @b(a = "grand_total_key")
    private Integer grandTotalKey;
    private boolean isGatewayChargeEnabled = true;
    private boolean isServiceChargeEnabled = true;
    @b(a = "add_ons")
    private List<CJRTrainAddOn> mAddOns;
    @b(a = "cancellation_insurance")
    private CJRTrainCancellationInsurance mCancellationInsurance;
    @b(a = "deferredCheckout")
    private Boolean mDeferredCheckout;
    @b(a = "fast_forward")
    private CJRFastForward mFastForward;
    @b(a = "infant_info")
    private ArrayList<CJRTrainInfantInfo> mInfantInfo;
    @b(a = "opt_out_pg_charges")
    private CJRTrainOptOutPGCharges mOptOutPGCharges;
    @b(a = "opt_out_service_charges")
    private CJRTrainOptOutPGCharges mOptOutServiceCharges;
    @b(a = "pax_info")
    private ArrayList<CJRTrainQuickBookPassengerInfo> mPassengerInfo;
    private CJRRechargePayment mRechargePayment;
    @b(a = "review_itinerary_message")
    private String mReviewItineraryMessage;
    @b(a = "train_details")
    private CJRTrainDetailsBody mTrainDetails;
    @b(a = "transaction_id")
    private String mTransactionId;
    @b(a = "payment_tip_message")
    private String paymentTipMessage;
    @b(a = "promotional_messages")
    private CJRTrainPromoMessageModel promoMessageModel;

    public String getPaymentTipMessage() {
        return this.paymentTipMessage;
    }

    public CJRTrainDetailsBody getmTrainDetails() {
        return this.mTrainDetails;
    }

    public void setmTrainDetails(CJRTrainDetailsBody cJRTrainDetailsBody) {
        this.mTrainDetails = cJRTrainDetailsBody;
    }

    public ArrayList<CJRTrainQuickBookPassengerInfo> getmPassengerInfo() {
        return this.mPassengerInfo;
    }

    public void setmPassengerInfo(ArrayList<CJRTrainQuickBookPassengerInfo> arrayList) {
        this.mPassengerInfo = arrayList;
    }

    public ArrayList<CJRTrainInfantInfo> getmInfantInfo() {
        return this.mInfantInfo;
    }

    public void setmInfantInfo(ArrayList<CJRTrainInfantInfo> arrayList) {
        this.mInfantInfo = arrayList;
    }

    public CJRFastForward getFastForward() {
        return this.mFastForward;
    }

    public void setFastForward(CJRFastForward cJRFastForward) {
        this.mFastForward = cJRFastForward;
    }

    public CJRRechargePayment getPaymentInfo() {
        return this.mRechargePayment;
    }

    public String getmTransactionId() {
        return this.mTransactionId;
    }

    public void setmTransactionId(String str) {
        this.mTransactionId = str;
    }

    public CJRTrainCancellationInsurance getCancellationInsurance() {
        return this.mCancellationInsurance;
    }

    public void setCancellationInsurance(CJRTrainCancellationInsurance cJRTrainCancellationInsurance) {
        this.mCancellationInsurance = cJRTrainCancellationInsurance;
    }

    public CJRTrainOptOutPGCharges getOptOutPGCharges() {
        return this.mOptOutPGCharges;
    }

    public CJRTrainOptOutPGCharges getOptOutServiceCharges() {
        return this.mOptOutServiceCharges;
    }

    public boolean isGatewayChargeEnabled() {
        return this.isGatewayChargeEnabled;
    }

    public void setGatewayChargeEnabled(boolean z) {
        this.isGatewayChargeEnabled = z;
    }

    public boolean isServiceChargeEnabled() {
        return this.isServiceChargeEnabled;
    }

    public void setServiceChargeEnabled(boolean z) {
        this.isServiceChargeEnabled = z;
    }

    public List<CJRTrainAddOn> getmAddOns() {
        return this.mAddOns;
    }

    public void setmAddOns(List<CJRTrainAddOn> list) {
        this.mAddOns = list;
    }

    public Boolean getEnableFareDetBackEnd() {
        return this.enableFareDetBackEnd;
    }

    public String getFfButtonText() {
        return this.ffButtonText;
    }

    public void setFfButtonText(String str) {
        this.ffButtonText = str;
    }

    public Integer getGrandTotalKey() {
        return this.grandTotalKey;
    }

    public void setGrandTotalKey(Integer num) {
        this.grandTotalKey = num;
    }

    public List<CJRTrainFareDetail> getFareDetails() {
        return this.fareDetails;
    }

    public void setFareDetails(List<CJRTrainFareDetail> list) {
        this.fareDetails = list;
    }

    public String getReviewItineraryMessage() {
        return this.mReviewItineraryMessage;
    }

    public void setReviewItineraryMessage(String str) {
        this.mReviewItineraryMessage = str;
    }

    public CJRTrainPromoMessageModel getPromoMessageModel() {
        return this.promoMessageModel;
    }

    public Boolean isDeferredCheckout() {
        if (this.mDeferredCheckout == null) {
            this.mDeferredCheckout = Boolean.FALSE;
        }
        return this.mDeferredCheckout;
    }
}
