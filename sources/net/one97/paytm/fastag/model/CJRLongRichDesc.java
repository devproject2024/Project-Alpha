package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;

public class CJRLongRichDesc extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "attributes")
    private Map<String, String> mAttributes;
    @b(a = "description")
    private String mDescription;
    @b(a = "show_wt")
    private String mShowAsWidget;
    @b(a = "show_on_tap")
    private String mShowOnTap;
    @b(a = "title")
    private String mTitle;

    public String getShowOnTap() {
        return this.mShowOnTap;
    }

    public String getmTitle() {
        return this.mTitle;
    }

    public String getmDescription() {
        return this.mDescription;
    }

    public Map<String, String> getmAttributes() {
        return this.mAttributes;
    }

    public String getShowAsWidget() {
        return this.mShowAsWidget;
    }

    public void setmShowAsWidget(String str) {
        this.mShowAsWidget = str;
    }

    public void setAttributes(Map<String, String> map) {
        this.mAttributes = map;
    }
}
