package net.one97.paytm.addmoney.common.model;

import net.one97.paytm.addmoney.common.paymethodresponse.HasLowSuccess;
import net.one97.paytm.addmoney.common.paymethodresponse.IsDisabled;

public class SavedInstruments {
    private String[] authModes;
    private CardDetails cardDetails;
    private String channelCode;
    private String channelName;
    private EmiDetails emiDetails;
    private HasLowSuccess hasLowSuccess;
    private String iconUrl;
    private IsDisabled isDisabled;
    private String issuingBank;
    private String selectedAuthMode;

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
}
