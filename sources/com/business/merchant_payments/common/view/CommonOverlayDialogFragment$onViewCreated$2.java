package com.business.merchant_payments.common.view;

import android.app.Dialog;
import android.view.View;

public final class CommonOverlayDialogFragment$onViewCreated$2 implements View.OnClickListener {
    public final /* synthetic */ CommonOverlayDialogFragment this$0;

    public CommonOverlayDialogFragment$onViewCreated$2(CommonOverlayDialogFragment commonOverlayDialogFragment) {
        this.this$0 = commonOverlayDialogFragment;
    }

    public final void onClick(View view) {
        Dialog dialog = this.this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
