package net.one97.paytm.nativesdk.instruments.wallet.view;

import androidx.lifecycle.z;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.transcation.OtpEditText;

final class OtpView$observeData$1<T> implements z<String> {
    final /* synthetic */ OtpView this$0;

    OtpView$observeData$1(OtpView otpView) {
        this.this$0 = otpView;
    }

    public final void onChanged(String str) {
        Integer valueOf = str != null ? Integer.valueOf(str.length()) : null;
        if (valueOf != null && valueOf.intValue() == 6) {
            ((OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText)).setText(str);
        }
    }
}
