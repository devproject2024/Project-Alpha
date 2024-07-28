package net.one97.paytm.addmoney.common.paymethodresponse;

import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class SavedCard implements IJRDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private CardDetail cardDetails = null;
    private String iconUrl;
    private String instId;
    private String instName;
    private String issuingBank;
    private String payChannelOption;
    private String payMethod;

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

    public String getPayChannelOption() {
        return this.payChannelOption;
    }

    public void setPayChannelOption(String str) {
        this.payChannelOption = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public CardDetail getCardDetails() {
        return this.cardDetails;
    }

    public void setCardDetails(CardDetail cardDetail) {
        this.cardDetails = cardDetail;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }

    public String getIssuingBank() {
        return this.issuingBank;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }
}
