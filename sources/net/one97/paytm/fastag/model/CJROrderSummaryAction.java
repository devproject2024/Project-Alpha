package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrderSummaryAction extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "confirmation")
    private String mConfirmation;
    @b(a = "label")
    private String mLabel;
    @b(a = "message")
    private String mMessage;
    @b(a = "name")
    private String mName;
    @b(a = "text")
    private String mText;
    @b(a = "tnc_text")
    private String mTnc_text;
    @b(a = "tnc_url")
    private String mTnc_url;
    @b(a = "ui_control")
    private String mUiControl;
    @b(a = "urlParams")
    private CJROrderSummaryActionURLParams mUrlParams;
    @b(a = "order_level")
    private Boolean orderLevel;

    public String getmText() {
        return this.mText;
    }

    public void setmText(String str) {
        this.mText = str;
    }

    public String getmTnc_text() {
        return this.mTnc_text;
    }

    public void setmTnc_text(String str) {
        this.mTnc_text = str;
    }

    public String getmTnc_url() {
        return this.mTnc_url;
    }

    public void setmTnc_url(String str) {
        this.mTnc_url = str;
    }

    public void setActionName(String str) {
        this.mName = str;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getConfirmation() {
        return this.mConfirmation;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getUiControl() {
        return this.mUiControl;
    }

    public void setmUiControl(String str) {
        this.mUiControl = str;
    }

    public CJROrderSummaryActionURLParams getUrlParams() {
        return this.mUrlParams;
    }

    public void setmUrlParams(CJROrderSummaryActionURLParams cJROrderSummaryActionURLParams) {
        this.mUrlParams = cJROrderSummaryActionURLParams;
    }

    public String getActionName() {
        return this.mName;
    }

    public Boolean getOrderLevel() {
        return this.orderLevel;
    }

    public void setOrderLevel(Boolean bool) {
        this.orderLevel = bool;
    }
}
