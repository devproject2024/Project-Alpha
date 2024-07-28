package net.one97.paytm.nativesdk.common.model;

import java.util.ArrayList;
import net.one97.paytm.nativesdk.common.model.ApplyPromoResponse;

public class PaymentModes implements Cloneable, BaseDataModel {
    private String displayName;
    private ApplyPromoResponse.PaymentOffer hybridPaymentOffer;
    private IsDisabled isDisabled;
    private boolean isEmiHybridDisabled;
    private boolean isHybridDisabled;
    private boolean onboarding;
    private boolean oneClickSupported;
    private ArrayList<PayChannelOptions> payChannelOptions;
    private String paymentMode;
    private ApplyPromoResponse.PaymentOffer paymentOffer;
    private PaymentOfferDetails paymentOfferDetails;
    private String priority;
    private int sortingWeight = 0;

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabled isDisabled2) {
        this.isDisabled = isDisabled2;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public ArrayList<PayChannelOptions> getPayChannelOptions() {
        return this.payChannelOptions;
    }

    public void setPayChannelOptions(ArrayList<PayChannelOptions> arrayList) {
        this.payChannelOptions = arrayList;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setSortingWeight(int i2) {
        this.sortingWeight = i2;
    }

    public int getSortingWeight() {
        return this.sortingWeight;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setOnboarding(boolean z) {
        this.onboarding = z;
    }

    public boolean getOnboarding() {
        return this.onboarding;
    }

    public String toString() {
        return "ClassPojo [isDisabled = " + this.isDisabled + ", paymentMode = " + this.paymentMode + ", payChannelOptions = " + this.payChannelOptions + ", displayName = " + this.displayName + "]";
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public boolean isOnboarding() {
        return this.onboarding;
    }

    public PaymentOfferDetails getPaymentOfferDetails() {
        return this.paymentOfferDetails;
    }

    public void setPaymentOfferDetails(PaymentOfferDetails paymentOfferDetails2) {
        this.paymentOfferDetails = paymentOfferDetails2;
    }

    public void setPaymentOffer(ApplyPromoResponse.PaymentOffer paymentOffer2) {
        this.paymentOffer = paymentOffer2;
    }

    public void setHybridPaymentOffer(ApplyPromoResponse.PaymentOffer paymentOffer2) {
        this.hybridPaymentOffer = paymentOffer2;
    }

    public ApplyPromoResponse.PaymentOffer getPaymentOffer() {
        return this.paymentOffer;
    }

    public ApplyPromoResponse.PaymentOffer getHybridPaymentOffer() {
        return this.hybridPaymentOffer;
    }

    public boolean isOneClickSupported() {
        return this.oneClickSupported;
    }

    public boolean isHybridDisabled() {
        return this.isHybridDisabled;
    }

    public boolean isEmiHybridDisabled() {
        return this.isEmiHybridDisabled;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
