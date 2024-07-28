package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.viewmodel.RatingVHViewModel;

public abstract class ItemRatingBinding extends ViewDataBinding {
    public final RatingBar avgRatingBar;
    public final View divider;
    public final Group group;
    public final TextView header;
    protected RatingVHViewModel mViewModel;
    public final LayoutNoRatingReviewsAvailableBinding noRatingReviewLayout;
    public final TextView rateButton;
    public final TextView rateString;
    public final RatingBar ratingBar;
    public final RecyclerView ratingChartRv;
    public final TextView ratingCount;
    public final TextView storeRating;
    public final View view1;
    public final View view2;
    public final TextView writeReview;

    public abstract void setViewModel(RatingVHViewModel ratingVHViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ItemRatingBinding(e eVar, View view, int i2, RatingBar ratingBar2, View view3, Group group2, TextView textView, LayoutNoRatingReviewsAvailableBinding layoutNoRatingReviewsAvailableBinding, TextView textView2, TextView textView3, RatingBar ratingBar3, RecyclerView recyclerView, TextView textView4, TextView textView5, View view4, View view5, TextView textView6) {
        super(eVar, view, i2);
        this.avgRatingBar = ratingBar2;
        this.divider = view3;
        this.group = group2;
        this.header = textView;
        this.noRatingReviewLayout = layoutNoRatingReviewsAvailableBinding;
        setContainedBinding(this.noRatingReviewLayout);
        this.rateButton = textView2;
        this.rateString = textView3;
        this.ratingBar = ratingBar3;
        this.ratingChartRv = recyclerView;
        this.ratingCount = textView4;
        this.storeRating = textView5;
        this.view1 = view4;
        this.view2 = view5;
        this.writeReview = textView6;
    }

    public RatingVHViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ItemRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ItemRatingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ItemRatingBinding) f.a(layoutInflater, R.layout.item_rating, viewGroup, z, eVar);
    }

    public static ItemRatingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ItemRatingBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ItemRatingBinding) f.a(layoutInflater, R.layout.item_rating, (ViewGroup) null, false, eVar);
    }

    public static ItemRatingBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ItemRatingBinding bind(View view, e eVar) {
        return (ItemRatingBinding) bind(eVar, view, R.layout.item_rating);
    }
}
