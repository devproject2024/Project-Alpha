package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class FeedResponsePojo extends BaseResponse {
    @c(a = "solr_ignore_featured_docs")
    @a
    private List<FeedDetail> featuredDocs;
    @c(a = "docs")
    @a
    private List<FeedDetail> feedDetails = null;
    @c(a = "next_token")
    private String nextToken;
    @c(a = "server_feed_config_version")
    private Integer serverFeedConfigVersion;
    @c(a = "set_order_key")
    private String setOrderKey;

    public List<FeedDetail> getFeaturedDocs() {
        return this.featuredDocs;
    }

    public void setFeaturedDocs(List<FeedDetail> list) {
        this.featuredDocs = list;
    }

    public List<FeedDetail> getFeedDetails() {
        return this.feedDetails;
    }

    public void setFeedDetails(List<FeedDetail> list) {
        this.feedDetails = list;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String getSetOrderKey() {
        return this.setOrderKey;
    }

    public void setSetOrderKey(String str) {
        this.setOrderKey = str;
    }

    public Integer getServerFeedConfigVersion() {
        return this.serverFeedConfigVersion;
    }

    public void setServerFeedConfigVersion(Integer num) {
        this.serverFeedConfigVersion = num;
    }
}
