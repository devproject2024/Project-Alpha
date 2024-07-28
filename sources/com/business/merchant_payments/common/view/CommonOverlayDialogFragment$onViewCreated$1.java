package com.business.merchant_payments.common.view;

import android.app.Dialog;
import android.view.View;

public final class CommonOverlayDialogFragment$onViewCreated$1 implements View.OnClickListener {
    public final /* synthetic */ CommonOverlayDialogFragment this$0;

    public CommonOverlayDialogFragment$onViewCreated$1(CommonOverlayDialogFragment commonOverlayDialogFragment) {
        this.this$0 = commonOverlayDialogFragment;
    }

    public final void onClick(View view) {
        this.this$0.getListener().onDialogButtonClick();
        Dialog dialog = this.this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
