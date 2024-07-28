package com.paytmmall.clpartifact.view.viewmodel;

import android.text.TextUtils;
import androidx.databinding.a;
import androidx.databinding.h;
import androidx.databinding.i;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.modal.ratingreview.CJRReviewDetail;
import com.paytmmall.clpartifact.modal.ratingreview.CJRReviews;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ReviewVHViewModel extends a {
    private i<RedirectorModel> redirect = new i<>();
    /* access modifiers changed from: private */
    public CJRReviews review;

    public h getRedirect() {
        return this.redirect;
    }

    public void setReviewModel(CJRReviews cJRReviews) {
        this.review = cJRReviews;
        notifyChange();
    }

    public int getRating() {
        CJRReviews cJRReviews = this.review;
        if (cJRReviews != null) {
            return cJRReviews.getRating();
        }
        return 0;
    }

    public CJRReviewDetail getReviewDetail() {
        CJRReviews cJRReviews = this.review;
        return (cJRReviews == null || cJRReviews.getReviewDetail() == null) ? new CJRReviewDetail() : this.review.getReviewDetail();
    }

    public String getReviewDate() {
        CJRReviews cJRReviews = this.review;
        return cJRReviews != null ? cJRReviews.getReviewDate() : "";
    }

    public String getName() {
        CJRReviews cJRReviews = this.review;
        return cJRReviews != null ? cJRReviews.getName() : "";
    }

    public String getDate(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.contains("T")) {
            str = str.substring(0, str.indexOf("T"));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMMM yyyy");
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        String format = date != null ? simpleDateFormat2.format(date) : "";
        if (TextUtils.isEmpty(str2)) {
            return format;
        }
        return str2 + ", " + format;
    }

    public void onReportClick() {
        this.redirect.set(new RedirectorModel(1003, new HashMap<String, Object>() {
            {
                put("review", ReviewVHViewModel.this.review);
            }
        }));
    }

    public boolean isLastItem() {
        CJRReviews cJRReviews = this.review;
        return cJRReviews != null && cJRReviews.isLastItem();
    }
}
