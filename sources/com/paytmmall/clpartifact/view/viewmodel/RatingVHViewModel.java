package com.paytmmall.clpartifact.view.viewmodel;

import android.widget.RatingBar;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableInt;
import androidx.databinding.a;
import androidx.databinding.i;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.modal.clpCommon.CJRRatingReview;
import com.paytmmall.clpartifact.view.adapter.RatingChartAdapter;
import java.util.HashMap;

public class RatingVHViewModel extends a {
    private CJRRatingReview ratingReview = new CJRRatingReview();
    private i<RedirectorModel> redirect = new i<>();
    private ObservableInt showRatingBar = new ObservableInt(8);
    private ObservableDouble storeRating;

    public i<RedirectorModel> getRedirect() {
        return this.redirect;
    }

    public RatingVHViewModel(ObservableDouble observableDouble) {
        this.storeRating = observableDouble;
    }

    public void setRatingReview(CJRRatingReview cJRRatingReview) {
        this.ratingReview = cJRRatingReview;
        notifyChange();
    }

    public Integer getId() {
        return this.ratingReview.getId();
    }

    public String getEntityType() {
        return this.ratingReview.getEntityType();
    }

    public String getEntityIdentifier() {
        return this.ratingReview.getEntityIdentifier();
    }

    public Integer getTotalRatings() {
        return this.ratingReview.getTotalRatings();
    }

    public Integer getTotalReview() {
        return this.ratingReview.getTotalReview();
    }

    public Double getAvgRating() {
        return this.ratingReview.getAvgRating();
    }

    public String getSeourl() {
        return this.ratingReview.getSeourl();
    }

    public HashMap<Integer, Integer> getLevelToRateCount() {
        return this.ratingReview.getLevelToRateCount();
    }

    public ObservableInt getShowRatingBar() {
        return this.showRatingBar;
    }

    private void setShowRatingBar(int i2) {
        this.showRatingBar.set(i2);
        notifyChange();
    }

    public void toggleRatingBar(Group group) {
        setShowRatingBar(group.getVisibility() == 0 ? 8 : 0);
    }

    public void writeAReview() {
        if (getRatingValue().get() != 0.0d) {
            this.redirect.set(new RedirectorModel(1001));
        }
    }

    public void onRatingBarClick(RatingBar ratingBar, final float f2, boolean z) {
        if (z) {
            ObservableDouble observableDouble = this.storeRating;
            final double d2 = observableDouble != null ? observableDouble.get() : 0.0d;
            ratingBar.setRating((float) d2);
            this.redirect.set(new RedirectorModel(1002, new HashMap<String, Object>() {
                {
                    put("rating", Float.valueOf(f2));
                    put("defaultRating", Double.valueOf(d2));
                }
            }));
        }
    }

    public CJRRatingReview getRatingReview() {
        return this.ratingReview;
    }

    public static void setRating(RatingBar ratingBar, Double d2) {
        if (ratingBar != null) {
            ratingBar.setRating(Float.parseFloat(String.valueOf(d2)));
        }
    }

    public RecyclerView.a getRatingAdapter() {
        HashMap<Integer, Integer> hashMap = getchartList(this.ratingReview);
        CJRRatingReview cJRRatingReview = this.ratingReview;
        return new RatingChartAdapter(hashMap, (cJRRatingReview == null || cJRRatingReview.getTotalRatings() == null) ? 1 : this.ratingReview.getTotalRatings().intValue(), this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable getDrawable(android.view.View r4, java.lang.String r5) {
        /*
            r3 = this;
            int r0 = r5.hashCode()
            r1 = 49
            r2 = 1
            if (r0 == r1) goto L_0x0018
            r1 = 50
            if (r0 == r1) goto L_0x000e
            goto L_0x0022
        L_0x000e:
            java.lang.String r0 = "2"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0022
            r5 = 1
            goto L_0x0023
        L_0x0018:
            java.lang.String r0 = "1"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0023
        L_0x0022:
            r5 = -1
        L_0x0023:
            if (r5 == 0) goto L_0x003d
            if (r5 == r2) goto L_0x0032
            android.content.Context r4 = r4.getContext()
            int r5 = com.paytmmall.clpartifact.R.drawable.clp_progress_green
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r5)
            return r4
        L_0x0032:
            android.content.Context r4 = r4.getContext()
            int r5 = com.paytmmall.clpartifact.R.drawable.clp_progress_orange
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r5)
            return r4
        L_0x003d:
            android.content.Context r4 = r4.getContext()
            int r5 = com.paytmmall.clpartifact.R.drawable.clp_progress_red
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.viewmodel.RatingVHViewModel.getDrawable(android.view.View, java.lang.String):android.graphics.drawable.Drawable");
    }

    private HashMap<Integer, Integer> getchartList(CJRRatingReview cJRRatingReview) {
        if (cJRRatingReview != null) {
            return cJRRatingReview.getLevelToRateCount();
        }
        return null;
    }

    public ObservableDouble getRatingValue() {
        return this.storeRating;
    }

    public int getRatingChartVisivility() {
        CJRRatingReview cJRRatingReview = this.ratingReview;
        return (cJRRatingReview == null || cJRRatingReview.getAvgRating() == null || this.ratingReview.getAvgRating().doubleValue() == 0.0d) ? 8 : 0;
    }
}
