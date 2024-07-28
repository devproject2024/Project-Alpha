package net.one97.paytm.nativesdk.common.model;

import android.os.Build;
import com.google.gson.a.a;
import com.google.gson.a.c;

public class SavedInstruments implements BaseDataModel {
    private String[] authModes;
    private CardDetails cardDetails;
    private String channelCode;
    private String channelName;
    private String displayName;
    private EmiDetails emiDetails;
    private HasLowSuccess hasLowSuccess;
    private String iconUrl;
    private IsDisabled isDisabled;
    private boolean isEmiAvailable;
    private boolean isEmiHybridDisabled;
    private boolean isHybridDisabled;
    private String issuingBank;
    private String issuingBankCode;
    @c(a = "maxAmount")
    @a
    private MinAmount maxAmount;
    @c(a = "minAmount")
    @a
    private MinAmount minAmount;
    private boolean oneClickSupported;
    private PaymentOfferDetails paymentOfferDetails;
    @c(a = "priority")
    @a
    private String priority;
    private String selectedAuthMode;
    private String subventionType;

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabled isDisabled2) {
        this.isDisabled = isDisabled2;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public EmiDetails getEmiDetails() {
        return this.emiDetails;
    }

    public void setEmiDetails(EmiDetails emiDetails2) {
        this.emiDetails = emiDetails2;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public String getIssuingBank() {
        return this.issuingBank;
    }

    public void setIssuingBank(String str) {
        this.issuingBank = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String[] getAuthModes() {
        return this.authModes;
    }

    public void setAuthModes(String[] strArr) {
        this.authModes = strArr;
    }

    public HasLowSuccess getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public void setHasLowSuccess(HasLowSuccess hasLowSuccess2) {
        this.hasLowSuccess = hasLowSuccess2;
    }

    public CardDetails getCardDetails() {
        return this.cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails2) {
        this.cardDetails = cardDetails2;
    }

    public String toString() {
        return "ClassPojo [isDisabled = " + this.isDisabled + ", channelName = " + this.channelName + ", emiDetails = " + this.emiDetails + ", channelCode = " + this.channelCode + ", issuingBank = " + this.issuingBank + ", iconUrl = " + this.iconUrl + ", authModes = " + this.authModes + ", hasLowSuccess = " + this.hasLowSuccess + ", cardDetails = " + this.cardDetails + "]";
    }

    public String getSelectedAuthMode() {
        return this.selectedAuthMode;
    }

    public void setSelectedAuthMode(String str) {
        this.selectedAuthMode = str;
    }

    public String getIssuingBankCode() {
        return this.issuingBankCode;
    }

    public boolean isEmiAvailable() {
        return this.isEmiAvailable;
    }

    public void setEmiAvailable(boolean z) {
        this.isEmiAvailable = z;
    }

    public void setIssuingBankCode(String str) {
        this.issuingBankCode = str;
    }

    public PaymentOfferDetails getPaymentOfferDetails() {
        return this.paymentOfferDetails;
    }

    public void setPaymentOfferDetails(PaymentOfferDetails paymentOfferDetails2) {
        this.paymentOfferDetails = paymentOfferDetails2;
    }

    public MinAmount getMinAmount() {
        return this.minAmount;
    }

    public MinAmount getMaxAmount() {
        return this.maxAmount;
    }

    public String getSubventionType() {
        return this.subventionType;
    }

    public void setSubventionType(String str) {
        this.subventionType = str;
    }

    public boolean isOneClickSupported() {
        return Build.VERSION.SDK_INT >= 19 && this.oneClickSupported;
    }

    public boolean isHybridDisabled() {
        return this.isHybridDisabled;
    }

    public boolean isEmiHybridDisabled() {
        return this.isEmiHybridDisabled;
    }

    public String getPriority() {
        return this.priority;
    }
}
