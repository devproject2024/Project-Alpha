package net.one97.paytm.common.entity.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryAction implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private String icon_url;
    private String image_url;
    private String label;
    @b(a = "confirmation")
    private String mConfirmation;
    private String name;
    private Boolean order_level;
    private String type;
    private String ui_control;
    private CJROrderSummaryActionURLParams urlParams;

    public Boolean getOrderLevel() {
        return this.order_level;
    }

    public void setOrderLevel(boolean z) {
        this.order_level = Boolean.valueOf(z);
    }

    public String getUi_control() {
        return this.ui_control;
    }

    public void setUi_control(String str) {
        this.ui_control = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public String getLabel() {
        return this.label;
    }

    public CJROrderSummaryActionURLParams getUrlParams() {
        return this.urlParams;
    }

    public void setmUrlParams(CJROrderSummaryActionURLParams cJROrderSummaryActionURLParams) {
        this.urlParams = cJROrderSummaryActionURLParams;
    }

    public String getConfirmation() {
        return this.mConfirmation;
    }

    public void setConfirmation(String str) {
        this.mConfirmation = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void setIcon_url(String str) {
        this.icon_url = str;
    }
}
