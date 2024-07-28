package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.adapter.StoreRatingAdapter;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;

public abstract class RatingReviewFragmentBinding extends ViewDataBinding {
    protected StoreRatingAdapter mAdapter;
    protected StoreRatingViewModel mModel;

    public abstract void setAdapter(StoreRatingAdapter storeRatingAdapter);

    public abstract void setModel(StoreRatingViewModel storeRatingViewModel);

    protected RatingReviewFragmentBinding(e eVar, View view, int i2) {
        super(eVar, view, i2);
    }

    public StoreRatingViewModel getModel() {
        return this.mModel;
    }

    public StoreRatingAdapter getAdapter() {
        return this.mAdapter;
    }

    public static RatingReviewFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static RatingReviewFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (RatingReviewFragmentBinding) f.a(layoutInflater, R.layout.rating_review_fragment, viewGroup, z, eVar);
    }

    public static RatingReviewFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static RatingReviewFragmentBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (RatingReviewFragmentBinding) f.a(layoutInflater, R.layout.rating_review_fragment, (ViewGroup) null, false, eVar);
    }

    public static RatingReviewFragmentBinding bind(View view) {
        return bind(view, f.a());
    }

    public static RatingReviewFragmentBinding bind(View view, e eVar) {
        return (RatingReviewFragmentBinding) bind(eVar, view, R.layout.rating_review_fragment);
    }
}
