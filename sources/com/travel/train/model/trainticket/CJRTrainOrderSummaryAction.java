package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderSummaryAction extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "alert")
    private CJRTrainOrderSummaryActionAlert alert;
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
    @b(a = "type")
    private String mType;
    @b(a = "ui_control")
    private String mUiControl;
    @b(a = "urlParams")
    private CJRTrainOrderSummaryActionURLParams mUrlParams;
    @b(a = "order_level")
    private boolean orderLevel;
    @b(a = "url")
    private String url;

    public String getmIconUrl() {
        return this.mIconUrl;
    }

    public String getmText() {
        return this.mText;
    }

    public String getmTnc_text() {
        return this.mTnc_text;
    }

    public String getmTnc_url() {
        return this.mTnc_url;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getUiControl() {
        return this.mUiControl;
    }

    public CJRTrainOrderSummaryActionURLParams getUrlParams() {
        return this.mUrlParams;
    }

    public String getActionName() {
        return this.mName;
    }

    public Boolean getOrderLevel() {
        return Boolean.valueOf(this.orderLevel);
    }

    public String getConfirmation() {
        return this.mConfirmation;
    }

    public String getmTrainActionName() {
        return this.mTrainActionName;
    }

    public CJRTrainOrderSummaryActionAlert getAlert() {
        return this.alert;
    }

    public boolean ismDeepLink() {
        return this.mDeepLink;
    }

    public String getUrl() {
        return this.url;
    }

    public String getmType() {
        return this.mType;
    }
}
