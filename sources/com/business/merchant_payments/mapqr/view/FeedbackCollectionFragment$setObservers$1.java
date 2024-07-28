package com.business.merchant_payments.mapqr.view;

import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.e;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.google.gson.l;
import kotlin.g.b.k;

public final class FeedbackCollectionFragment$setObservers$1<T> implements z<b<l>> {
    public final /* synthetic */ FeedbackCollectionFragment this$0;

    public FeedbackCollectionFragment$setObservers$1(FeedbackCollectionFragment feedbackCollectionFragment) {
        this.this$0 = feedbackCollectionFragment;
    }

    public final void onChanged(b<l> bVar) {
        if (bVar.f7357b.equals(e.SUCCESS)) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            instance.getDeepLinkUtils().a(this.this$0.mContext, "paytmba://business-app");
            return;
        }
        FragmentActivity activity = this.this$0.getActivity();
        k.a((Object) activity);
        Toast.makeText(activity, this.this$0.getString(R.string.mp_response_not_saved_text), 0).show();
    }
}
