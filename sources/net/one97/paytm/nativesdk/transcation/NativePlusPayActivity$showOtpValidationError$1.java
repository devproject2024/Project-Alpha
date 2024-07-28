package net.one97.paytm.nativesdk.transcation;

import android.text.Editable;
import android.widget.TextView;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;

final class NativePlusPayActivity$showOtpValidationError$1 implements Runnable {
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$showOtpValidationError$1(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    public final void run() {
        OtpEditText otpEditText = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText, "otpEditText");
        Editable text = otpEditText.getText();
        if (text == null) {
            k.a();
        }
        if (text.length() == 0) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.tvInvalidOtpText);
            k.a((Object) textView, "tvInvalidOtpText");
            textView.setText(this.this$0.getString(R.string.empty_otp_error));
        } else {
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(R.id.tvInvalidOtpText);
            k.a((Object) textView2, "tvInvalidOtpText");
            textView2.setText(this.this$0.getString(R.string.invalid_otp));
        }
        TextView textView3 = (TextView) this.this$0._$_findCachedViewById(R.id.tvInvalidOtpText);
        k.a((Object) textView3, "tvInvalidOtpText");
        textView3.setVisibility(0);
    }
}
