package com.business.merchant_payments.mapqr.view;

import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.business.common_module.view.widget.CustomTextInputEditText;
import com.business.merchant_payments.R;
import com.business.merchant_payments.mapqr.viewmodel.QRSurveyViewModel;
import kotlin.g.b.k;
import kotlin.m.p;

public final class FeedbackCollectionFragment$setListeners$6 implements View.OnClickListener {
    public final /* synthetic */ FeedbackCollectionFragment this$0;

    public FeedbackCollectionFragment$setListeners$6(FeedbackCollectionFragment feedbackCollectionFragment) {
        this.this$0 = feedbackCollectionFragment;
    }

    public final void onClick(View view) {
        boolean z = true;
        if (p.a(this.this$0.getCode(), "others", true)) {
            CustomTextInputEditText customTextInputEditText = FeedbackCollectionFragment.access$getMBinding$p(this.this$0).etResponse;
            k.b(customTextInputEditText, "mBinding.etResponse");
            Editable text = customTextInputEditText.getText();
            if (text == null || text.length() == 0) {
                FragmentActivity activity = this.this$0.getActivity();
                k.a((Object) activity);
                Toast.makeText(activity, this.this$0.getString(R.string.mp_comments_cant_be_empty), 0).show();
                return;
            }
        }
        String code = this.this$0.getCode();
        if (!(code == null || code.length() == 0)) {
            z = false;
        }
        if (!z) {
            QRSurveyViewModel access$getMQrSurveyViewModel$p = FeedbackCollectionFragment.access$getMQrSurveyViewModel$p(this.this$0);
            String code2 = this.this$0.getCode();
            CustomTextInputEditText customTextInputEditText2 = FeedbackCollectionFragment.access$getMBinding$p(this.this$0).etResponse;
            k.b(customTextInputEditText2, "mBinding.etResponse");
            access$getMQrSurveyViewModel$p.hitSendSurveyApi(code2, String.valueOf(customTextInputEditText2.getText()));
            return;
        }
        FragmentActivity activity2 = this.this$0.getActivity();
        k.a((Object) activity2);
        Toast.makeText(activity2, this.this$0.getString(R.string.mp_select_an_option), 0).show();
    }
}
