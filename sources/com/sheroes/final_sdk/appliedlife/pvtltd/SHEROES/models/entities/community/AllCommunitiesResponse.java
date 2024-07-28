package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class AllCommunitiesResponse extends BaseResponse {
    @c(a = "docs")
    @a
    public List<CommunityFeedSolrObj> feedDetails = null;
}
