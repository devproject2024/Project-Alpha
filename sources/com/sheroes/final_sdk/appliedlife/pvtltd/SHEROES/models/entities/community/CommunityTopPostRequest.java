package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;

public class CommunityTopPostRequest extends BaseRequest {
    @c(a = "community_id")
    @a
    private Long communityId = null;
    @c(a = "creator_type")
    @a
    private String creatorType;
    @c(a = "description")
    @a
    private String description;
    @c(a = "id")
    @a
    private Long id = null;
    @c(a = "is_active")
    @a
    private boolean isActive = true;
    @c(a = "is_top_post_b")
    @a
    private boolean isTopPost;

    public Long getId() {
        return this.id;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public Long getCommunityId() {
        return this.communityId;
    }

    public void setCommunityId(Long l) {
        this.communityId = l;
    }

    public String getCreatorType() {
        return this.creatorType;
    }

    public void setCreatorType(String str) {
        this.creatorType = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    public boolean isTopPost() {
        return this.isTopPost;
    }

    public void setTopPost(boolean z) {
        this.isTopPost = z;
    }
}
