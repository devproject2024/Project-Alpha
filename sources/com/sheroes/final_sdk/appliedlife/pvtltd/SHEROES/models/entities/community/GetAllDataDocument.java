package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import org.parceler.Parcel;

@Parcel
public class GetAllDataDocument extends BaseResponse {
    @c(a = "category")
    @a
    private String category;
    @c(a = "community_type")
    @a
    private String communityType;
    @c(a = "id")
    @a
    private String id;
    private boolean isChecked;
    @c(a = "is_community_closed")
    @a
    private boolean isCommunityClosed;
    @c(a = "logo")
    @a
    private String logo;
    @c(a = "title")
    @a
    private String title;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public String getCommunityType() {
        return this.communityType;
    }

    public void setCommunityType(String str) {
        this.communityType = str;
    }

    public boolean isCommunityClosed() {
        return this.isCommunityClosed;
    }

    public void setCommunityClosed(boolean z) {
        this.isCommunityClosed = z;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }
}
