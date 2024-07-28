package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.view.View;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.AddMoneyFeeBottomSheet;

final class AddMoneyFeeBottomSheet$setupDialog$2 implements View.OnClickListener {
    final /* synthetic */ AddMoneyFeeBottomSheet this$0;

    AddMoneyFeeBottomSheet$setupDialog$2(AddMoneyFeeBottomSheet addMoneyFeeBottomSheet) {
        this.this$0 = addMoneyFeeBottomSheet;
    }

    public final void onClick(View view) {
        AddMoneyFeeBottomSheet.AddMoneyBottomSheetListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.onAddMoneyProceedClicked();
        }
        this.this$0.dismissAllowingStateLoss();
    }
}
