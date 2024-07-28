package net.one97.paytm.addmoney.common.paymethodresponse;

import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPayChannel implements IJRDataModel {
    private CardDetail cardDetails;
    private String channelMode;
    private HasLowSuccess hasLowSuccess;
    private String iconUrl;
    private String instId;
    private String instName;
    private boolean isDefaultInstrunment;
    private IsDisabled isDisabled;
    boolean isSelected;
    private String issuingBank;
    private String payChannelOption;
    private List<PayChannelOption> payChannelOptionDetails;
    private String payMethod;
    private VpaDetails vpaDetails;

    public CJRPayChannel(SavedCard savedCard) {
        this.payMethod = savedCard.getPayMethod();
        this.instId = savedCard.getInstId();
        this.instName = savedCard.getInstName();
        this.payChannelOption = savedCard.getPayChannelOption();
        this.cardDetails = savedCard.getCardDetails();
        this.issuingBank = savedCard.getIssuingBank();
    }

    public CJRPayChannel(String str, String str2) {
        this.payChannelOption = str;
        this.channelMode = str2;
        this.payMethod = "";
    }

    public CJRPayChannel(String str, String str2, List<PayChannelOption> list, IsDisabled isDisabled2) {
        this.payChannelOption = str;
        this.channelMode = str2;
        this.payMethod = "";
        this.payChannelOptionDetails = list;
        this.isDisabled = isDisabled2;
    }

    public CJRPayChannel(SavedVPA savedVPA) {
        this.payMethod = savedVPA.getPayMethod();
        this.vpaDetails = savedVPA.getVpaDetails();
        this.instId = savedVPA.getInstId();
        this.instName = savedVPA.getInstName();
        this.payChannelOption = savedVPA.getPayChannelOption();
        this.iconUrl = savedVPA.getIconUrl();
        this.isDisabled = savedVPA.getIsDisabled();
        this.hasLowSuccess = savedVPA.getHasLowSuccess();
    }

    public void setChannelMode(String str) {
        this.channelMode = str;
    }

    public void setPayChannelOption(String str) {
        this.payChannelOption = str;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public CardDetail getCardDetails() {
        return this.cardDetails;
    }

    public String getInstId() {
        return this.instId;
    }

    public String getInstName() {
        return this.instName;
    }

    public String getPayChannelOption() {
        return this.payChannelOption;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public HasLowSuccess getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public VpaDetails getVpaDetails() {
        return this.vpaDetails;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String getChannelMode() {
        return this.channelMode;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getIssuingBank() {
        return this.issuingBank;
    }

    public List<PayChannelOption> getPayChannelOptionDetails() {
        return this.payChannelOptionDetails;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public boolean isDefaultInstrunment() {
        return this.isDefaultInstrunment;
    }

    public void setDefaultInstrunment(boolean z) {
        this.isDefaultInstrunment = z;
    }
}
