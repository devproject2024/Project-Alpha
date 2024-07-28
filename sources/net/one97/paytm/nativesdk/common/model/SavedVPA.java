package net.one97.paytm.nativesdk.common.model;

import java.util.HashMap;
import java.util.Map;

public class SavedVPA implements BaseDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private HasLowSuccess hasLowSuccess;
    private String iconUrl;
    private String instId;
    private String instName;
    private IsDisabled isDisabled;
    private String payChannelOption;
    private String payMethod;
    private VpaDetails vpaDetails;

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

    public VpaDetails getVpaDetails() {
        return this.vpaDetails;
    }

    public void setVpaDetails(VpaDetails vpaDetails2) {
        this.vpaDetails = vpaDetails2;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
