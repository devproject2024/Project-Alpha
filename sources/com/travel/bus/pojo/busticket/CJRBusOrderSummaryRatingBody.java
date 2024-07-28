package com.travel.bus.pojo.busticket;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRBusOrderSummaryRatingBody extends IJRPaytmDataModel {
    @c(a = "footer")
    @a
    private CJRBusOrderSummaryRatingFooter footer;
    @c(a = "header")
    @a
    private CJRBusOrderSummaryRatingHeader header;
    @c(a = "is_editable")
    @a
    private Boolean isEditable;
    @c(a = "is_photo_post_enabled")
    @a
    private Boolean isPhotoPostEnabled;
    @c(a = "is_trip_completed")
    @a
    private Boolean isTripCompleted;
    @c(a = "channel")
    @a
    private String mChannel;
    @c(a = "secret")
    @a
    private String mSecret;
    @c(a = "rating")
    @a
    private List<CJRBusOrderSummaryRatingItem> rating = null;
    @c(a = "user_rating")
    @a
    private Integer ratingCount;

    public String getmSecret() {
        return this.mSecret;
    }

    public void setmSecret(String str) {
        this.mSecret = str;
    }

    public Integer getRatingCount() {
        return this.ratingCount;
    }

    public void setRatingCount(Integer num) {
        this.ratingCount = num;
    }

    public Boolean getIsEditable() {
        return this.isEditable;
    }

    public void setIsEditable(Boolean bool) {
        this.isEditable = bool;
    }

    public Boolean getIsPhotoPostEnabled() {
        return this.isPhotoPostEnabled;
    }

    public void setIsPhotoPostEnabled(Boolean bool) {
        this.isPhotoPostEnabled = bool;
    }

    public Boolean getIsTripCompleted() {
        return this.isTripCompleted;
    }

    public void setIsTripCompleted(Boolean bool) {
        this.isTripCompleted = bool;
    }

    public CJRBusOrderSummaryRatingHeader getHeader() {
        return this.header;
    }

    public void setHeader(CJRBusOrderSummaryRatingHeader cJRBusOrderSummaryRatingHeader) {
        this.header = cJRBusOrderSummaryRatingHeader;
    }

    public CJRBusOrderSummaryRatingFooter getFooter() {
        return this.footer;
    }

    public void setFooter(CJRBusOrderSummaryRatingFooter cJRBusOrderSummaryRatingFooter) {
        this.footer = cJRBusOrderSummaryRatingFooter;
    }

    public List<CJRBusOrderSummaryRatingItem> getRating() {
        return this.rating;
    }

    public void setRating(List<CJRBusOrderSummaryRatingItem> list) {
        this.rating = list;
    }

    public String getmChannel() {
        return this.mChannel;
    }

    public void setmChannel(String str) {
        this.mChannel = str;
    }
}
