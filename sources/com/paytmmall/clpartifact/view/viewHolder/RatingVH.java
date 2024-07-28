package com.paytmmall.clpartifact.view.viewHolder;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.h;
import androidx.databinding.i;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.modal.clpCommon.CJRRatingReview;
import com.paytmmall.clpartifact.modal.ratingreview.IRatingReviewModel;
import com.paytmmall.clpartifact.view.adapter.StoreRatingAdapter;
import com.paytmmall.clpartifact.view.viewmodel.RatingVHViewModel;

public class RatingVH extends BaseRatingViewHolder {
    public static final int VIEW_TYPE = 100;
    /* access modifiers changed from: private */
    public RatingVHViewModel viewModel;

    public static int getLayout() {
        return R.layout.item_rating;
    }

    public RatingVH(ViewDataBinding viewDataBinding, final StoreRatingAdapter storeRatingAdapter) {
        super(viewDataBinding);
        this.viewModel = new RatingVHViewModel(storeRatingAdapter.getStoreRating());
        if (this.viewModel.getRedirect() != null) {
            this.viewModel.getRedirect().addOnPropertyChangedCallback(new h.a() {
                public void onPropertyChanged(h hVar, int i2) {
                    storeRatingAdapter.redirect((RedirectorModel) ((i) hVar).get(), RatingVH.this.viewModel.getRatingReview());
                }
            });
        }
        this.viewBinding.setVariable(BR.viewModel, this.viewModel);
        this.viewBinding.executePendingBindings();
    }

    public void doBinding(IRatingReviewModel iRatingReviewModel) {
        this.viewModel.setRatingReview((CJRRatingReview) iRatingReviewModel);
    }
}
