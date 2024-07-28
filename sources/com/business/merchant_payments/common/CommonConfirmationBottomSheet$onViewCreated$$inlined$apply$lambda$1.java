package com.business.merchant_payments.common;

import android.view.View;
import com.business.merchant_payments.payment.listener.ChangeBankListener;
import kotlin.g.b.k;

public final class CommonConfirmationBottomSheet$onViewCreated$$inlined$apply$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ CommonConfirmationBottomSheet this$0;

    public CommonConfirmationBottomSheet$onViewCreated$$inlined$apply$lambda$1(CommonConfirmationBottomSheet commonConfirmationBottomSheet) {
        this.this$0 = commonConfirmationBottomSheet;
    }

    public final void onClick(View view) {
        if (this.this$0.listener != null) {
            ChangeBankListener access$getListener$p = this.this$0.listener;
            k.a((Object) access$getListener$p);
            access$getListener$p.setBankUpdateLead(true);
        }
        this.this$0.dismiss();
    }
}
