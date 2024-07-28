package net.one97.paytm.nativesdk.orflow.transaction;

import android.content.Intent;
import android.view.View;

public interface BankOfferCardView {
    void onActivityResult(int i2, int i3, Intent intent);

    void onProceedClick(View view);

    void setTransactionDialogListener(TransactionDialogListener transactionDialogListener);
}
