package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRReplacementAction extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    private boolean isOverlayEnabled;
    private boolean isSelected;
    @b(a = "label")
    private String mLabel;
    @b(a = "name")
    private String mName;
    @b(a = "redirectPG")
    private boolean mRedirectPG;
    @b(a = "ui_control")
    private String mUiControl;
    @b(a = "urlParams")
    private CJRReplacementURLParams mUrlParams;

    public boolean isRedirectPG() {
        return this.mRedirectPG;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getUiControl() {
        return this.mUiControl;
    }

    public CJRReplacementURLParams getUrlParams() {
        return this.mUrlParams;
    }

    public String getActionName() {
        return this.mName;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isOverlayEnabled() {
        return this.isOverlayEnabled;
    }

    public void setOverlayEnabled(boolean z) {
        this.isOverlayEnabled = z;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
