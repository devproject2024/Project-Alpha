package com.travel.bus.pojo;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchOperatorInfo implements IJRDataModel {
    @b(a = "count")
    private Integer count;
    @b(a = "internal_provider_operator_id")
    private Integer internalProviderOperatorId;
    @b(a = "is_grouped")
    private Boolean isGrouped;
    @b(a = "logo_url")
    private String logoUrl;
    @b(a = "name")
    private String name;
    @b(a = "provider_id")
    private Integer providerId;

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setInternalProviderOperatorId(Integer num) {
        this.internalProviderOperatorId = num;
    }

    public Boolean getIsGrouped() {
        return this.isGrouped;
    }

    public void setIsGrouped(Boolean bool) {
        this.isGrouped = bool;
    }

    public String getProviderId() {
        return String.valueOf(this.providerId);
    }

    public void setProviderId(Integer num) {
        this.providerId = num;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer num) {
        this.count = num;
    }
}
