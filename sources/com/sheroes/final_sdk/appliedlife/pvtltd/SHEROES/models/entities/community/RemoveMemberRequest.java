package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;

public class RemoveMemberRequest extends BaseRequest {
    @c(a = "community_id")
    @a
    private Long communityId;
    @c(a = "user_id")
    @a
    private Long userId;

    public Long getCommunityId() {
        return this.communityId;
    }

    public void setCommunityId(Long l) {
        this.communityId = l;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }
}
