package net.one97.paytm.nativesdk.transcation;

import android.app.AlertDialog;
import android.view.View;
import net.one97.paytm.nativesdk.R;

final class NativePlusPayActivity$showRetryDialog$1 implements View.OnClickListener {
    final /* synthetic */ AlertDialog $alertDialog;
    final /* synthetic */ NativePlusPayActivity this$0;

    NativePlusPayActivity$showRetryDialog$1(NativePlusPayActivity nativePlusPayActivity, AlertDialog alertDialog) {
        this.this$0 = nativePlusPayActivity;
        this.$alertDialog = alertDialog;
    }

    public final void onClick(View view) {
        ((OtpEditText) this.this$0._$_findCachedViewById(R.id.otpEditText)).setText("");
        this.$alertDialog.dismiss();
    }
}
