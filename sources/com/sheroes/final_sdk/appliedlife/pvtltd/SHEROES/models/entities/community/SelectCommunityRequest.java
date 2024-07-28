package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;

public class SelectCommunityRequest extends BaseRequest {
    @c(a = "master_data_type")
    @a
    private String masterDataType;
    @c(a = "sub_type")
    @a
    private String subType;

    public String getSubType() {
        return this.subType;
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public String getMasterDataType() {
        return this.masterDataType;
    }

    public void setMasterDataType(String str) {
        this.masterDataType = str;
    }
}
