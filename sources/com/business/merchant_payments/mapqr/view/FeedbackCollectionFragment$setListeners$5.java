package com.business.merchant_payments.mapqr.view;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.business.merchant_payments.R;
import kotlin.g.b.k;

public final class FeedbackCollectionFragment$setListeners$5 implements View.OnClickListener {
    public final /* synthetic */ FeedbackCollectionFragment this$0;

    public FeedbackCollectionFragment$setListeners$5(FeedbackCollectionFragment feedbackCollectionFragment) {
        this.this$0 = feedbackCollectionFragment;
    }

    public final void onClick(View view) {
        ConstraintLayout constraintLayout = FeedbackCollectionFragment.access$getMBinding$p(this.this$0).clResponseBox;
        k.b(constraintLayout, "mBinding.clResponseBox");
        constraintLayout.setVisibility(8);
        FeedbackCollectionFragment.access$getMBinding$p(this.this$0);
        ConstraintLayout constraintLayout2 = FeedbackCollectionFragment.access$getMBinding$p(this.this$0).clResponseBox;
        k.b(constraintLayout2, "mBinding.clResponseBox");
        constraintLayout2.setVisibility(8);
        AppCompatImageView appCompatImageView = FeedbackCollectionFragment.access$getMBinding$p(this.this$0).ivReason2;
        k.b(appCompatImageView, "mBinding.ivReason2");
        appCompatImageView.setBackground(this.this$0.getResources().getDrawable(R.drawable.ic_radio_button_selected));
        AppCompatImageView appCompatImageView2 = FeedbackCollectionFragment.access$getMBinding$p(this.this$0).ivReason1;
        k.b(appCompatImageView2, "mBinding.ivReason1");
        appCompatImageView2.setBackground(this.this$0.getResources().getDrawable(R.drawable.ic_radio_button_deselected));
        AppCompatImageView appCompatImageView3 = FeedbackCollectionFragment.access$getMBinding$p(this.this$0).ivReasonOther;
        k.b(appCompatImageView3, "mBinding.ivReasonOther");
        appCompatImageView3.setBackground(this.this$0.getResources().getDrawable(R.drawable.ic_radio_button_deselected));
        this.this$0.setCode("reason2");
    }
}
