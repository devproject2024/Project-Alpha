package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class PostpaidBalanceInfo extends CJRWalletDataModel implements IJRDataModel {
    private String currency;
    private String iconUrl;
    private String templateId;
    private String templateName;
    private String value;

    public String getTemplateId() {
        return this.templateId;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "ClassPojo [currency = " + this.currency + ", value = " + this.value + "]";
    }
}
