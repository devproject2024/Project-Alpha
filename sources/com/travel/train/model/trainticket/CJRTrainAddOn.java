package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainAddOn extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "default_checked")
    private Boolean defaultChecked;
    @b(a = "description")
    private String description;
    @b(a = "enabled")
    private Boolean enabled;
    @b(a = "mandatory_opt_in")
    private Boolean mandatoryOptIn;
    @b(a = "query_param")
    private String queryParam;
    @b(a = "tip")
    private String tip;
    @b(a = "title")
    private String title;
    @b(a = "tnc_text")
    private String tncText;
    @b(a = "tnc_url")
    private String tncUrl;
    @b(a = "to_be_toggled")
    private List<Integer> toBeToggled;

    public Boolean getEnabled() {
        return this.enabled;
    }

    public Boolean getMandatoryOptIn() {
        return this.mandatoryOptIn;
    }

    public String getTitle() {
        return this.title;
    }

    public Boolean getDefaultChecked() {
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

    public List<Integer> getToBeToggled() {
        return this.toBeToggled;
    }

    public void setToBeToggled(List<Integer> list) {
        this.toBeToggled = list;
    }

    public String getQueryParam() {
        return this.queryParam;
    }
}
