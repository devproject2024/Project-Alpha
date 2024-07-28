package com.business.merchant_payments.mapqr.view;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.g.b.k;

public final class FeedbackCollectionFragment$setListeners$1 implements View.OnClickListener {
    public final /* synthetic */ FeedbackCollectionFragment this$0;

    public FeedbackCollectionFragment$setListeners$1(FeedbackCollectionFragment feedbackCollectionFragment) {
        this.this$0 = feedbackCollectionFragment;
    }

    public final void onClick(View view) {
        ConstraintLayout constraintLayout = FeedbackCollectionFragment.access$getMBinding$p(this.this$0).clResponseBox;
        k.b(constraintLayout, "mBinding.clResponseBox");
        constraintLayout.setVisibility(0);
    }
}
