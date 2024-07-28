package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFastForward implements IJRDataModel {
    @b(a = "button_text")
    private String button_text;
    @b(a = "check_box_text")
    private String check_box_text;
    @b(a = "cp_button_text")
    private String cp_button_text;
    @b(a = "default_checked")
    private boolean default_checked;
    @b(a = "enabled")
    private boolean enabled;
    @b(a = "tip")
    private String tip;

    public boolean isEnabled() {
        return this.enabled;
    }

    public String getCheckBoxText() {
        return this.check_box_text;
    }

    public boolean isDefaultChecked() {
        return this.default_checked;
    }

    public String getButtonText() {
        return this.button_text;
    }

    public String getTip() {
        return this.tip;
    }

    public String getCpButtonText() {
        return this.cp_button_text;
    }
}
