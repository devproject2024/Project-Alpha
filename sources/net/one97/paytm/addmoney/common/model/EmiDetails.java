package net.one97.paytm.addmoney.common.model;

import java.util.ArrayList;
import net.one97.paytm.addmoney.common.paymethodresponse.HasLowSuccess;
import net.one97.paytm.upi.common.models.IsDisabled;

public class EmiDetails {
    private String channelCode;
    private String channelName;
    private ArrayList<EmiChannelInfos> emiChannelInfos;
    private HasLowSuccess hasLowSuccess;
    private String iconUrl;
    private IsDisabled isDisabled;

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

    public ArrayList<EmiChannelInfos> getEmiChannelInfos() {
        return this.emiChannelInfos;
    }

    public void setEmiChannelInfos(ArrayList<EmiChannelInfos> arrayList) {
        this.emiChannelInfos = arrayList;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public HasLowSuccess getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public void setHasLowSuccess(HasLowSuccess hasLowSuccess2) {
        this.hasLowSuccess = hasLowSuccess2;
    }

    public String toString() {
        return "ClassPojo [isDisabled = " + this.isDisabled + ", channelName = " + this.channelName + ", emiChannelInfos = " + this.emiChannelInfos + ", channelCode = " + this.channelCode + ", iconUrl = " + this.iconUrl + ", hasLowSuccess = " + this.hasLowSuccess + "]";
    }
}
