package com.paytmmall.clpartifact.modal.clpCommon;

import android.text.TextUtils;
import com.google.gson.a.c;
import com.paytmmall.clpartifact.modal.ratingreview.IRatingReviewModel;
import java.util.HashMap;

public class CJRRatingReview implements IRatingReviewModel {
    @c(a = "avgRating")
    private Double avgRating;
    @c(a = "entityIdentifier")
    private String entityIdentifier;
    @c(a = "entityType")
    private String entityType;
    @c(a = "id")
    private Integer id;
    @c(a = "levelToRateCount")
    private HashMap<Integer, Integer> levelToRateCount;
    @c(a = "seourl")
    private String seourl;
    @c(a = "totalRatings")
    private Integer totalRatings;
    @c(a = "totalReview")
    private Integer totalReview;

    public int getViewType() {
        return 100;
    }

    public /* synthetic */ void setLastItem(boolean z) {
        IRatingReviewModel.CC.$default$setLastItem(this, z);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public void setEntityType(String str) {
        if (TextUtils.isEmpty(this.entityType) && !TextUtils.isEmpty(str)) {
            this.entityType = str;
        }
    }

    public String getEntityIdentifier() {
        return this.entityIdentifier;
    }

    public void setEntityIdentifier(String str) {
        if (TextUtils.isEmpty(this.entityIdentifier) && !TextUtils.isEmpty(str)) {
            this.entityIdentifier = str;
        }
    }

    public Integer getTotalRatings() {
        return this.totalRatings;
    }

    public void setTotalRatings(Integer num) {
        this.totalRatings = num;
    }

    public Integer getTotalReview() {
        return this.totalReview;
    }

    public void setTotalReview(Integer num) {
        this.totalReview = num;
    }

    public Double getAvgRating() {
        return this.avgRating;
    }

    public void setAvgRating(Double d2) {
        this.avgRating = d2;
    }

    public String getSeourl() {
        return this.seourl;
    }

    public void setSeourl(String str) {
        this.seourl = str;
    }

    public HashMap<Integer, Integer> getLevelToRateCount() {
        return this.levelToRateCount;
    }

    public void setLevelToRateCount(HashMap<Integer, Integer> hashMap) {
        this.levelToRateCount = hashMap;
    }
}
