package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baserequest.BaseRequest;
import org.parceler.Parcel;

@Parcel
public class CommunityFeedRequestPojo extends BaseRequest {
    @c(a = "next_token")
    private String nextToken;

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }
}
