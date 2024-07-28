package com.paytmmall.clpartifact.view.viewHolder;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.ratingreview.IRatingReviewModel;

public class DummyViewHolder extends BaseRatingViewHolder {
    public static final int VIEW_TYPE = 105;
    private View root;

    public DummyViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding);
        this.root = viewDataBinding.getRoot().findViewById(R.id.root);
    }

    public static int getLayout() {
        return R.layout.clp_item_reviews;
    }

    /* access modifiers changed from: package-private */
    public void doBinding(IRatingReviewModel iRatingReviewModel) {
        this.root.setVisibility(4);
    }
}
