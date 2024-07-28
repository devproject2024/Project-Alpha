package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainCancellationInsurance extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "default_checked")
    private boolean defaultChecked;
    @b(a = "description")
    private String description;
    @b(a = "enabled")
    private boolean enabled;
    @b(a = "mandatory_opt_in")
    private boolean mandatoryOptIn;
    @b(a = "tip")
    private String tip;
    @b(a = "title")
    private String title;
    @b(a = "tnc_text")
    private String tncText;
    @b(a = "tnc_url")
    private String tncUrl;

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public boolean getMandatoryOptIn() {
        return this.mandatoryOptIn;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getDefaultChecked() {
        return this.defaultChecked;
    }

    public String getTip() {
        return this.tip;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTncText() {
        return this.tncText;
    }

    public String getTncUrl() {
        return this.tncUrl;
    }
}
