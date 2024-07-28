package net.one97.paytm.nativesdk;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

final class FetchAuthCodeFragment$initView$4 implements View.OnClickListener {
    final /* synthetic */ FetchAuthCodeFragment this$0;

    FetchAuthCodeFragment$initView$4(FetchAuthCodeFragment fetchAuthCodeFragment) {
        this.this$0 = fetchAuthCodeFragment;
    }

    public final void onClick(View view) {
        this.this$0.dismissAllowingStateLoss();
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
