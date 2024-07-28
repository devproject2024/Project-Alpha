package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.viewmodel.ReviewVHViewModel;

public abstract class ClpItemReviewsBinding extends ViewDataBinding {
    public final TextView date;
    public final Group group;
    protected ReviewVHViewModel mViewModel;
    public final TextView rating;
    public final TextView report;
    public final TextView review;
    public final ConstraintLayout root;
    public final ImageView star;

    public abstract void setViewModel(ReviewVHViewModel reviewVHViewModel);

    protected ClpItemReviewsBinding(e eVar, View view, int i2, TextView textView, Group group2, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout, ImageView imageView) {
        super(eVar, view, i2);
        this.date = textView;
        this.group = group2;
        this.rating = textView2;
        this.report = textView3;
        this.review = textView4;
        this.root = constraintLayout;
        this.star = imageView;
    }

    public ReviewVHViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ClpItemReviewsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ClpItemReviewsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ClpItemReviewsBinding) f.a(layoutInflater, R.layout.clp_item_reviews, viewGroup, z, eVar);
    }

    public static ClpItemReviewsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ClpItemReviewsBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ClpItemReviewsBinding) f.a(layoutInflater, R.layout.clp_item_reviews, (ViewGroup) null, false, eVar);
    }

    public static ClpItemReviewsBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ClpItemReviewsBinding bind(View view, e eVar) {
        return (ClpItemReviewsBinding) bind(eVar, view, R.layout.clp_item_reviews);
    }
}
