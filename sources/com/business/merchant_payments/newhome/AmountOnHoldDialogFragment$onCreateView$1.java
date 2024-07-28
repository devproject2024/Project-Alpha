package com.business.merchant_payments.newhome;

import android.app.Dialog;
import android.view.View;

public final class AmountOnHoldDialogFragment$onCreateView$1 implements View.OnClickListener {
    public final /* synthetic */ AmountOnHoldDialogFragment this$0;

    public AmountOnHoldDialogFragment$onCreateView$1(AmountOnHoldDialogFragment amountOnHoldDialogFragment) {
        this.this$0 = amountOnHoldDialogFragment;
    }

    public final void onClick(View view) {
        Dialog dialog = this.this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
