package com.paytmmall.clpartifact.view.viewHolder;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.modal.ratingreview.IRatingReviewModel;

public abstract class BaseRatingViewHolder extends RecyclerView.v {
    ViewDataBinding viewBinding;

    /* access modifiers changed from: package-private */
    public abstract void doBinding(IRatingReviewModel iRatingReviewModel);

    BaseRatingViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.viewBinding = viewDataBinding;
    }

    public final void bind(IRatingReviewModel iRatingReviewModel) {
        doBinding(iRatingReviewModel);
        this.viewBinding.executePendingBindings();
    }
}
