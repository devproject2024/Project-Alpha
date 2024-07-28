package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrderSummaryAction extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    private CJROrderSummaryActionAlert alert;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "confirmation")
    private String mConfirmation;
    @b(a = "deeplink")
    private boolean mDeepLink;
    @b(a = "icon_url")
    private String mIconUrl;
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
    @b(a = "action_name")
    private String mTrainActionName;
    @b(a = "ui_control")
    private String mUiControl;
    @b(a = "order_level")
    private boolean orderLevel;
    @b(a = "url")
    private String url;

    public String getmIconUrl() {
        return this.mIconUrl;
    }

    public void setmIconUrl(String str) {
        this.mIconUrl = str;
    }

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

    public String getActionName() {
        return this.mName;
    }

    public Boolean getOrderLevel() {
        return Boolean.valueOf(this.orderLevel);
    }

    public void setOrderLevel(Boolean bool) {
        this.orderLevel = bool.booleanValue();
    }

    public String getConfirmation() {
        return this.mConfirmation;
    }

    public String getmTrainActionName() {
        return this.mTrainActionName;
    }

    public CJROrderSummaryActionAlert getAlert() {
        return this.alert;
    }

    public class CJROrderSummaryActionAlert {
        private String cancelButton;
        private String heading;
        private String message;
        private String okbutton;
        private String title;

        public CJROrderSummaryActionAlert() {
        }

        public String getTitle() {
            return this.title;
        }

        public String getHeading() {
            return this.heading;
        }

        public String getMessage() {
            return this.message;
        }

        public String getOkbutton() {
            return this.okbutton;
        }

        public String getCancelButton() {
            return this.cancelButton;
        }
    }

    public void setmTrainActionName(String str) {
        this.mTrainActionName = str;
    }

    public boolean ismDeepLink() {
        return this.mDeepLink;
    }

    public void setmDeepLink(boolean z) {
        this.mDeepLink = z;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
