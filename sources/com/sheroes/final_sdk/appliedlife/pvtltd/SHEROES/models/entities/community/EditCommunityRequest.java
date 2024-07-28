package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;
import java.util.List;

public class EditCommunityRequest extends BaseRequest {
    @c(a = "community_type_id")
    @a
    private Long communityTypeId;
    @c(a = "cover_image")
    @a
    private String coverImage;
    @c(a = "description")
    @a
    private String description;
    @c(a = "id")
    @a
    private Integer id;
    @c(a = "is_active")
    @a
    private Boolean isActive;
    @c(a = "is_closed")
    @a
    private Boolean isClosed;
    @c(a = "logo_image")
    @a
    private String logo;
    @c(a = "name")
    @a
    private String name;
    @c(a = "purpose")
    @a
    private String purpose;
    @c(a = "removed_tags")
    @a
    private List<Long> removedTags = null;
    @c(a = "tags")
    @a
    private List<Long> tags = null;

    public Long getCommunityTypeId() {
        return this.communityTypeId;
    }

    public void setCommunityTypeId(Long l) {
        this.communityTypeId = l;
    }

    public String getCoverImage() {
        return this.coverImage;
    }

    public void setCoverImage(String str) {
        this.coverImage = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public Boolean getActive() {
        return this.isActive;
    }

    public void setActive(Boolean bool) {
        this.isActive = bool;
    }

    public Boolean getClosed() {
        return this.isClosed;
    }

    public void setClosed(Boolean bool) {
        this.isClosed = bool;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public void setPurpose(String str) {
        this.purpose = str;
    }

    public List<Long> getRemovedTags() {
        return this.removedTags;
    }

    public void setRemovedTags(List<Long> list) {
        this.removedTags = list;
    }

    public List<Long> getTags() {
        return this.tags;
    }

    public void setTags(List<Long> list) {
        this.tags = list;
    }
}
