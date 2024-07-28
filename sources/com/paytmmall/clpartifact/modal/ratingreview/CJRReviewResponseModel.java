package com.paytmmall.clpartifact.modal.ratingreview;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;

public class CJRReviewResponseModel implements Serializable {
    @c(a = "code")
    private int code;
    @c(a = "listOfReviews")
    private List<CJRReviews> reviews;
    @c(a = "totalReviews")
    private int totalReviews;

    public List<CJRReviews> getReviews() {
        return this.reviews;
    }

    public int getCode() {
        return this.code;
    }

    public int getTotalReviews() {
        return this.totalReviews;
    }
}
