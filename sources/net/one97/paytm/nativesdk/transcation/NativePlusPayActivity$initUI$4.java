package net.one97.paytm.nativesdk.transcation;

import android.view.KeyEvent;
import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;

public final class NativePlusPayActivity$initUI$4 implements View.OnKeyListener {
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$initUI$4(NativePlusPayActivity nativePlusPayActivity) {
        this.this$0 = nativePlusPayActivity;
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (i2 == 66) {
            this.this$0.hideKeyboard();
            OtpEditText otpEditText = (OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText);
            k.a((Object) otpEditText, "otpEditText");
            otpEditText.setActive(false);
        }
        return false;
    }
}
