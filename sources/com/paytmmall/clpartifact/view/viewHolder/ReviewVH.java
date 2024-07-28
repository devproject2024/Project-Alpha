package com.paytmmall.clpartifact.view.viewHolder;

import androidx.databinding.ViewDataBinding;
import androidx.databinding.h;
import androidx.databinding.i;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.modal.ratingreview.CJRReviews;
import com.paytmmall.clpartifact.modal.ratingreview.IRatingReviewModel;
import com.paytmmall.clpartifact.view.adapter.StoreRatingAdapter;
import com.paytmmall.clpartifact.view.viewmodel.ReviewVHViewModel;

public class ReviewVH extends BaseRatingViewHolder {
    public static final int VIEW_TYPE = 101;
    private ReviewVHViewModel viewModel = new ReviewVHViewModel();

    public ReviewVH(ViewDataBinding viewDataBinding, final StoreRatingAdapter storeRatingAdapter) {
        super(viewDataBinding);
        if (this.viewModel.getRedirect() != null) {
            this.viewModel.getRedirect().addOnPropertyChangedCallback(new h.a() {
                public void onPropertyChanged(h hVar, int i2) {
                    storeRatingAdapter.redirect((RedirectorModel) ((i) hVar).get(), (IRatingReviewModel) null);
                }
            });
        }
        this.viewBinding.setVariable(BR.viewModel, this.viewModel);
        this.viewBinding.executePendingBindings();
    }

    public void doBinding(IRatingReviewModel iRatingReviewModel) {
        this.viewModel.setReviewModel((CJRReviews) iRatingReviewModel);
    }

    public static int getLayout() {
        return R.layout.clp_item_reviews;
    }
}
