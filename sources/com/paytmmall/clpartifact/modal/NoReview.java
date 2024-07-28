package com.paytmmall.clpartifact.modal;

import com.paytmmall.clpartifact.modal.ratingreview.IRatingReviewModel;

public class NoReview implements IRatingReviewModel {
    public int getViewType() {
        return 103;
    }

    public /* synthetic */ void setLastItem(boolean z) {
        IRatingReviewModel.CC.$default$setLastItem(this, z);
    }
}
