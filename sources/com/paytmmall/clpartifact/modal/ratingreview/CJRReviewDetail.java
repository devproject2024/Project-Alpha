package com.paytmmall.clpartifact.modal.ratingreview;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJRReviewDetail implements Serializable {
    @c(a = "reviewDetail")
    String description;
    @c(a = "reviewHeadLine")
    String headLine;

    public String getHeadLine() {
        return this.headLine;
    }

    public void setHeadLine(String str) {
        this.headLine = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }
}
