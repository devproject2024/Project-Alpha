package net.one97.paytm.nativesdk.bank_mandate.listeners;

import android.view.View;
import net.one97.paytm.nativesdk.common.listeners.BaseViewActions;

public interface MandateViewActionListener extends BaseViewActions {
    void clearAllSelection();

    void onConfirmClick();

    void scrollTo(View view);

    void selectedView();

    void setAmount(String str);

    void updateCheckBalanceLayout();
}
