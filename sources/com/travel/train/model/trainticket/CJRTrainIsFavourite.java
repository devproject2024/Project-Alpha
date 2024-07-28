package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainIsFavourite extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "description_alias")
    private String descAlias;
    @b(a = "description")
    private String description;
    @b(a = "enabled")
    private boolean enabled;
    @b(a = "method")
    private String method;
    @b(a = "query_param")
    private String queryParam;
    @b(a = "url")
    private String url;
    @b(a = "value")
    private boolean value;

    public Boolean getEnabled() {
        return Boolean.valueOf(this.enabled);
    }

    public String getDescription() {
        return this.description;
    }

    public String getUrl() {
        return this.url;
    }

    public String getQueryParam() {
        return this.queryParam;
    }

    public String getMethod() {
        return this.method;
    }

    public Boolean getValue() {
        return Boolean.valueOf(this.value);
    }

    public void setValue(Boolean bool) {
        this.value = bool.booleanValue();
    }

    public String getDescAlias() {
        return this.descAlias;
    }
}
