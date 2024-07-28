package com.paytmmall.clpartifact.modal.ratingreview;

import com.google.gson.a.c;

public class CJRReviews implements IRatingReviewModel {
    @c(a = "entityIdentifier")
    private String entityIdentifier;
    @c(a = "entityType")
    private String entityType;
    @c(a = "id")
    private String id;
    private boolean isLastItem;
    @c(a = "customerName")
    private String name;
    @c(a = "rating")
    private int rating;
    @c(a = "reviewDate")
    private String reviewDate;
    @c(a = "reviewDTO")
    private CJRReviewDetail reviewDetail;

    public int getViewType() {
        return 101;
    }

    public int getRating() {
        return this.rating;
    }

    public CJRReviewDetail getReviewDetail() {
        return this.reviewDetail;
    }

    public String getReviewDate() {
        return this.reviewDate;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public String getEntityIdentifier() {
        return this.entityIdentifier;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setLastItem(boolean z) {
        this.isLastItem = z;
    }

    public boolean isLastItem() {
        return this.isLastItem;
    }
}
