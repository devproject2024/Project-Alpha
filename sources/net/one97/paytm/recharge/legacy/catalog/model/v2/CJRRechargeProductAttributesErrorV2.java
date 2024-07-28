package net.one97.paytm.recharge.legacy.catalog.model.v2;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeProductAttributesErrorV2 implements IJRDataModel {
    private String cancelButton;
    private String message;
    private String okButton;
    private int proceed;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getProceed() {
        return this.proceed;
    }

    public void setProceed(int i2) {
        this.proceed = i2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getOkButton() {
        return this.okButton;
    }

    public void setOkButton(String str) {
        this.okButton = str;
    }

    public String getCancelButton() {
        return this.cancelButton;
    }

    public void setCancelButton(String str) {
        this.cancelButton = str;
    }
}
