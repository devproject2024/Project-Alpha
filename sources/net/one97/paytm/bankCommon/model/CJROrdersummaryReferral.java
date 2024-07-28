package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrdersummaryReferral implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "offerUrl")
    private String mOfferUrl;
    @b(a = "title")
    private String mTitle;
    @b(a = "uiControl")
    private String mUiControl;
    @b(a = "url")
    private String mUrl;

    public String getUrl() {
        return this.mUrl;
    }

    public String getOfferUrl() {
        return this.mOfferUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUiControl() {
        return this.mUiControl;
    }
}
