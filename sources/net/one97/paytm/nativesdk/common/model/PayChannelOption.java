package net.one97.paytm.nativesdk.common.model;

public class PayChannelOption implements BaseDataModel {
    private BalanceInfo balanceInfo;
    HasLowSuccess hasLowSuccess;
    String iconUrl;
    String instId;
    String instName;
    IsDisabled isDisabled;
    boolean isSelected;
    String payChannelOption;
    String payMethod;

    public BalanceInfo getBalanceInfo() {
        return this.balanceInfo;
    }

    public void setBalanceInfo(BalanceInfo balanceInfo2) {
        this.balanceInfo = balanceInfo2;
    }

    public PayChannelOption(String str, String str2, String str3, String str4, String str5, IsDisabled isDisabled2, HasLowSuccess hasLowSuccess2) {
        this.payMethod = str;
        this.payChannelOption = str2;
        this.instId = str3;
        this.instName = str4;
        this.iconUrl = str5;
        this.isDisabled = isDisabled2;
        this.hasLowSuccess = hasLowSuccess2;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getPayChannelOption() {
        return this.payChannelOption;
    }

    public void setPayChannelOption(String str) {
        this.payChannelOption = str;
    }

    public String getInstId() {
        return this.instId;
    }

    public void setInstId(String str) {
        this.instId = str;
    }

    public String getInstName() {
        return this.instName;
    }

    public void setInstName(String str) {
        this.instName = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabled isDisabled2) {
        this.isDisabled = isDisabled2;
    }

    public HasLowSuccess getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public void setHasLowSuccess(HasLowSuccess hasLowSuccess2) {
        this.hasLowSuccess = hasLowSuccess2;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
