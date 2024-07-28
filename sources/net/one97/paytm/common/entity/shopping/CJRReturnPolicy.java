package net.one97.paytm.common.entity.shopping;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRReturnPolicy implements IJRDataModel {
    public String cancellation_policy_icon;
    public String cancellation_policy_text;
    public String cancellation_policy_title;
    public String return_policy_icon;
    public String return_policy_text;
    public String return_policy_title;

    public String getCancellation_policy_icon() {
        return this.cancellation_policy_icon;
    }

    public void setCancellation_policy_icon(String str) {
        this.cancellation_policy_icon = str;
    }

    public String getCancellation_policy_text() {
        return this.cancellation_policy_text;
    }

    public void setCancellation_policy_text(String str) {
        this.cancellation_policy_text = str;
    }

    public String getCancellation_policy_title() {
        return this.cancellation_policy_title;
    }

    public void setCancellation_policy_title(String str) {
        this.cancellation_policy_title = str;
    }

    public String getReturn_policy_icon() {
        return this.return_policy_icon;
    }

    public void setReturn_policy_icon(String str) {
        this.return_policy_icon = str;
    }

    public String getReturn_policy_text() {
        return this.return_policy_text;
    }

    public void setReturn_policy_text(String str) {
        this.return_policy_text = str;
    }

    public String getReturn_policy_title() {
        return this.return_policy_title;
    }

    public void setReturn_policy_title(String str) {
        this.return_policy_title = str;
    }
}
