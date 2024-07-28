package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.onboarding;

import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import org.parceler.Parcel;

@Parcel
public class LabelValue extends BaseResponse {
    @c(a = "desc")
    String desc;
    @c(a = "imgUrl")
    String imgUrl;
    private boolean isSelected;
    @c(a = "label")
    String label;
    @c(a = "value")
    long value;

    public long getValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
