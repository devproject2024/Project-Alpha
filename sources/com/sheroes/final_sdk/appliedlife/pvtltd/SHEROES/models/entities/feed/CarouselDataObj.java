package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class CarouselDataObj extends FeedDetail {
    @c(a = "body")
    private String body;
    @c(a = "endPointUrl")
    private String endPointUrl;
    @c(a = "solr_ignore_list_of_base_or_participant_model")
    @a
    private List<FeedDetail> feedDetails = null;
    @c(a = "iconUrl")
    private String iconUrl;
    @c(a = "screenTitle")
    private String screenTitle;
    @c(a = "title")
    private String title;

    public List<FeedDetail> getFeedDetails() {
        return this.feedDetails;
    }

    public void setFeedDetails(List<FeedDetail> list) {
        this.feedDetails = list;
    }

    public String getEndPointUrl() {
        return this.endPointUrl;
    }

    public void setEndPointUrl(String str) {
        this.endPointUrl = str;
    }

    public String getScreenTitle() {
        return this.screenTitle;
    }

    public void setScreenTitle(String str) {
        this.screenTitle = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }
}
