package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;

public class CommentReactionRequestPojo extends BaseRequest {
    @c(a = "entity_id")
    @a
    private long entityId;
    @c(a = "is_active")
    @a
    private boolean isActive;
    @c(a = "is_anonymous")
    @a
    private boolean isAnonymous;
    @c(a = "list_type")
    @a
    private String listType;
    @c(a = "participation_id")
    @a
    private long participationId;
    @c(a = "search_text")
    @a
    private String searchText;
    @c(a = "comment")
    @a
    private String userComment;

    public String getUserComment() {
        return this.userComment;
    }

    public void setUserComment(String str) {
        this.userComment = str;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean z) {
        this.isActive = z;
    }

    public boolean getIsAnonymous() {
        return this.isAnonymous;
    }

    public void setIsAnonymous(boolean z) {
        this.isAnonymous = z;
    }

    public long getParticipationId() {
        return this.participationId;
    }

    public void setParticipationId(long j) {
        this.participationId = j;
    }

    public long getEntityId() {
        return this.entityId;
    }

    public void setEntityId(long j) {
        this.entityId = j;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public void setAnonymous(boolean z) {
        this.isAnonymous = z;
    }

    public String getListType() {
        return this.listType;
    }

    public void setListType(String str) {
        this.listType = str;
    }

    public String getSearchText() {
        return this.searchText;
    }

    public void setSearchText(String str) {
        this.searchText = str;
    }
}
