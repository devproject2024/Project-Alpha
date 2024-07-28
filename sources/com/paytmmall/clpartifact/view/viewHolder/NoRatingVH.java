package com.paytmmall.clpartifact.view.viewHolder;

import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.modal.ratingreview.IRatingReviewModel;
import com.paytmmall.clpartifact.view.adapter.StoreRatingAdapter;

public class NoRatingVH extends BaseRatingViewHolder {
    public static final int VIEW_TYPE = 103;
    TextView noReview;

    public NoRatingVH(ViewDataBinding viewDataBinding, StoreRatingAdapter storeRatingAdapter) {
        super(viewDataBinding);
        this.noReview = (TextView) viewDataBinding.getRoot().findViewById(R.id.no_reviews);
    }

    public static int getLayout() {
        return R.layout.layout_no_rating_reviews_available;
    }

    /* access modifiers changed from: package-private */
    public void doBinding(IRatingReviewModel iRatingReviewModel) {
        if (this.noReview != null && getAdapterPosition() == 1) {
            this.noReview.setText("No Reviews");
        }
    }
}
