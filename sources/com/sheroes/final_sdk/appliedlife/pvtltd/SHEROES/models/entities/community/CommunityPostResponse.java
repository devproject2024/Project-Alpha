package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import org.parceler.Parcel;

@Parcel
public class CommunityPostResponse extends BaseResponse {
    @c(a = "category")
    @a
    private String category;
    @c(a = "community_type")
    @a
    private String community_type;
    @c(a = "id")
    @a
    private String id;
    @c(a = "is_community_closed")
    @a
    private boolean isClosedCommunity;
    @c(a = "is_owner")
    @a
    private boolean isOwner;
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

    public String getCommunity_type() {
        return this.community_type;
    }

    public void setCommunity_type(String str) {
        this.community_type = str;
    }

    public boolean isOwner() {
        return this.isOwner;
    }

    public void setOwner(boolean z) {
        this.isOwner = z;
    }

    public boolean isClosedCommunity() {
        return this.isClosedCommunity;
    }

    public void setClosedCommunity(boolean z) {
        this.isClosedCommunity = z;
    }
}
