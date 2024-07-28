package net.one97.paytm.nativesdk;

import androidx.fragment.app.FragmentActivity;

final class FetchAuthCodeFragment$initView$2 implements Runnable {
    final /* synthetic */ FetchAuthCodeFragment this$0;

    FetchAuthCodeFragment$initView$2(FetchAuthCodeFragment fetchAuthCodeFragment) {
        this.this$0 = fetchAuthCodeFragment;
    }

    public final void run() {
        this.this$0.dismissAllowingStateLoss();
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
