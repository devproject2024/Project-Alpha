package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTrainOptOutPGCharges extends IJRPaytmDataModel {
    @b(a = "off_text")
    private String checkBoxOffText;
    @b(a = "off_text_waive_off")
    private String checkBoxOffWaiveOffText;
    @b(a = "on_text")
    private String checkBoxOnText;
    @b(a = "on_text_waive_off")
    private String checkBoxOnWaiveOffText;
    @b(a = "default_on")
    private boolean defaultSwitch;
    @b(a = "default_on_waive_off")
    private boolean defaultWaiveOffSwitch;
    @b(a = "is_waive_off_configuration")
    private Boolean isWaiveOffConfigered;
    @b(a = "to_be_toggled")
    private Integer toggleKey;

    public String getCheckBoxOnText() {
        return this.checkBoxOnText;
    }

    public String getCheckBoxOffText() {
        return this.checkBoxOffText;
    }

    public boolean isDefaultSwitch() {
        return this.defaultSwitch;
    }

    public Integer getToggleKey() {
        return this.toggleKey;
    }

    public String getCheckBoxOnWaiveOffText() {
        return this.checkBoxOnWaiveOffText;
    }

    public String getCheckBoxOffWaiveOffText() {
        return this.checkBoxOffWaiveOffText;
    }

    public boolean isDefaultWaiveOffSwitch() {
        return this.defaultWaiveOffSwitch;
    }

    public Boolean isWaiveOffConfigered() {
        return this.isWaiveOffConfigered;
    }
}
