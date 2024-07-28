package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;
import org.parceler.Parcel;

@Parcel
public class GetAllDataRequest extends BaseRequest {
    @c(a = "master_data_type")
    @a
    private String masterDataType;
    @c(a = "q")
    @a
    private String q;

    public String getMasterDataType() {
        return this.masterDataType;
    }

    public void setMasterDataType(String str) {
        this.masterDataType = str;
    }

    public String getQ() {
        return this.q;
    }

    public void setQ(String str) {
        this.q = str;
    }
}
