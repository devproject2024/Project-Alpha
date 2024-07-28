package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.CJRRatingReview;
import com.paytmmall.clpartifact.view.fragment.WriteAReviewBottomSheet;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;

public abstract class FragmentReviewBinding extends ViewDataBinding {
    public final ImageView closeButton;
    public final EditText comment;
    public final TextView header;
    protected WriteAReviewBottomSheet mFragment;
    protected CJRRatingReview mRatingModel;
    protected StoreRatingViewModel mViewModel;
    public final RatingBar rating;

    public abstract void setFragment(WriteAReviewBottomSheet writeAReviewBottomSheet);

    public abstract void setRatingModel(CJRRatingReview cJRRatingReview);

    public abstract void setViewModel(StoreRatingViewModel storeRatingViewModel);

    protected FragmentReviewBinding(e eVar, View view, int i2, ImageView imageView, EditText editText, TextView textView, RatingBar ratingBar) {
        super(eVar, view, i2);
        this.closeButton = imageView;
        this.comment = editText;
        this.header = textView;
        this.rating = ratingBar;
    }

    public StoreRatingViewModel getViewModel() {
        return this.mViewModel;
    }

    public WriteAReviewBottomSheet getFragment() {
        return this.mFragment;
    }

    public CJRRatingReview getRatingModel() {
        return this.mRatingModel;
    }

    public static FragmentReviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentReviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentReviewBinding) f.a(layoutInflater, R.layout.fragment_review, viewGroup, z, eVar);
    }

    public static FragmentReviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentReviewBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentReviewBinding) f.a(layoutInflater, R.layout.fragment_review, (ViewGroup) null, false, eVar);
    }

    public static FragmentReviewBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentReviewBinding bind(View view, e eVar) {
        return (FragmentReviewBinding) bind(eVar, view, R.layout.fragment_review);
    }
}
