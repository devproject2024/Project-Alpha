package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;

public class MyCommunityRequest extends BaseRequest {
    @c(a = "sub_type")
    @a
    private String subType;

    public String getSubType() {
        return this.subType;
    }

    public void setSubType(String str) {
        this.subType = str;
    }
}
