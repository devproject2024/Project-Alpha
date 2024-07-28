package net.one97.paytm.nativesdk.orflow.transaction;

import android.view.View;

public interface TransactionDialogListener {
    View getTransactionDialogView();

    void updatePaySecurelyText(String str);
}
