package net.one97.paytm.nativesdk.transcation;

import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;

final class NativePlusPayActivity$initUI$2 implements View.OnClickListener {
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$initUI$2(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    public final void onClick(View view) {
        OtpEditText otpEditText = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
        k.a((Object) otpEditText, "otpEditText");
        otpEditText.setActive(true);
    }
}
