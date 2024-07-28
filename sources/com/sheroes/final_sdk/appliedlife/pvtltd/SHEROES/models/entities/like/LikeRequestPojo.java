package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.like;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;

public class LikeRequestPojo extends BaseRequest {
    @c(a = "parent_participation_id")
    @a
    public Long commentId;
    @c(a = "entity_id")
    @a
    private Long entityId;
    @c(a = "value")
    @a
    private Integer reactionValue;

    public Integer getReactionValue() {
        return this.reactionValue;
    }

    public void setReactionValue(Integer num) {
        this.reactionValue = num;
    }

    public Long getEntityId() {
        return this.entityId;
    }

    public void setEntityId(Long l) {
        this.entityId = l;
    }
}
