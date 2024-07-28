package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;
import java.util.List;

public class CommunityRequest extends BaseRequest {
    @c(a = "community_id")
    private long communityId;
    @c(a = "reason_to_join")
    private String reasonToJoin;
    @c(a = "user_ids")
    private List<Long> userId;

    public List<Long> getUserId() {
        return this.userId;
    }

    public void setUserId(List<Long> list) {
        this.userId = list;
    }

    public long getCommunityId() {
        return this.communityId;
    }

    public void setCommunityId(long j) {
        this.communityId = j;
    }

    public String getReasonToJoin() {
        return this.reasonToJoin;
    }

    public void setReasonToJoin(String str) {
        this.reasonToJoin = str;
    }
}
