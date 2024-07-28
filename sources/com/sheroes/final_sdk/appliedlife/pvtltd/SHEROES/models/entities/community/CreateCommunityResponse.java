package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;

public class CreateCommunityResponse extends BaseResponse {
    @c(a = "doc")
    @a
    private FeedDetail feedDetail;
    @c(a = "id")
    @a
    private long id;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public FeedDetail getFeedDetail() {
        return this.feedDetail;
    }

    public void setFeedDetail(FeedDetail feedDetail2) {
        this.feedDetail = feedDetail2;
    }
}
