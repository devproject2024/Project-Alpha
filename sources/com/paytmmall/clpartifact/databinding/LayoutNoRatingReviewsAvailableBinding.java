package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;

public abstract class LayoutNoRatingReviewsAvailableBinding extends ViewDataBinding {
    public final LinearLayout noRatingView;
    public final TextView noReviews;

    protected LayoutNoRatingReviewsAvailableBinding(e eVar, View view, int i2, LinearLayout linearLayout, TextView textView) {
        super(eVar, view, i2);
        this.noRatingView = linearLayout;
        this.noReviews = textView;
    }

    public static LayoutNoRatingReviewsAvailableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static LayoutNoRatingReviewsAvailableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (LayoutNoRatingReviewsAvailableBinding) f.a(layoutInflater, R.layout.layout_no_rating_reviews_available, viewGroup, z, eVar);
    }

    public static LayoutNoRatingReviewsAvailableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static LayoutNoRatingReviewsAvailableBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (LayoutNoRatingReviewsAvailableBinding) f.a(layoutInflater, R.layout.layout_no_rating_reviews_available, (ViewGroup) null, false, eVar);
    }

    public static LayoutNoRatingReviewsAvailableBinding bind(View view) {
        return bind(view, f.a());
    }

    public static LayoutNoRatingReviewsAvailableBinding bind(View view, e eVar) {
        return (LayoutNoRatingReviewsAvailableBinding) bind(eVar, view, R.layout.layout_no_rating_reviews_available);
    }
}
