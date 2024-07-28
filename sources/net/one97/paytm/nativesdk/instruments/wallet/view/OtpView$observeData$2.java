package net.one97.paytm.nativesdk.instruments.wallet.view;

import android.text.Editable;
import android.widget.TextView;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.transcation.OtpEditText;

final class OtpView$observeData$2<T> implements z<String> {
    final /* synthetic */ OtpView this$0;

    OtpView$observeData$2(OtpView otpView) {
        this.this$0 = otpView;
    }

    public final void onChanged(String str) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.tvInvalidOtpText);
        k.a((Object) textView, "tvInvalidOtpText");
        if (textView.getVisibility() == 0) {
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(R.id.tvInvalidOtpText);
            k.a((Object) textView2, "tvInvalidOtpText");
            textView2.setVisibility(8);
        }
        OtpEditText otpEditText = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText, "otpEditText");
        Editable text = otpEditText.getText();
        if (text != null && text.length() == 6) {
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            if (merchantInstance.isTransparentAppInvoke()) {
                OtpView otpView = this.this$0;
                SDKUtility.hideKeyboard(otpView, otpView.getContext());
            }
        }
    }
}
